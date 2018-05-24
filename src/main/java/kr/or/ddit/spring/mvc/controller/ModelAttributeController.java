package kr.or.ddit.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("boardList")
@RequestMapping("/modelAttribute")
@Controller("modelAttributeController")
public class ModelAttributeController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
//	medelAttribute - method 적용시
//	해당 컨트롤러의 requestMapping이 적용된 method 실행전 model 객체에 method의 리턴값을 설정
//	단, ModelAttribute Annotation이 적용된 method에는 requestMapping을 설정하지 않음
	
	@ModelAttribute("boardList")
	public List<String> getBoardList(){
		logger.debug("{}", "getBoardList()");
		
		List<String> boardList = new ArrayList<String>();
		boardList.add("공지사항");
		boardList.add("자유게시판");
		boardList.add("QnA");
		boardList.add("FAQ");
		
		return boardList;
	}
	
	@RequestMapping(value="/methodA")
	public String methodA() {
		return "mvc/modelAttribute/methodA";
	}
	@RequestMapping(value="/methodB")
	public String methodB() {
		return "methodB";
	}
	@RequestMapping(value="/methodC")
	public String methodC() {
		return "methodC";
	}
	
	
	
}

