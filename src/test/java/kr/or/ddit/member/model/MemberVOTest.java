package kr.or.ddit.member.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemberVOTest {

	/**
	 * Method : passwordVerifyTest
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : 비밀번호 검증 테스트
	 */
	@Test
	public void passwordVerifyTest() {
		/***Given***/
		//사용자가 입력한 값을 갖고있는 vo(mem_id, mem_pass)
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_id("sally");
		memberVO.setMem_pass("12");
		
		//memberDao에 의해 조회된 결과 vo
		MemberVO resultVO = new MemberVO();
		resultVO.setMem_id("sally");
		resultVO.setMem_pass("12");
		resultVO.setMem_alias("ㅁㄴㅇ");
		
		/***When***/
		boolean loginPassed = resultVO.passwordVerify(memberVO);
		
		/***Then***/
		assertTrue(loginPassed);
	}

}
