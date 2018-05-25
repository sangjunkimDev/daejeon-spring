package kr.or.ddit.spring.mvc.validator;

import kr.or.ddit.member.model.MemberVO;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberVOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//MemberVO.class.isInstance(clazz);
		return MemberVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberVO memberVO = (MemberVO) target;
		//mem_id가 정상적으로 입력 되었는지
		if(memberVO.getMem_id() == null || memberVO.getMem_id().trim().isEmpty()){
			errors.rejectValue("mem_id", "required");
		} else if(memberVO.getMem_id().length() <= 3) {
			errors.rejectValue("mem_id", "size");
		}
		
		if(memberVO.getMem_pass() == null || memberVO.getMem_pass().trim().isEmpty()){
			errors.rejectValue("mem_pass", "required");
		} else if(memberVO.getMem_pass().length() <= 3) {
			errors.rejectValue("mem_pass", "size");
		}
		
	}
	
}
