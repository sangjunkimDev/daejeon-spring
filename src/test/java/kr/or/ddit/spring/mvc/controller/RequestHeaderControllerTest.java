package kr.or.ddit.spring.mvc.controller;

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
public class RequestHeaderControllerTest {
	
	@Resource(name="requestHeaderController")
	private RequestHeaderController requestHeaderController;
	
	@Resource
	WebApplicationContext wac;
	MockMvc mockMvc;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	@Test
	public void BeanInjectionTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(requestHeaderController);
	}
	
	@Test
	public void viewTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/requestHeader/view")).andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		String user_agent = (String) mav.getModel().get("user_agent");
		
		/***Then***/
		assertEquals("mvc/requestHeader/view", mav.getViewName());
		//테스트 환경에서는 브라우저를 사용하지 않으므로 user_agent 값을 확인할수 없다
	}

}
