package kr.or.ddit.spring.mvc.validator;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/application-context.xml", "classpath:kr/or/ddit/spring/servlet-context.xml"})
@WebAppConfiguration
public class ValidatorControllerTest {

	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	
	@Before
	public void init(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	/**
	 * Method : viewTest
	 * 최초작성일 : 2018. 5. 25.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : view 호출 테스트
	 * @throws Exception 
	 */
	@Test
	public void viewTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/validator/view")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		
		/***Then***/
		assertEquals("mvc/validator/view", mav.getViewName());
	}

}
