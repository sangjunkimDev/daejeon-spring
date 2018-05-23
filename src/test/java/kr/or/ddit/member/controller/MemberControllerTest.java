package kr.or.ddit.member.controller;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/servlet-context.xml", 
								"classpath:kr/or/ddit/spring/application-context.xml"})
@WebAppConfiguration	//applicationContext를 webApplicationContext로 생성
public class MemberControllerTest {
	
	@Resource
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	
	@Resource(name="memberController")
	private MemberController memberController;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	/**
	 * Method : creationTest
	 * 최초작성일 : 2018. 5. 23.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : memberController bean 생성 테스트
	 */
	@Test
	public void creationTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(memberController);
	}
	
	/**
	 * Method : WebApplicationContextTest
	 * 최초작성일 : 2018. 5. 23.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : 스프링 컨테이너 생성 테스트
	 */
	@Test
	public void webApplicationContextTest(){
		/***Given***/

		/***When***/
		//spring container에 DL(dependency Lookup)
		MemberDaoInf memberDao = ctx.getBean("memberDao", MemberDaoInf.class);
		List<MemberVO> memberList = memberDao.getMemberList();
		
		/***Then***/
		assertNotNull(memberDao);
		assertEquals(25, memberList.size());
	}
	
	/**
	 * Method : memberListTest
	 * 최초작성일 : 2018. 5. 23.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : memberList 테스트
	 */
	@Test
	public void memberListTest(){
		/***Given***/
		MvcResult result = mockMvc.perform(get(urlTemplate, urlVariables));

		/***When***/

		/***Then***/

		
		
	}
	
	
}
