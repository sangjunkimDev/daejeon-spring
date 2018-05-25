package kr.or.ddit.spring.mvc.controller;

import kr.or.ddit.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/requestParam")
@Controller
public class RequestParamController {
	
	@RequestMapping("/view")
	public String view(MemberVO memberVO, @RequestParam("mem_id") String mem_id, Model model){
		model.addAttribute("mem_id", mem_id);
		return "mvc/requestParam/view";
	}
	
}
