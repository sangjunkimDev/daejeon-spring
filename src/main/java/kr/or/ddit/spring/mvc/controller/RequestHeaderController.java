package kr.or.ddit.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/requestHeader")
@Controller
public class RequestHeaderController {
	
	/**
	 * Method : view
	 * 최초작성일 : 2018. 5. 25.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : @requestHeader 테스트
	 */
	@RequestMapping(value="view", method=RequestMethod.GET)
	private String view(@RequestHeader(value="user-agent", required=false) String user_agent, Model model){
		model.addAttribute("user_agent", user_agent);
		return "mvc/requestHeader/view";
	}
	
	
	
}
