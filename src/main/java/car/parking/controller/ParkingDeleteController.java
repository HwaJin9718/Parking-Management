package car.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.parking.dao.ParkingDAO;
import car.parking.dto.ParkingDTO;

public class ParkingDeleteController implements Controller {
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int parking_code = Integer.parseInt(request.getParameter("parking_code"));
		
		ParkingDAO parkingDAO = new ParkingDAO();
		ParkingDTO parkingDTO = new ParkingDTO();
		
		parkingDTO.setParking_code(parking_code);
		request.setAttribute("parkingDTO", parkingDTO);
		
		parkingDAO.parkingDelete(parking_code);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/parking/parking_delete_later.jsp");
		
		return handlerAdapter;
	}

}
