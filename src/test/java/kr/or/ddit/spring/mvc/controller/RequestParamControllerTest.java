package kr.or.ddit.spring.mvc.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;

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
public class RequestParamControllerTest {
	
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Before
	public void init(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	@Resource(name="requestParamController")
	private RequestParamController controller;
	
	@Test
	public void BeanInjectionTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(controller);
	}
	
	@Test
	public void RequestParamTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/requestParam/view")
											.param("mem_id", "brown")
											.param("mem_alias", "sally"))
											.andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		Map<String, Object> model = mav.getModel();
		MemberVO memberVO = (MemberVO) model.get("memberVO");
		String mem_id = (String) model.get("mem_id");
		
		/***Then***/
		assertEquals("mvc/requestParam/view", mav.getViewName());
		assertNotNull(memberVO);
		assertEquals(mem_id, memberVO.getMem_id());
		assertEquals("sally", memberVO.getMem_alias());
	}

}
