package kr.or.ddit.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	//localhost:8070/spring/exception/view
	@RequestMapping("/exception/view")
	public void view(){
		
		throw new ArithmeticException();
	}
	
	@ExceptionHandler({ArithmeticException.class})
	public String exceptionHandler() {
		return "exception/arithmeticException";
	}
	
}
