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

public class TicketInsertController implements Controller {
	private static Log log = LogFactory.getLog(TicketInsertController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String ticket_type = request.getParameter("ticket_type");
		String ticket_name = request.getParameter("ticket_name");
		String ticket_days = request.getParameter("ticket_days");
		String ticket_time = request.getParameter("ticket_time");
		String ticket_price = request.getParameter("ticket_price");
		
		
		TicketDAO ticketDAO = new TicketDAO();
		TicketDTO ticketDTO = new TicketDTO();
		ArrayList<TicketDTO> arrayList = new ArrayList<TicketDTO>();
		arrayList = ticketDAO.ticketSearch();
		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);
		
		ticketDTO.setTicket_type(ticket_type);
		ticketDTO.setTicket_name(ticket_name);
		ticketDTO.setTicket_days(ticket_days);
		ticketDTO.setTicket_time(ticket_time);
		ticketDTO.setTicket_price(ticket_price);
		
		ticketDTO = ticketDAO.ticketInsert(ticketDTO);
		log.info(ticketDTO);
		request.setAttribute("ticketDTO", ticketDTO);
		log.info("정기권 정보 등록");
		HandlerAdapter ticketHandlerAdapter = new HandlerAdapter();
		ticketHandlerAdapter.setPath("/WEB-INF/view/ticket/ticket_insert_view.jsp");
		return ticketHandlerAdapter;
	}

}
