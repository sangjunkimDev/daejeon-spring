package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * BeanInjectionJunitRunnerTest.java
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-beaninjection.xml")
public class BeanInjectionJunitRunnerTest {
	
	@Resource(name="memberDao")
	private MemberDaoInf memberDao;
	@Resource(name="memberService")
	private MemberServiceInf memberService;
	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void beanInjectionTest() {
		/***Given***/
		
		/***When***/
		List<MemberVO> memberList = memberDao.getMemberList();
		
		/***Then***/
		assertEquals(25, memberList.size());
	}
	
	@Test
	public void beanInjectionServiceTest() {
		/***Given***/
		
		/***When***/
		List<MemberVO> memberList = memberService.getMemberList();
		
		/***Then***/
		assertNotNull(memberService);
		assertEquals(25, memberList.size());
		
	}

	//1.memberServiceSec 정상적으로 객체가 생성되었는지(null check)
	//2.memberServiceSec getMemberList() 테스트 (beanInjectionServiceTest)
	@Resource(name="memberServiceSec")
	private MemberServiceInf memberServiceSec;
	
	@Test
	public void beanInjectionServiceSecTest() {
		/***Given***/
		
		/***When***/
		List<MemberVO> memberList = memberServiceSec.getMemberList();

		/***Then***/
		assertNotNull(memberServiceSec);
		assertEquals(25, memberList.size());
		
	}
	
	//design pattern singleton : getInstance() -> 해당 클래스의 객체를 하나만 만드는 메서드
	//								(jvm 상에 해당 클래스의 객체는 하나)
	
	//spring singleton : bean id당 하나의 객체
	//<bean id="memberService" class="kr.or.ddit.member.service.MemberSerivce">
	//<bean id="memberServiceSec" class="kr.or.ddit.member.service.MemberSerivce">
	
	//spring singleton 테스트
	//memberService 와 memberServiceSec 객체가 서로 같은지 테스트
	
	@Test
	public void equalTest(){
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotEquals(memberService, memberServiceSec);
	}
	
	//spring prototype 테스트
	//prototype : 객체를 요청 할 때마다 새로운 객체를 반환
	//singleton : bean과 prototype bean이 서로 달라야함
	//bean 생성 설명서에 MemberDao 객체를 prototype 속성으로 하나 추가합니다(id="memberDaoProto")
	//기존에 생성한 bean(id="memberDao", singleton)객체와 다른지 테스트
	
	@Resource(name="memberDaoProto")
	private MemberDaoInf memberDaoProto;
	
	@Resource(name="memberDaoSingle")
	private MemberDaoInf memberDaoSingle;
	
	@Resource(name="memberDaoSingle")
	private MemberDaoInf memberDaoSingleSec;
	
	
	@Test
	public void prototypeTest(){
		/***Given***/

		/***When***/

		/***Then***/
		assertNotEquals(memberDao, memberDaoProto);
		assertEquals(memberDaoSingleSec, memberDaoSingle);
	}
	
	//spring prototype 테스트
	//prototype memberDao bean : memberDaoProto bean 을 서로 다른 이름으로 주입 받는다.
	@Resource(name="memberDaoProto")
	private MemberDaoInf memberDaoProto2;
	
	@Test
	public void prototypeEqualTest(){
		/***Given***/

		/***When***/

		/***Then***/
		assertNotEquals(memberDaoProto, memberDaoProto2);
	}
	
	//spring singleton 테스트
	//spring memberDao bean을 서로다른 두개의 객체에 주입
	//memberDao, memberDao2
	//두개의 객체가 서로 같은지 확인
	@Resource(name="memberDao")
	private MemberDaoInf memberDao2;
	@Test
	public void singletonEqualsTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertEquals(memberDao, memberDao2);
	}
	
//	private MemberDaoInf 
	@Resource(name="memberServiceSingle")
	private MemberService memberServiceSingle;
	@Test
	public void memberServiceSingle() {
		/***Given***/

		/***When***/

		/***Then***/
		//prototype bean은 요청시마다 새로운 객체를 반환해야 맞지만
		//singleton bean 안에서의 prototype bean은 정상적으로 동작하지 않는다
		assertEquals(memberServiceSingle.getMemberDao(), memberServiceSingle.getMemberDao());
	}
	
	
}
