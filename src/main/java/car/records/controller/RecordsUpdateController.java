package car.records.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.records.dao.RecordsDAO;
import car.records.dto.RecordsDTO;

public class RecordsUpdateController implements Controller {
	
	private static final Log log = LogFactory.getLog(RecordsUpdateController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int records_code = Integer.parseInt(request.getParameter("records_code"));
		log.info("records_code - " + records_code);
		
		RecordsDAO recordsDAO = new RecordsDAO();
		RecordsDTO recordsDTO = new RecordsDTO();
		
		recordsDTO = recordsDAO.recordsSelectDetailParking(records_code);
		request.setAttribute("recordsDTO", recordsDTO);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/records/records_update_input.jsp");
		
		return handlerAdapter;
	}

}
