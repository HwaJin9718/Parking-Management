package car.calculate.frontcontroller;

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

import car.calculate.controller.CalculateFeeByIdController;
import car.common.control.Controller;
import car.common.handler.HandlerAdapter;


public class CalculateDispatcherServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(CalculateDispatcherServlet.class);
	
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
		
		
		if(pathURL.equals("/CalculateSearchId.ca")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/calculate/calculate_insert.jsp");
			log.info("정산 조회 입력 뷰 - " + handlerAdapter);
		}
		else if(pathURL.equals("/CalculateSearchIdDo.ca")) {
			controller = new CalculateFeeByIdController();
			handlerAdapter = controller.execute(request, response);
			log.info("정산 조회 화면 뷰 - " + handlerAdapter);
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
