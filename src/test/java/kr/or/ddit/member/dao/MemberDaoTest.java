package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * MemberDaoTest.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 24.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 24. "K.S.J" 최초 생성
 *
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/application-context.xml")
public class MemberDaoTest {
	
	@Resource(name="memberDao")
	private MemberDaoInf memberDao;
	
	/**
	 * Method : memberDaoTest
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : memberDao 인스턴스화 테스트
	 */
	@Test
	public void memberDaoTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(memberDao);
	}
	
	/**
	 * Method : getMemberListTest
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : 회원 전체 정보 조회 테스트
	 */
	@Test
	public void getMemberListTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertEquals(25, memberDao.getMemberList().size());
	}
	
	/**
	 * Method : getMemberTest
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : 아이디를 이용한 회원 정보 조회
	 */
	@Test
	public void getMemberTest() {
		/***Given***/
		
		MemberVO memberVO = new MemberVO();
		String mem_id = "sally";
		memberVO.setMem_id(mem_id);
		/***When***/
		MemberVO result = memberDao.getMember(memberVO);
		
		/***Then***/
		assertEquals(mem_id, result.getMem_id());
		assertEquals("12", result.getMem_pass());
		assertEquals("zxㅊ", result.getMem_name());
	}
	
}
