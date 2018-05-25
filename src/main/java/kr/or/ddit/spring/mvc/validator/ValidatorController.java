package kr.or.ddit.spring.mvc.validator;

import kr.or.ddit.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/validator")
@Controller
public class ValidatorController {
	
	/**
	 * Method : view
	 * 최초작성일 : 2018. 5. 25.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 값 전송 출력 화면
	 */
	@RequestMapping("/view")
	public String view(){
		return "mvc/validator/view";
	}
	
	/**
	 * Method : view
	 * 최초작성일 : 2018. 5. 25.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 값 전송 성공 화면
	 */
	@RequestMapping("/result")
	public String result(){
		return "mvc/validator/result";
	}
	
	/**
	 * Method : origin
	 * 최초작성일 : 2018. 5. 25.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : validator를 사용하지 않고 검증
	 */
	@RequestMapping("/origin")
	private String origin(MemberVO memberVO) {
		if (memberVO.getMem_id() == null || memberVO.getMem_id().trim().isEmpty() || 
			memberVO.getMem_pass() == null || memberVO.getMem_pass().trim().isEmpty()) {
			return "mvc/validator/view";
		}else
			return "mvc/validator/result";
	}
	
	
	//********BindingResult 객체는 검증하고자 하는********
	//********form(vo) 객체 바로 뒤에 위치해야 한다********
	@RequestMapping("/validator")
	public String validator(MemberVO memberVO, BindingResult result){
		new MemberVOValidator().validate(memberVO, result);
		
		
		return "";
	}
	
	
}
