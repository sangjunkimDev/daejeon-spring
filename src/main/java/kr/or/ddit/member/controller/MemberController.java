package kr.or.ddit.member.controller;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * MemberController.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 21. "K.S.J" 최초 생성
 *
 * </pre>
 */
@RequestMapping("/member")
@Controller("memberController")
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//controller : service 속성
	//service : dao 속성
	//dao : bean으로 주입 x (현재기준)
	
	//주입을 받는다
	@Resource(name="memberService")
	MemberServiceInf memberService;

	public MemberServiceInf getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberServiceInf memberService) {
		this.memberService = memberService;
	}
	
	
	//controller의 return type은
	//1.ModelAndView 객체
	//2.String 객체 : view 이름
	
	//localhost:8070/spring/member/list url에서 처리하는 controller method
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String memberList(Model model) {
		/*
		<property name="prefix" value="/WEB-INF/views/"/>
		<property name="suffix" value=".jsp"/>
		*/
		logger.debug("{}", "memberList()");
		
		//1.service 에서 데이터 조회
		List<MemberVO> memberList = memberService.getMemberList();
		
		//2.request.setAttribute("이름", "값");
		model.addAttribute("memberList", memberList);
		
		//3.view 전달 : request.getRequestDispatcher("view경로").forward(request, response)
		//	/WEB-INF/views/member/memberList
		return "member/memberList";
	}
	
	//사용자 상세정보 조회
	//localhost:8070/spring/member/detail
	@RequestMapping("/detail")
	public ModelAndView memberDetail(){
		return null;
	}
	
	//사용자 등록화면(form)
	//get : 사용자 등록 화면 전달
	//post : 사용자 등록을 처리
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String memberForm(){
		return "";
	}
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String memberForm(MemberVO memberVO){
		return "";
	}
	
	
	
	
}
