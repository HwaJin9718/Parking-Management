package car.ticket.service;

import java.util.ArrayList;

import car.ticket.dto.TicketDTO;

public interface TicketService {
	public ArrayList<TicketDTO> ticketSearch();
	public TicketDTO ticketDetailSearch(int ticket_code);
	public TicketDTO ticketInsert(TicketDTO ticketDTO);
	public TicketDTO ticketUpdate(TicketDTO ticketDTO);
	public TicketDTO ticketDelete(int ticket_code);
	public ArrayList<TicketDTO> ticketlistdays();
	public ArrayList<TicketDTO> ticketlisttime();
	
}
