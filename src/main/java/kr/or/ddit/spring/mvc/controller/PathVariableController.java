package kr.or.ddit.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pathVariable")
@Controller
public class PathVariableController {
	
	/**
	 * Method : pathVariable
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param userId
	 * @param model
	 * @return
	 * Method 설명 : pathVariable test
	 */
	@RequestMapping(value="/path/{userId}")
	public String pathVariable(@PathVariable("userId") String userId, Model model){
		model.addAttribute("userId", userId);
		return "mvc/pathVariable/pathVariable";
	}
	
	
}
