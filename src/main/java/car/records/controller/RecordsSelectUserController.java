package car.records.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.records.dao.RecordsDAO;
import car.records.dto.RecordsDTO;

public class RecordsSelectUserController implements Controller {
	
	private static final Log log = LogFactory.getLog(RecordsSelectUserController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		RecordsDAO recordsDAO = new RecordsDAO();
		RecordsDTO recordsDTO = new RecordsDTO();
		ArrayList<RecordsDTO> arrayList = new ArrayList<RecordsDTO>();
		
		HttpSession session = request.getSession();
		int member_code = (int) session.getAttribute("member_code");
		log.info("member_code - " + member_code);
		
		arrayList = recordsDAO.recordsSelectUser(member_code);
		request.setAttribute("arrayList", arrayList);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/records/records_select_user.jsp");
		
		return handlerAdapter;
	}

}
