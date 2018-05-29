package kr.or.ddit.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionAdviceController {
	
	//localhost:8070/spring/exception/view
	@RequestMapping("/exceptionAdvice/view")
	public void view(){
		
		throw new ArithmeticException();
	}
	
	
}
