package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import kr.or.ddit.member.model.MemberVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/*
 * @Controller : controller
 * @Service : service
 * @Repository : dao
 */
@Repository("memberDao")
public class MemberDao implements MemberDaoInf{
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public MemberDao(){
		logger.debug("{}", "public MemberDao() : 생성자");
		String resource = "kr/or/ddit/db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public List<MemberVO> getMemberList() {
		sqlSession = sqlSessionFactory.openSession();
		List<MemberVO> memberList = sqlSession.selectList("member.getMemberList");
		sqlSession.close();
		
		return memberList;
	}

	@Override
	public MemberVO getMember(MemberVO memberVO) {
		sqlSession = sqlSessionFactory.openSession();
		MemberVO result = sqlSession.selectOne("member.getMember", memberVO);
		
		sqlSession.close();
		
		return result;
	}
}
