package car.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.member.dao.MemberDAO;
import car.member.dto.MemberDTO;
import car.common.handler.HandlerAdapter;

public class MemberSelectController implements Controller {

	private static final Log log = LogFactory.getLog(MemberSelectController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		log.info(memberDTO);
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		arrayList = memberDAO.memberSelectAll();
		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);
		HandlerAdapter memberHandlerAdapter = new HandlerAdapter();
		log.info("회원 정보 조회");
		memberHandlerAdapter.setPath("/WEB-INF/view/member/member_select_view.jsp");
		return memberHandlerAdapter;
	}
}