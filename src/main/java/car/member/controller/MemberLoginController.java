package car.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.member.dao.MemberDAO;
import car.member.dto.MemberDTO;
import car.common.handler.HandlerAdapter;

public class MemberLoginController implements Controller {
	
	private static final Log log = LogFactory.getLog(MemberLoginController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String member_id = request.getParameter("member_id");
		log.info("member_id - " + member_id);
		String member_password = request.getParameter("member_password");
		log.info("member_password - " + member_password);
		
		MemberDTO memberDTO = new MemberDTO( );
		memberDTO.setMember_id(member_id);
		memberDTO.setMember_password(member_password);
		
		MemberDAO memberDAO = new MemberDAO( );
		memberDTO = memberDAO.memberLogin(memberDTO); // member code, id, password, name, rating
		log.info("memberDAO 진입 후 memberDTO" + memberDTO);
		request.setAttribute("memberDTO", memberDTO);
		
		if(!memberDTO.getMember_id( ).equals("") & !memberDTO.getMember_password( ).equals("")) {
			HttpSession httpSession = request.getSession( );
			httpSession.setAttribute("member_code", memberDTO.getMember_code());
			httpSession.setAttribute("member_id", memberDTO.getMember_id( ));
			httpSession.setAttribute("member_name", memberDTO.getMember_name( ));
			httpSession.setAttribute("member_rating", memberDTO.getMember_rating());
			
			Cookie cookie = new Cookie("member_id", memberDTO.getMember_id( ));
			cookie.setMaxAge(60 * 60 * 24);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		HandlerAdapter memberHandlerAdapter = new HandlerAdapter( );
		memberHandlerAdapter.setPath("/WEB-INF/view/login/login_check.jsp");
		return memberHandlerAdapter;
	}

}
