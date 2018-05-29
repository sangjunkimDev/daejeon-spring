package kr.or.ddit.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tiles")
@Controller
public class TilesController {
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		//beanNameViewResolver : json --> pageJsonReport (bean name)
		//internalResourceViewResolver : jsp --> /WEB-INF/views + 문자열 + .jsp
		//tilesViewResolver : tiles 설정으로 연결. 문자열 = helloTiles(definition name) --> <definition name="helloTiles" extends="basic.layout">
//		<definition name="helloTiles" extends="basic.layout">
//			<put-attribute name="title" value="hello tiles"/>
//			<put-attribute name="body" value="/WEB-INF/views/tiles/helloTiles.jsp"/>
//		</definition>
		model.addAttribute("test", "testtettttt");
		return "helloTiles";
	}
	
}
