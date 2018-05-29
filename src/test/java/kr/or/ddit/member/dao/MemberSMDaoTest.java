package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.spring.test.TestInit;

import org.junit.Test;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/application-context.xml"
//								, "classpath:kr/or/ddit/spring/context-datasource.xml"
//								, "classpath:kr/or/ddit/spring/context-transaction.xml"})
public class MemberSMDaoTest extends TestInit{

	@Resource(name="memberSMDao")
	private MemberSMDaoInf memberSMDao;
	
	
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
		assertNotNull(memberSMDao);
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
		assertEquals(25, memberSMDao.getMemberList().size());
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
		String mem_pass = "12";
		memberVO.setMem_id(mem_id);
		memberVO.setMem_pass(mem_pass);
		
		/***When***/
		MemberVO result = memberSMDao.getMember(memberVO);
		
		/***Then***/
		assertEquals(mem_id, result.getMem_id());
		assertEquals(mem_pass, result.getMem_pass());
		assertEquals("zxㅊ", result.getMem_name());
	}
	
	
	@Test
	public void insertMemberTest(){
		/***Given***/
		MemberVO memberVO = new MemberVO("brown", "1234", "브라운", "대전 중구 중앙로 76", "영민빌딩 2층", "32132", "운라브");
		
		/***When***/
		int insertCnt = memberSMDao.insertMember(memberVO);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
}
