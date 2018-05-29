package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.model.MemberVO;

/**
 * MemberServiceInf.java
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
public interface MemberSMServiceInf {
	/**
	 * Method : getMemberList
	 * 최초작성일 : 2018. 5. 18.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 회원 리스트 조회
	 */
	public List<MemberVO> getMemberList();
	
	/**
	 * Method : getMember
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param memberVO (id를 가진 멤버vo)
	 * @return
	 * Method 설명 : 해당 멤버의 정보를 조회
	 */
	public MemberVO getMember(MemberVO memberVO);
	
	/**
	 * Method : insertMember
	 * 최초작성일 : 2018. 5. 29.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param memberVO
	 * @return
	 * Method 설명 : 회원 정보 입력
	 */
	public int insertMember(MemberVO memberVO);
}
