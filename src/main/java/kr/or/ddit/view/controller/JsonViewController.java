package kr.or.ddit.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@RequestMapping("/json")
@Controller
public class JsonViewController {
	
	@ModelAttribute
	public void lineRangers(Model model){
		List<String> lineRangers = new ArrayList<String>();
		lineRangers.add("brown");
		lineRangers.add("cony");
		lineRangers.add("sally");
		
		model.addAttribute("lineRangers", lineRangers);
	}
	
	
	@RequestMapping("/pageJsonView")
	public String pageJsonView(Model model) {
		List<String> lineRangers = new ArrayList<String>();
		lineRangers.add("brown2");
		lineRangers.add("cony2");
		lineRangers.add("sally2");
		
		model.addAttribute("lineRangers2", lineRangers);
		
		return "pageJsonReport";
	}
	
	
	@RequestMapping("/pageJsonViewObject")
	public View pageJsonViewObject() {
		return new MappingJacksonJsonView();
	}
	
	
	@RequestMapping("/pageJsonViewMav")
	public ModelAndView pageJsonViewMav() {
//		return new ModelAndView("pageJsonReport");
		return new ModelAndView(new MappingJacksonJsonView());
	}
	
	
	//ajax and json
	@RequestMapping("/responseBody")
	@ResponseBody
	public List<String> responseBody(Model model) {
		return (List<String>) model.asMap().get("lineRangers");
	}
	
	
	@RequestMapping("/requestBody/view")
	public String requestBodyView(){
		return "mvc/json/view";
	}
	
	@RequestMapping("/requestBody/sendData")
	@ResponseBody
	public List<String> sendData(@RequestBody List<String> receiveList){
		receiveList.add("JESICA");
		return receiveList;
	}
	
	
}
