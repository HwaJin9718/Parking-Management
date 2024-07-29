package car.records.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.records.dao.RecordsDAO;
import car.records.dto.RecordsDTO;

public class RecordsSelectParkingController implements Controller {
	
	private static final Log log = LogFactory.getLog(RecordsSelectParkingController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int parking_code = Integer.parseInt(request.getParameter("parking_code"));
		log.info("parking_code - " + parking_code);
		String parking_name = request.getParameter("parking_name");
		log.info("parking_name - " + parking_name);
		
		RecordsDAO recordsDAO = new RecordsDAO();
		RecordsDTO recordsDTO = new RecordsDTO();
		ArrayList<RecordsDTO> arrayList = new ArrayList<RecordsDTO>();
		
		arrayList = recordsDAO.recordsSelectParking(parking_code);
		request.setAttribute("arrayList", arrayList);
		request.setAttribute("parking_code", parking_code);
		request.setAttribute("parking_name", parking_name);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/records/records_select_parking.jsp");
		
		return handlerAdapter;
	}

}
