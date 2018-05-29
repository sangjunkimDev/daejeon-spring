package kr.or.ddit.exception.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoFileExceptionController {
	
	@RequestMapping("/ioException")
	public String ioException() throws IOException{
		//일부러 존재하지 않는 파일에 대해 접근한다
		new ClassPathResource("kr/or/ddit/db/mybatis/mybatis-config2.xml").getInputStream();
		
		return "";
	}
	
	@RequestMapping("/noFileException")
	public String noFileException() throws NoFileException {
		//일부러 존재하지 않는 파일에 대해 접근한다
		try {
			new ClassPathResource("kr/or/ddit/db/mybatis/mybatis-config2.xml").getInputStream();
		} catch (IOException e) {
			throw new NoFileException();
		}
		
		return "";
	}
}
