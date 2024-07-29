package car.ticket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.ticket.dao.TicketDAO;
import car.ticket.dto.TicketDTO;
import car.common.handler.HandlerAdapter;

public class TicketUpdateViewController implements Controller{
	private static Log log = LogFactory.getLog(TicketUpdateViewController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int ticket_code = Integer.parseInt(request.getParameter("ticket_code"));
		String ticket_type = request.getParameter("ticket_type");
		String ticket_name = request.getParameter("ticket_name");
		String ticket_days = request.getParameter("ticket_days");
		String ticket_time = request.getParameter("ticket_time");
		String ticket_price = request.getParameter("ticket_price");
		
		TicketDAO ticketDAO = new TicketDAO();
		TicketDTO ticketDTO = new TicketDTO();
		
		ticketDTO.setTicket_code(ticket_code);
		ticketDTO.setTicket_type(ticket_type);
		ticketDTO.setTicket_name(ticket_name);
		ticketDTO.setTicket_days(ticket_days);
		ticketDTO.setTicket_time(ticket_time);
		ticketDTO.setTicket_price(ticket_price);
		ticketDTO = ticketDAO.ticketUpdate(ticketDTO);
		log.info(ticketDTO);
		
		request.setAttribute("ticketDTO", ticketDTO);
		HandlerAdapter ticketHandlerAdapter = new HandlerAdapter();
		ticketHandlerAdapter.setPath("/WEB-INF/view/ticket/ticket_update_view.jsp");
		return ticketHandlerAdapter;
	}

}
