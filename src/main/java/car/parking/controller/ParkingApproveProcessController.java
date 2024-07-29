package car.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.parking.dao.ParkingDAO;
import car.parking.dto.ParkingDTO;

public class ParkingApproveProcessController implements Controller {
	
	private static final Log log = LogFactory.getLog(ParkingApproveProcessController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int parking_code = Integer.parseInt(request.getParameter("parking_code"));
		log.info("parking_code - " + parking_code);
		String parking_approval = request.getParameter("parking_approval");
		log.info("parking_approval - " + parking_approval);
		
		ParkingDAO parkingDAO = new ParkingDAO();
		ParkingDTO parkingDTO = new ParkingDTO();
		
		parkingDTO.setParking_code(parking_code);
		parkingDTO.setParking_approval(parking_approval);
		
		parkingDAO.parkingApprove(parkingDTO);
		request.setAttribute("parkingDTO", parkingDTO);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/parking/parking_approve_later.jsp");
		
		return handlerAdapter;
	}

}
