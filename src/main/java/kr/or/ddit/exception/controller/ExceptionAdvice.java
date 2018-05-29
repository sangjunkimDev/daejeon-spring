package kr.or.ddit.exception.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler({ArithmeticException.class})
	public String exceptionHandler() {
		return "exception/arithmeticException";
	}
	
}
