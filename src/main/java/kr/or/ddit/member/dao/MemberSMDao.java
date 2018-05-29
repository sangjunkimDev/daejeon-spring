package kr.or.ddit.member.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/*
 * @Controller : controller
 * @Service : service
 * @Repository : dao
 */
@Repository("memberSMDao")
public class MemberSMDao implements MemberSMDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public MemberSMDao(){
		
		
	}

	public List<MemberVO> getMemberList() {
		List<MemberVO> memberList = sqlSessionTemplate.selectList("member.getMemberList");
		
		return memberList;
	}

	@Override
	public MemberVO getMember(MemberVO memberVO) {
		MemberVO result = sqlSessionTemplate.selectOne("member.getMember", memberVO);
		
		return result;
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		int result = sqlSessionTemplate.insert("member.insertMember", memberVO);
		return result;
	}
	
}
