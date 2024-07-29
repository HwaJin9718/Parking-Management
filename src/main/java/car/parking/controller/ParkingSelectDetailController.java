package car.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.parking.dao.ParkingDAO;
import car.parking.dto.ParkingDTO;

public class ParkingSelectDetailController implements Controller {
	
	private static final Log log = LogFactory.getLog(ParkingSelectDetailController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int parking_code = Integer.parseInt(request.getParameter("parking_code"));
		log.info("parking_code - " + parking_code);
		
		ParkingDAO parkingDAO = new ParkingDAO();
		ParkingDTO parkingDTO = new ParkingDTO();
		
		parkingDTO = parkingDAO.parkingSelectDetail(parking_code);
		request.setAttribute("parkingDTO", parkingDTO);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/parking/parking_select_detail.jsp");
		
		return handlerAdapter;
	}

}
