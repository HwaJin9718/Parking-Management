package car.parking.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.parking.dao.ParkingDAO;
import car.parking.dto.ParkingDTO;

public class ParkingSelectAdminController implements Controller {
	
	private static final Log log = LogFactory.getLog(ParkingSelectAdminController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		ParkingDAO parkingDAO = new ParkingDAO();
		ParkingDTO parkingDTO = new ParkingDTO();
		ArrayList<ParkingDTO> arrayList = new ArrayList<ParkingDTO>();
		
		arrayList = parkingDAO.parkingSelectAdmin(); 
		request.setAttribute("arrayList", arrayList);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		log.info("Controller admin 전체 주차장 조회");
		handlerAdapter.setPath("/WEB-INF/view/parking/parking_select_admin.jsp");
		
		return handlerAdapter;
	}

}
