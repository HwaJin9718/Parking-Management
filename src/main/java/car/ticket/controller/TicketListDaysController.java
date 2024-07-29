package car.ticket.controller;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.ticket.dao.TicketDAO;
import car.ticket.dto.TicketDTO;
import car.common.handler.HandlerAdapter;

public class TicketListDaysController implements Controller {

	private static Log log = LogFactory.getLog(TicketListDaysController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
	    TicketDAO ticketDAO = new TicketDAO();
	    ArrayList<TicketDTO> arrayList = ticketDAO.ticketlistdays(); 
	    log.info("arrayList - " + arrayList);
	    request.setAttribute("arrayList", arrayList); 
	    
	    HandlerAdapter ticketHandlerAdapter = new HandlerAdapter();
	    log.info("정기권 목록 조회");
	    ticketHandlerAdapter.setPath("/WEB-INF/view/ticket/ticket_purchase_listdays.jsp");
	    return ticketHandlerAdapter;
	}
}
