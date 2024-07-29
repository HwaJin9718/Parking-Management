package car.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.common.handler.HandlerAdapter;
import car.member.dao.MemberDAO;
import car.member.dto.MemberDTO;

public class AdminUpdateController implements Controller {

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		final Log log = LogFactory.getLog(MemberUpdateController.class);

			int member_code = Integer.parseInt(request.getParameter("member_code"));
			String member_rating = request.getParameter("member_rating");
			
			MemberDTO memberDTO = new MemberDTO();
			MemberDAO memberDAO = new MemberDAO();
			
			memberDTO.setMember_code(member_code);
			memberDTO.setMember_rating(member_rating);
			
			memberDTO = memberDAO.ratingCheck(memberDTO);
			log.info(memberDTO);
			
			request.setAttribute("memberDTO", memberDTO);
			HandlerAdapter memberHandlerAdapter = new HandlerAdapter();
			
			memberHandlerAdapter.setPath("/WEB-INF/view/member/admin_update.jsp");
			return memberHandlerAdapter;
		}
}