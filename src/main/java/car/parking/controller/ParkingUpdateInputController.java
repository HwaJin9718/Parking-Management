package car.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.parking.dao.ParkingDAO;
import car.parking.dto.ParkingDTO;

public class ParkingUpdateInputController implements Controller {
	
	private static final Log log = LogFactory.getLog(ParkingUpdateInputController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		int member_code = (int) session.getAttribute("member_code");
		log.info("member_code - " + member_code);
		
		int parking_code = Integer.parseInt(request.getParameter("parking_code"));
		String parking_name = request.getParameter("parking_name");
		log.info(parking_name);
		String parking_address = request.getParameter("parking_address");
		log.info(parking_address);
		double parking_latitude = Double.parseDouble(request.getParameter("parking_latitude"));
		double parking_longitude = Double.parseDouble(request.getParameter("parking_longitude"));
		String parking_operation = request.getParameter("parking_operation");
		String parking_type = request.getParameter("parking_type");
		String parking_total_spaces = request.getParameter("parking_total_spaces");
		String parking_electriccar_check = request.getParameter("parking_electriccar_check");
		String parking_electriccar_spaces = request.getParameter("parking_electriccar_spaces");
		String parking_pay_type = request.getParameter("parking_pay_type");
		String parking_base_fee = request.getParameter("parking_base_fee");
		String parking_hourly_rate = request.getParameter("parking_hourly_rate");
		
		ParkingDAO parkingDAO = new ParkingDAO();
		ParkingDTO parkingDTO = new ParkingDTO();
		
		parkingDTO.setParking_code(parking_code);;
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
		parkingDTO.setMember_code(member_code);
		
		parkingDAO.parkingUpdate(parkingDTO);
		request.setAttribute("parkingDTO", parkingDTO);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/parking/parking_update.jsp");
		
		return handlerAdapter;
	}

}
