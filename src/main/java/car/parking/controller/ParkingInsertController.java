package car.parking.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.parking.dao.ParkingDAO;
import car.parking.dto.ParkingDTO;

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
	    maxFileSize = 1024 * 1024 * 50,      // 50 MB
	    maxRequestSize = 1024 * 1024 * 100   // 100 MB
	)
public class ParkingInsertController implements Controller {
	
	private static final Log log = LogFactory.getLog(ParkingInsertController.class);
	
	private String parkingphotoPath = "/parking_management/parkingphoto";
	private String parkingdocumentPath = "/parking_management/parkingdocument";
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		int member_code = (int) session.getAttribute("member_code");
		log.info("member_code - " + member_code);
		
		String parking_name = request.getParameter("parking_name");
		log.info("parking_name - " + parking_name);
		String parking_address = request.getParameter("parking_address");
		log.info("parking_address - " + parking_address);
		double parking_latitude = Double.parseDouble(request.getParameter("parking_latitude"));
		log.info("parking_latitude - " + parking_latitude);
		double parking_longitude = Double.parseDouble(request.getParameter("parking_longitude"));
		log.info("parking_longitude - " + parking_longitude);
		String parking_operation = request.getParameter("parking_operation");
		log.info("parking_operation - " + parking_operation);
		String parking_type = request.getParameter("parking_type");
		log.info("parking_type - " + parking_type);
		String parking_total_spaces = request.getParameter("parking_total_spaces");
		log.info("parking_total_spaces - " + parking_total_spaces);
		String parking_electriccar_check = request.getParameter("parking_electriccar_check");
		log.info("parking_electriccar_check - " + parking_electriccar_check);
		String parking_electriccar_spaces = request.getParameter("parking_electriccar_spaces");
		log.info("parking_electriccar_spaces - " + parking_electriccar_spaces);
		String parking_pay_type = request.getParameter("parking_pay_type");
		log.info("parking_pay_type - " + parking_pay_type);
		String parking_base_fee = request.getParameter("parking_base_fee");
		log.info("parking_base_fee - " + parking_base_fee);
		String parking_hourly_rate = request.getParameter("parking_hourly_rate");
		log.info("parking_hourly_rate - " + parking_hourly_rate);
		
		String parking_photo1_name = null;
		String parking_photo1_path = null;
		String parking_photo2_name = null;
		String parking_photo2_path = null;
		String parking_photo3_name = null;
		String parking_photo3_path = null;
		String parking_photo4_name = null;
		String parking_photo4_path = null;
		String parking_photo5_name = null;
		String parking_photo5_path = null;
		
		String parking_document_name = null;
		String parking_document_path = null;
		
		try {
			
			Collection<Part> parts = request.getParts();
			int photoCount = 1;
			
			for (Part part : parts) {
				
				String name = part.getName();
				
				if (name != null && (name.startsWith("parking_photo") || name.equals("parking_document"))) {
					
					String fileName = getFileName(part);
					log.info("fileName - " + fileName);
					
					if (fileName != null && !fileName.isEmpty()) {
						
						String imagePath;
						
						if (name.equals("parking_document")) {
							String documentFolderPath = parkingdocumentPath + File.separator + member_code;
							createFolder(documentFolderPath);
							imagePath = documentFolderPath + File.separator + fileName;
						} else {
							String photoFolderPath = parkingphotoPath + File.separator + member_code;
							createFolder(photoFolderPath);
							imagePath = photoFolderPath + File.separator + fileName;
						}
						
						try (InputStream input = part.getInputStream()) {
			                Files.copy(input, Paths.get(imagePath), StandardCopyOption.REPLACE_EXISTING);
			            }
						
						if (name.equals("parking_document")) {
							parking_document_name = fileName;
							parking_document_path = imagePath;
						} else {
							switch (photoCount) {
							case 1:
								parking_photo1_name = fileName;
								parking_photo1_path = imagePath;
								break;
							case 2:
								parking_photo2_name = fileName;
								parking_photo2_path = imagePath;
								break;
							case 3:
								parking_photo3_name = fileName;
								parking_photo3_path = imagePath;
								break;
							case 4:
								parking_photo4_name = fileName;
								parking_photo4_path = imagePath;
								break;
							case 5:
								parking_photo5_name = fileName;
								parking_photo5_path = imagePath;
								break;
							}
							photoCount++;
						}
						
					}
					
				}
				
			}
			
		} catch (IOException | ServletException e) {
			log.info("ParkingInsertController Collection<Part> 오류 - " + e);
			e.printStackTrace();
		}
		
		
		ParkingDAO parkingDAO = new ParkingDAO();
		ParkingDTO parkingDTO = new ParkingDTO();
		
		parkingDTO.setParking_name(parking_name);
		parkingDTO.setParking_address(parking_address);
		parkingDTO.setParking_latitude(parking_latitude);
		parkingDTO.setParking_longitude(parking_longitude);
		parkingDTO.setParking_operation(parking_operation);
		parkingDTO.setParking_type(parking_type);
		parkingDTO.setParking_total_spaces(parking_total_spaces);
		parkingDTO.setParking_electriccar_check(parking_electriccar_check);
		parkingDTO.setParking_electriccar_spaces(parking_electriccar_spaces);
		parkingDTO.setParking_pay_type(parking_pay_type);
		parkingDTO.setParking_base_fee(parking_base_fee);
		parkingDTO.setParking_hourly_rate(parking_hourly_rate);
		parkingDTO.setParking_photo1_name(parking_photo1_name);
		parkingDTO.setParking_photo1_path(parking_photo1_path);
		parkingDTO.setParking_photo2_name(parking_photo2_name);
		parkingDTO.setParking_photo2_path(parking_photo2_path);
		parkingDTO.setParking_photo3_name(parking_photo3_name);
		parkingDTO.setParking_photo3_path(parking_photo3_path);
		parkingDTO.setParking_photo4_name(parking_photo4_name);
		parkingDTO.setParking_photo4_path(parking_photo4_path);
		parkingDTO.setParking_photo5_name(parking_photo5_name);
		parkingDTO.setParking_photo5_path(parking_photo5_path);
		parkingDTO.setParking_document_name(parking_document_name);
		parkingDTO.setParking_document_path(parking_document_path);
		parkingDTO.setMember_code(member_code);
		
		parkingDAO.parkingInsert(parkingDTO);
		request.setAttribute("parkingDTO", parkingDTO);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/parking/parking_insert.jsp");
		
		return handlerAdapter;
	}
	
	private String getFileName(Part part) {
		
	    String contentDispositionHeader = part.getHeader("content-disposition");
	    String[] elements = contentDispositionHeader.split(";");
	    
	    for (String element : elements) {
	        if (element.trim().startsWith("filename")) {
	            return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    
	    return null;
	}
	
	private void createFolder(String folderPath) {
		File file = new File(folderPath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

}
