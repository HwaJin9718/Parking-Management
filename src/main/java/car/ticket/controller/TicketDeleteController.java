package car.ticket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.ticket.dao.TicketDAO;
import car.ticket.dto.TicketDTO;
import car.common.handler.HandlerAdapter;

public class TicketDeleteController implements Controller  {
	private static Log log = LogFactory.getLog(TicketDeleteController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int ticket_code = Integer.parseInt(request.getParameter("ticket_code"));
		TicketDAO ticketDAO = new TicketDAO();
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setTicket_code(ticket_code);
		request.setAttribute("ticketDTO", ticketDTO);
		ticketDTO = ticketDAO.ticketDelete(ticket_code);
		log.info(ticketDTO);
		HandlerAdapter ticketHandlerAdapter = new HandlerAdapter();
		ticketHandlerAdapter.setPath("/WEB-INF/view/ticket/ticket_delete_view.jsp");
		return ticketHandlerAdapter;
	}
}
