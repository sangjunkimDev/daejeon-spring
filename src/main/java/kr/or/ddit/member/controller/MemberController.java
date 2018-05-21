package kr.or.ddit.member.controller;

import javax.annotation.Resource;

import kr.or.ddit.member.service.MemberServiceInf;

import org.springframework.stereotype.Controller;

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
@Controller("memberController")
public class MemberController {
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
}
