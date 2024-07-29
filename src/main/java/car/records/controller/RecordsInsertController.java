package car.records.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.records.dao.RecordsDAO;
import car.records.dto.RecordsDTO;

public class RecordsInsertController implements Controller {
	
	private static final Log log = LogFactory.getLog(RecordsInsertController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int parking_code = Integer.parseInt(request.getParameter("parking_code"));
		log.info("parking_code - " + parking_code);
		String parking_name = request.getParameter("parking_name");
		int member_code = Integer.parseInt(request.getParameter("member_code"));
		String member_car_num = request.getParameter("member_car_num");
		
		RecordsDAO recordsDAO = new RecordsDAO();
		RecordsDTO recordsDTO = new RecordsDTO();
		
		recordsDTO.setParking_code(parking_code);
		recordsDTO.setParking_name(parking_name);
		recordsDTO.setMember_code(member_code);
		recordsDTO.setMember_car_num(member_car_num);
		
		recordsDAO.recordsInsert(recordsDTO);
		request.setAttribute("recordsDTO", recordsDTO);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/records/records_insert.jsp");
		
		
		return handlerAdapter;
	}

}
