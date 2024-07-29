package car.notice.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.notice.dao.NoticeDAO;
import car.notice.dto.NoticeDTO;

public class NoticeSelectController implements Controller {
	 private static Log log = LogFactory.getLog(NoticeSelectController.class);
	 @Override
	 public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		 HttpSession session = request.getSession();
	     String member_rating = (String) session.getAttribute("member_rating");
	 NoticeDAO noticeDao = new NoticeDAO( );
	 NoticeDTO noticeDTO = new NoticeDTO( );
	 log.info(noticeDTO);
	 ArrayList<NoticeDTO> arrayList = new ArrayList<NoticeDTO>( );
	 arrayList = noticeDao.noticeSelectAll( );
	 log.info(arrayList);
	 request.setAttribute("arrayList", arrayList);
	 HandlerAdapter handlerAdapter = new HandlerAdapter( );
	 log.info("공지사항 정보 조회");
	 handlerAdapter.setPath("/WEB-INF/view/notice/notice_select_view.jsp");
	 return handlerAdapter;
	 }
}
