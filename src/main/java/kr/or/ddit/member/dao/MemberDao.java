package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import kr.or.ddit.member.model.MemberVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * BoardDao.java
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
public class MemberDao implements MemberDaoInf{
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	public MemberDao(){
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
}
