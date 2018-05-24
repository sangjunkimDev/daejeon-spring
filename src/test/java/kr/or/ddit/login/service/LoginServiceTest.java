package kr.or.ddit.login.service;

import static org.junit.Assert.*;

import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/application-context.xml"})
public class LoginServiceTest {
	
	@Resource(name="loginService")
	private LoginServiceInf loginService;
	
	/**
	 * Method : loginServiceTest
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : 로그인 성공 테스트
	 */
	@Test
	public void loginServiceSuccessTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO();
		String mem_id = "sally";
		String mem_pass = "12";
		memberVO.setMem_id(mem_id);
		memberVO.setMem_pass(mem_pass);

		/***When***/
		Map<String, Object> resultMap = loginService.loginProcess(memberVO);
		
		boolean loginPassed = (boolean) resultMap.get("loginPassed");
		MemberVO resultVO = (MemberVO) resultMap.get("resultVO");
		
		/***Then***/
		assertEquals(true, loginPassed);
		assertEquals(mem_id, resultVO.getMem_id());
		assertEquals(mem_pass, resultVO.getMem_pass());
		
	}

	
	/**
	 * Method : loginServiceFailTest
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : 로그인 실패 테스트
	 */
	@Test
	public void loginServiceFailTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO();
		String mem_id = "sally";
		String mem_pass = "21";
		memberVO.setMem_id(mem_id);
		memberVO.setMem_pass(mem_pass);

		/***When***/
		Map<String, Object> resultMap = loginService.loginProcess(memberVO);
		
		boolean loginPassed = (boolean) resultMap.get("loginPassed");
		MemberVO resultVO = (MemberVO) resultMap.get("resultVO");
		
		/***Then***/
		assertEquals(false, loginPassed);
		assertEquals(null, resultVO);
		
	}
	
	/**
	 * Method : loginServiceFailNotExistsTest
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : 로그인 실패 테스트
	 */
	@Test
	public void loginServiceFailNotExistsTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO();
		String mem_id = "sally1234";
		String mem_pass = "12";
		memberVO.setMem_id(mem_id);
		memberVO.setMem_pass(mem_pass);

		/***When***/
		Map<String, Object> resultMap = loginService.loginProcess(memberVO);
		
		boolean loginPassed = (boolean) resultMap.get("loginPassed");
		MemberVO resultVO = (MemberVO) resultMap.get("resultVO");
		
		/***Then***/
		assertEquals(false, loginPassed);
		assertEquals(null, resultVO);
		
	}
	
	
}
