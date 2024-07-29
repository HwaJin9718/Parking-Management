package car.parkingsearch.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.parkingsearch.controller.ParkingSearchController;
import car.common.control.Controller;
import car.common.handler.HandlerAdapter;


public class ParkingSearchDispatcherServlet extends HttpServlet implements Servlet {
	private static Log log = LogFactory.getLog(ParkingSearchDispatcherServlet.class);
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
	    HandlerAdapter handlerAdapter = null;
	    Controller controller = null;
	    
	    if(pathURL.equals("/ParkingSearch.yh")) {
	        controller = new ParkingSearchController();
	        handlerAdapter = controller.execute(request, response);
	        log.info("주차장 목록 조회 확인 - " + handlerAdapter);
	    }
	    if(handlerAdapter != null) {
			if(handlerAdapter.isRedirect()) {
				response.sendRedirect(handlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(handlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}