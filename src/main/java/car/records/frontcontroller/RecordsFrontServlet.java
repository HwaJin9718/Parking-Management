package car.records.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.records.controller.RecordsDeleteController;
import car.records.controller.RecordsInsertController;
import car.records.controller.RecordsSelectDetailParkingController;
import car.records.controller.RecordsSelectDetailUserController;
import car.records.controller.RecordsSelectParkingCodeController;
import car.records.controller.RecordsSelectParkingController;
import car.records.controller.RecordsSelectUserController;
import car.records.controller.RecordsUpdateController;
import car.records.controller.RecordsUpdateInputController;

public class RecordsFrontServlet extends HttpServlet {
	
	private static final Log log = LogFactory.getLog(RecordsFrontServlet.class);
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setCharacterEncoding("UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());
		log.info("맵핑명 조회 - " + pathURL);
		
		HandlerAdapter handlerAdapter = null;
		Controller controller = null;
		
		if (pathURL.equals("/RecordsSelectUser.hw")) {
			
			controller = new RecordsSelectUserController();
			handlerAdapter = controller.execute(request, response);
			log.info("FrontServlet 주차기록 사용자 조회 - " + handlerAdapter);
			
		} 
		
		else if(pathURL.equals("/RecordsSelectParkingCode.hw")) {
			
			controller = new RecordsSelectParkingCodeController();
			handlerAdapter = controller.execute(request, response);
			log.info("FrontServlet 관리자 주차장 코드 번호 조회 - " + handlerAdapter);
			
		}
		
		else if(pathURL.equals("/RecordsSelectParking.hw")) {
			
			controller = new RecordsSelectParkingController();
			handlerAdapter = controller.execute(request, response);
			log.info("FrontServlet 주차기록 관리자 조회 - " + handlerAdapter);
			
		}
		
		else if(pathURL.equals("/RecordsSelectDetailUser.hw")) {
			
			controller = new RecordsSelectDetailUserController();
			handlerAdapter = controller.execute(request, response);
			log.info("FrontServlet 주차기록 상세 조회(user) - " + handlerAdapter);
			
		} 
		
		else if(pathURL.equals("/RecordsSelectDetailParking.hw")) {
			
			controller = new RecordsSelectDetailParkingController();
			handlerAdapter = controller.execute(request, response);
			log.info("FrontServlet 주차기록 상세 조회(parking) - " + handlerAdapter);
			
		} 
		
		else if(pathURL.equals("/RecordsInsertInput.hw")) {
			
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/records/records_insert_input.jsp");
			log.info("FrontServlet 주차기록 등록 화면(input) - " + handlerAdapter);
			
		} 
		
		else if(pathURL.equals("/RecordsInsert.hw")) {
			
			controller = new RecordsInsertController();
			handlerAdapter = controller.execute(request, response);
			log.info("FrontServlet 주차기록 등록 화면 - " + handlerAdapter);
			
		} 
		
		else if(pathURL.equals("/RecordsUpdate.hw")) {
			
			controller = new RecordsUpdateController();
			handlerAdapter = controller.execute(request, response);
			log.info("FrontServlet 주차기록 수정 화면(주차기록 코드 조회) - " + handlerAdapter);
			
		} 
		
		else if(pathURL.equals("/RecordsUpdateInput.hw")) {
			
			controller = new RecordsUpdateInputController();
			handlerAdapter = controller.execute(request, response);
			log.info("FrontServlet 주차기록 수정 화면(input) - " + handlerAdapter);
			
		} 
		
		else if(pathURL.equals("/RecordsDelete.hw")) {
			
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/records/records_delete.jsp");
			log.info("FrontServlet 주차기록 삭제 요청 화면 - " + handlerAdapter);
			
		} 
		
		else if(pathURL.equals("/RecordsDeleteProcess.hw")) {
			
			controller = new RecordsDeleteController();
			handlerAdapter = controller.execute(request, response);
			log.info("FrontServlet 주차기록 삭제 처리 - " + handlerAdapter);
			
		} 
		
		
		if (handlerAdapter != null) {
		
			if (handlerAdapter.isRedirect()) {
				response.sendRedirect(handlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(handlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
			
		}
		
	}

}
