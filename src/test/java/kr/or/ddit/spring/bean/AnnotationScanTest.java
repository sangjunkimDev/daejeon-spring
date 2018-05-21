package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.member.controller.MemberController;
import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-annobean.xml")
public class AnnotationScanTest {
	
	//@Repository 어노테이션을 적용한 빈을 주입받아
	//정상적으로 생성되었는지 테스트(not null)
	
	@Resource(name="memberDao")
	MemberDaoInf memberDao;
	
	@Resource(name="memberService")
	MemberServiceInf memberService;
	
	@Resource(name="memberController")
	MemberController memberController;
	
	@Test
	public void repositoryAnnotationBeanTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(memberDao);
	}

	//@Service 어노테이션을 적용한 빈을 주입받아
	//정상적으로 생성되었는지 테스트
	//memberService 객체가 정상적으로 생성되었는지
	//memberService.getMemberDao()를 통해 memberDao가 정상적으로 주입되었는지
	//기존 <bean id="memberService" class="kr.or.ddit.member.service">
	//			<property name="memberDao" ref="memberDao">
	//	   </bean>
	@Test
	public void serviceAnnotationBeanTest() {
		/***Given***/
		MemberDaoInf getMemberDao = memberService.getMemberDao();
		
		/***When***/

		/***Then***/
		assertNotNull(memberService);
		assertNotNull(getMemberDao);
		assertEquals(memberDao, getMemberDao);
	}
	
	
	@Test
	public void controllerAnnotationBeanTest() {
		/***Given***/

		/***When***/
		MemberServiceInf getMemberService = memberController.getMemberService();
		MemberDaoInf getMemberDao = getMemberService.getMemberDao();
		
		/***Then***/
		assertNotNull(memberController);
		assertNotNull(getMemberService);
		assertEquals(memberService, getMemberService);
		assertNotNull(getMemberDao);
		assertEquals(memberDao, getMemberDao);
	}
	
}
