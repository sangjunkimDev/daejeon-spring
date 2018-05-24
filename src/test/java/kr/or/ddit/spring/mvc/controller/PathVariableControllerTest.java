package kr.or.ddit.spring.mvc.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

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
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/servlet-context.xml", "classpath:kr/or/ddit/spring/application-context.xml"})
@WebAppConfiguration
public class PathVariableControllerTest {
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void pathVariableTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/pathVariable/path/brown")).andReturn();
		ModelAndView mav = result.getModelAndView();
		
		/***When***/
		Map<String, Object> resultMap = mav.getModel();
		String resultStr = (String) resultMap.get("userId");
		
		/***Then***/
		assertEquals("brown", resultStr);
		
	}

}
