package kr.or.ddit.login.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;

import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService implements LoginServiceInf{
	
	@Resource(name="memberDao")
	private MemberDaoInf memberDao;

	@Override
	public Map<String, Object> loginProcess(MemberVO memberVO) {
		//결과 전달 Map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//memberVO : mem_id, mem_pass
		MemberVO resultVO = memberDao.getMember(memberVO);
		
		//입력받은 비밀번호가 db값과 일치 할 때
		boolean loginPassed = memberVO.passwordVerify(resultVO);
		resultMap.put("loginPassed", loginPassed);
		
		if (loginPassed) {
			resultMap.put("resultVO", resultVO);
		}
		
		return resultMap;
	}
	
	
	
}
