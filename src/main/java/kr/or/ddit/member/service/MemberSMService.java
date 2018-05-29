package kr.or.ddit.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberSMDaoInf;
import kr.or.ddit.member.model.MemberVO;

/**
 * MemberService.java
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

@Service("memberSMService")
public class MemberSMService implements MemberSMServiceInf{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="memberSMDao")
	private MemberSMDaoInf memberSMDao;
	
	/**
	 * Method : getMemberList
	 * 최초작성일 : 2018. 5. 18.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 회원 리스트 조회
	 */
	public List<MemberVO> getMemberList() {
		return memberSMDao.getMemberList();
	}
	@Override
	public MemberVO getMember(MemberVO memberVO) {
		return memberSMDao.getMember(memberVO);
	}
	
	/**
	 * Method : insertMember
	 * 최초작성일 : 2018. 5. 29.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param memberVO
	 * @return
	 * Method 설명 : 회원 정보 입력
	 */
	@Override
	public int insertMember(MemberVO memberVO){
		int insertCnt = 0;
		
		insertCnt += memberSMDao.insertMember(memberVO);
		
		if (true) {
			throw new RuntimeException();
		}
		memberVO.setMem_id("brown222");
		insertCnt += memberSMDao.insertMember(memberVO);
		
		return insertCnt;
	}
}
