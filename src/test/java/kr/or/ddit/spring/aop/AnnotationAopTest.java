package kr.or.ddit.spring.aop;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/aop/application-context-annoaop.xml")
public class AnnotationAopTest {

	@Resource(name="memberService")
	private MemberServiceInf memberService;
	
	@Test
	public void test() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(memberService);
		assertEquals(25, memberService.getMemberList().size());
	}

}
