package car.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.member.dao.MemberDAO;
import car.member.dto.MemberDTO;
import car.common.handler.HandlerAdapter;

public class MemberSelectDetailController implements Controller {
	private static final Log log = LogFactory.getLog(MemberSelectDetailController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int member_code = Integer.parseInt(request.getParameter("member_code"));
		log.info("멤버 코드 번호" + member_code);
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		memberDTO = memberDAO.memberSelect(member_code);
		log.info("뭐지뭐지" + memberDTO);
		request.setAttribute("memberDTO", memberDTO);
		HandlerAdapter memberHandlerAdapter = new HandlerAdapter();
		
		log.info("특정 부서 조회");
		memberHandlerAdapter.setPath("/WEB-INF/view/member/member_select_detail_view.jsp");
		return memberHandlerAdapter;
	}

}
