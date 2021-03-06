package kr.or.ddit.spring.aop;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/aop/application-context-aop.xml")
public class AopTest {
	
	@Resource(name="memberService")
	private MemberServiceInf memberService;
	
	@Test
	public void aopTest() {
		/***Given***/
		
		
		/***When***/
		List<MemberVO> memberList = memberService.getMemberList();
		
		/***Then***/
		assertNotNull(memberService);
		assertEquals(25, memberList.size());
	}

}
