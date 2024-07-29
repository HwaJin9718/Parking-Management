package car.parkingsearch.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.parkingsearch.dao.ParkingSearchDAO;
import car.parkingsearch.dto.ParkingSearchDTO;
import car.common.control.Controller;
import car.common.handler.HandlerAdapter;

public class ParkingSearchController implements Controller {
	private static Log log = LogFactory.getLog(ParkingSearchController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String keyword = request.getParameter("keyword"); // 검색어 가져오기
		log.info("keyword - " + keyword);
        request.setAttribute("keyword", keyword);
		
		ParkingSearchDAO parkingSearchDAO = new ParkingSearchDAO();
		ArrayList<ParkingSearchDTO> arrayList = parkingSearchDAO.parkingSearch();
		request.setAttribute("arrayList", arrayList);
		log.info("데이터 전달 확인 - " + arrayList);
		HandlerAdapter ticketHandlerAdapter = new HandlerAdapter();
		ticketHandlerAdapter.setPath("/WEB-INF/view/parkingsearch/main.jsp");
		return ticketHandlerAdapter;
	}
	
	
}
