package car.records.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.records.dao.RecordsDAO;
import car.records.dto.RecordsDTO;

public class RecordsDeleteController implements Controller {
	
	private static final Log log = LogFactory.getLog(RecordsDeleteController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int records_code = Integer.parseInt(request.getParameter("records_code"));
		log.info("records_code - " + records_code);
		int parking_code = Integer.parseInt(request.getParameter("parking_code"));
		String parking_name = request.getParameter("parking_name");
		
		RecordsDAO recordsDAO = new RecordsDAO();
		RecordsDTO recordsDTO = new RecordsDTO();
		
		recordsDTO.setRecords_code(records_code);
		recordsDTO.setParking_code(parking_code);
		recordsDTO.setParking_name(parking_name);
		request.setAttribute("recordsDTO", recordsDTO);
		
		recordsDAO.recordsDelete(records_code);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/records/records_delete_later.jsp");
		
		return handlerAdapter;
	}

}
