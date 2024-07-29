package car.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.member.dao.MemberDAO;
import car.member.dto.MemberDTO;
import car.common.handler.HandlerAdapter;

public class MemberDeleteController implements Controller {

private static final Log log = LogFactory.getLog(MemberDeleteController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int member_code = Integer.parseInt(request.getParameter("member_code"));
		log.info(member_code);
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMember_code(member_code);
		request.setAttribute("memberDTO", memberDTO);
		memberDTO = memberDAO.memberDelete(member_code);
		log.info("너가 문제냐" + memberDTO);
		HandlerAdapter memberHandlerAdapter = new HandlerAdapter();
		
		memberHandlerAdapter.setPath("/WEB-INF/view/member/member_delete.jsp");
		return memberHandlerAdapter;
	}
}