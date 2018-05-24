package kr.or.ddit.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberDaoInf;
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

@Service("memberService")
public class MemberService implements MemberServiceInf{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="memberDao")
	private MemberDaoInf memberDao;
	
	public MemberDaoInf getMemberDao() {
		return memberDao;
	}
	//1.setter방법
	public void setMemberDao(MemberDaoInf memberDao) {
		this.memberDao = memberDao;
	}

	//2.constructor방법
	public MemberService(MemberDaoInf memberDao){
		this.memberDao = memberDao;
	}
	public MemberService(){
		logger.debug("{}", "public MemberService() : 생성자");
	}
	
	
	/**
	 * Method : getMemberList
	 * 최초작성일 : 2018. 5. 18.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 회원 리스트 조회
	 */
	public List<MemberVO> getMemberList() {
		return memberDao.getMemberList();
	}
	@Override
	public MemberVO getMember(MemberVO memberVO) {
		return memberDao.getMember(memberVO);
	}
}
