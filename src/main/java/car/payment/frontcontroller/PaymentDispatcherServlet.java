package car.payment.frontcontroller;

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
import car.payment.controller.PaymentDeleteController;
import car.payment.controller.PaymentInsertController;
import car.payment.controller.PaymentSelectController;
import car.payment.controller.PaymentSelectDetailController;
import car.payment.controller.PaymentUpdateController;
import car.payment.controller.PaymentUpdateViewController;
import car.common.handler.HandlerAdapter;

@WebServlet("/PaymentDispatcherServlet")
public class PaymentDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(PaymentDispatcherServlet.class);
	
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
		
		HandlerAdapter HandlerAdapter = null;
		
		Controller controller = null;
		
		if (pathURL.equals("/PaymentSelect.jn")) {
			
			controller = new PaymentSelectController();
			
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 조회 확인 - " + HandlerAdapter);
		} 
		
		else if (pathURL.equals("/PaymentSelectDetail.jn")) {
			
			controller = new PaymentSelectDetailController();
			HandlerAdapter = controller.execute(request, response);
			log.info("상세 결제 조회 확인 - " + HandlerAdapter);
		}
		
		else if (pathURL.equals("/PaymentInsertView.jn")) {
			
			HandlerAdapter = new HandlerAdapter();			
			HandlerAdapter.setPath("/WEB-INF/view/payment/payment_insert.jsp");
			log.info("결제 등록 화면 뷰 확인 - " + HandlerAdapter);
		}
		
		else if (pathURL.equals("/PaymentInsert.jn")) {
			
			controller = new PaymentInsertController();
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 등록 확인 - " + HandlerAdapter);			
		}
		
		else if(pathURL.equals("/PaymentUpdateView.jn")) {
			controller = new PaymentUpdateViewController( );
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 수정 화면 뷰 확인 - " + HandlerAdapter);
		}
		
		else if(pathURL.equals("/PaymentUpdate.jn")) {
			controller = new PaymentUpdateController( );
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 수정 확인 - " + HandlerAdapter);
		}
		
		else if(pathURL.equals("/PaymentDeleteView.jn")) {
		
			HandlerAdapter = new HandlerAdapter( );
		
			HandlerAdapter.setPath("/WEB-INF/view/payment/payment_delete.jsp");
			log.info("결제 삭제 화면 뷰 확인 - " + HandlerAdapter);
			}

		else if(pathURL.equals("/PaymentDelete.jn")) {
			controller = new PaymentDeleteController( );
			HandlerAdapter = controller.execute(request, response);
			log.info("결제 삭제 확인 - " + HandlerAdapter);
		}

		if(HandlerAdapter != null) {	
		if (HandlerAdapter.isRedirect()) {
			response.sendRedirect(HandlerAdapter.getPath());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(HandlerAdapter.getPath( ));
			dispatcher.forward(request, response);
	  }
	}
  }
}