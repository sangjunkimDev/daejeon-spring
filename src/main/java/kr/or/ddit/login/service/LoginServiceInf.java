package kr.or.ddit.login.service;

import java.util.Map;

import kr.or.ddit.member.model.MemberVO;

public interface LoginServiceInf {
	
	/**
	 * Method : loginProcess
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param memberVO (id, pass를 가짐)
	 * @return boolean loginPassed, MemberVO resultVO
	 * Method 설명 : 로그인 요청
	 */
	public Map<String, Object> loginProcess(MemberVO memberVO);
}
