package kr.or.ddit.login.controller;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.member.model.MemberVO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/servlet-context.xml", 
								"classpath:kr/or/ddit/spring/application-context.xml"})
@WebAppConfiguration	//applicationContext를 webApplicationContext로 생성
public class LoginControllerTest {
	
	@Resource
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	
	@Resource(name="loginController")
	private LoginController loginController;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	/**
	 * Method : creationTest
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : loginController bean 생성 테스트
	 */
	@Test
	public void creationTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(loginController);
	}
	
	
	/**
	 * Method : loginTest
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 로그인 폼 요청 테스트
	 */
	@Test
	public void loginTest() throws Exception {
		/***Given***/
		//localhost:8070/spring/login
		MvcResult result = mockMvc.perform(get("/login")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		
		/***Then***/
		assertEquals("login/login", mav.getViewName());
	}
	
	
	/**
	 * Method : loginProcessTest
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 로그인 처리 테스트
	 */
	@Test
	public void loginProcessTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(post("/login")
														.param("mem_id", "sally")
														.param("mem_pass", "12")).andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		MockHttpServletRequest request = result.getRequest();
		HttpSession session = request.getSession();
		MemberVO login_user = (MemberVO) session.getAttribute("LOGIN_USER");
		
		/***Then***/
		Map<String, Object> model = mav.getModel();
		List<BoardVO> boardList = (List<BoardVO>) model.get("boardList");
		
		assertEquals(5, boardList.size());
		assertEquals("main/main", mav.getViewName());
		assertNotNull(session);
		assertEquals("sally", login_user.getMem_id());
		assertEquals("zxㅊ", login_user.getMem_name());
		assertEquals("ㅁㄴㅇ", login_user.getMem_alias());
	}
	
	
}
