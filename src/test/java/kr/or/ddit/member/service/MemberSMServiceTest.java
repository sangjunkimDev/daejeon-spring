package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.spring.test.TestInit;

import org.junit.Test;

public class MemberSMServiceTest extends TestInit{
	
	@Resource(name="memberSMService")
	private MemberSMServiceInf memberSMService;
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO("brown", "1234", "브라운", "대전 중구 중앙로 76", "영민빌딩 2층", "32132", "운라브");
		
		/***When***/
		int insertCnt = memberSMService.insertMember(memberVO);
		
		/***Then***/
		assertEquals(2, insertCnt);
	}
	
	
}
