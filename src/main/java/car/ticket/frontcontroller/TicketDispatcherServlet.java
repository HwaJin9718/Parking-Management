package car.ticket.frontcontroller;

import java.io.IOException;
//import java.lang.ModuleLayer.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.ticket.controller.TicketDeleteController;
import car.ticket.controller.TicketDetailSearchController;
import car.ticket.controller.TicketInsertController;
import car.ticket.controller.TicketListDaysController;
import car.ticket.controller.TicketListTimeController;
import car.ticket.controller.TicketSearchController;
import car.ticket.controller.TicketUpdateController;
import car.ticket.controller.TicketUpdateViewController;

public class TicketDispatcherServlet extends HttpServlet implements Servlet {
	private static Log log = LogFactory.getLog(TicketDispatcherServlet.class);
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());
		log.info("매핑명 조회 - " + pathURL);
		HandlerAdapter ticketHandlerAdapter = null;
		Controller controller = null;
		
		if(pathURL.equals("/TicketSearch.hk")) {
			controller = new TicketSearchController();
			ticketHandlerAdapter = controller.execute(request, response);
			log.info("정기권 목록 조회 확인 - " + ticketHandlerAdapter);
		}
		else if(pathURL.equals("/TicketDetailSearch.hk")) {
			controller = new TicketDetailSearchController();
			ticketHandlerAdapter = controller.execute(request, response);
			log.info("정기권 상세내역 확인 - " + ticketHandlerAdapter);
		}
		else if(pathURL.equals("/TicketInsertView.hk")) {
			ticketHandlerAdapter = new HandlerAdapter();
			ticketHandlerAdapter.setPath("/WEB-INF/view/ticket/ticket_insert.jsp");
			log.info("정기권 등록 화면 뷰 확인 - " + ticketHandlerAdapter);
		}
		else if(pathURL.equals("/TicketInsert.hk")) {
			controller = new TicketInsertController();
			ticketHandlerAdapter = controller.execute(request, response);
			log.info("정기권 등록 확인 - " + ticketHandlerAdapter);
		}
		else if(pathURL.equals("/TicketUpdateView.hk")) {
			controller = new TicketUpdateViewController();
			ticketHandlerAdapter = controller.execute(request, response);
			log.info("정기권 수정 화면 뷰 확인 - " + ticketHandlerAdapter);
		}
		else if(pathURL.equals("/TicketUpdate.hk")) {
			controller = new TicketUpdateController();
			ticketHandlerAdapter = controller.execute(request, response);
			log.info("정기권 수정 확인 - " + ticketHandlerAdapter);
		}
		else if(pathURL.equals("/TicketDeleteView.hk")) {
			ticketHandlerAdapter = new HandlerAdapter();
			ticketHandlerAdapter.setPath("/WEB-INF/view/ticket/ticket_delete.jsp");
			log.info("정기권 삭제 뷰 확인 - " + ticketHandlerAdapter);
		}
		else if(pathURL.equals("/TicketDelete.hk")) {
			controller = new TicketDeleteController();
			ticketHandlerAdapter = controller.execute(request, response);
			log.info("정기권 삭제 확인 - " + ticketHandlerAdapter);
		}
		else if(pathURL.equals("/TicketListDays.hk")) {
			controller = new TicketListDaysController();
			ticketHandlerAdapter = controller.execute(request, response);
			log.info("정기권 구매목록 조회 확인 - " + ticketHandlerAdapter);
		}
		else if(pathURL.equals("/TicketListTime.hk")) {
			controller = new TicketListTimeController();
			ticketHandlerAdapter = controller.execute(request, response);
			log.info("정기권 구매목록 조회 확인 - " + ticketHandlerAdapter);
		}
		if(ticketHandlerAdapter != null) {
			if(ticketHandlerAdapter.isRedirect()) {
				response.sendRedirect(ticketHandlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(ticketHandlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

}
