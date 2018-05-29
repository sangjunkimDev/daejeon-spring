package kr.or.ddit.spring.global;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/global")
@Controller
public class GlobalController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping("/view")
	public String view(@RequestParam(value="language", required=false)String language, Model model){
		logger.debug("{}", "view()", language);
		
		language = (language == null) ? "ko" : language;
		model.addAttribute("language", language);
		
		return "global/view";
	}
	
	@ModelAttribute
	public void languageCode(Model model){
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", "english");
		map.put("ja", "japan");
		map.put("ko", "korea");
		
		model.addAttribute("map", map);
	}
	
}
