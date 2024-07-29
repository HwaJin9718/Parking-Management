package car.ticket.dto;

public class TicketDTO {
	private int ticket_code;
	private String ticket_type;
	private String ticket_name;
	private String ticket_days;
	private String ticket_time;
	private String ticket_price;
	public int getTicket_code() {
		return ticket_code;
	}
	public void setTicket_code(int ticket_code) {
		this.ticket_code = ticket_code;
	}
	public String getTicket_type() {
		return ticket_type;
	}
	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}
	public String getTicket_name() {
		return ticket_name;
	}
	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}
	public String getTicket_days() {
		return ticket_days;
	}
	public void setTicket_days(String ticket_days) {
		this.ticket_days = ticket_days;
	}
	public String getTicket_time() {
		return ticket_time;
	}
	public void setTicket_time(String ticket_time) {
		this.ticket_time = ticket_time;
	}
	public String getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(String ticket_price) {
		this.ticket_price = ticket_price;
	}
	@Override
	public String toString() {
		return "TicketDTO [ticket_code=" + ticket_code + ", ticket_type=" + ticket_type + ", ticket_name=" + ticket_name
				+ ", ticket_days=" + ticket_days + ", ticket_time=" + ticket_time + ", ticket_price=" + ticket_price
				+ "]";
	}
	
	
}
