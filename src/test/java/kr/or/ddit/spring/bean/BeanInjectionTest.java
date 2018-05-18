package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanInjectionTest.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 18.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 18. "K.S.J" 최초 생성
 *
 * </pre>
 */
//	@Before, @After : junit test method가 실행전, 실행후에 실행
//	@BeforeClass, @AfterClass : junit 실행되기 전에 최초 한번만 실행 ** static : 활용도가 떨어짐
//	1.test method의 실행순서는 보장할 수 없다
//	2.순서 : @BeforeClass => [ {@Before => @Test => @After}, { ~ }, ... ](test method의 순서는 랜덤) => @AfterClass

public class BeanInjectionTest {
	private ApplicationContext container;
	
	@Before
	public void setUp(){
		//spring container(IOC 컨테이너) 생성
		container = new ClassPathXmlApplicationContext("kr/or/ddit/spring/bean/application-context-beaninjection.xml");
	}
	
	@Test
	public void beanInjectionTest() {
		/***Given***/
		//spring container로부터 memberDao DL(dependency loop up)
		MemberDaoInf memberDao = container.getBean("memberDao", MemberDaoInf.class);
		
		/***When***/
		List<MemberVO> memberList = memberDao.getMemberList();
		
		/***Then***/
		assertEquals(25, memberList.size());
	}
	
	@Test
	public void beanInjectionServiceTest() {
		/***Given***/
		//container.getBean("설정파일에서 선언한 bean id")
		MemberServiceInf memberService = container.getBean("memberService", MemberServiceInf.class);
		List<MemberVO> memberList = memberService.getMemberList();
		
		/***When***/
		
		/***Then***/
		assertNotNull(memberService);
		assertEquals(25, memberList.size());
		
	}

}
