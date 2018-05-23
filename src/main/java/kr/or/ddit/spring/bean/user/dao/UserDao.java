package kr.or.ddit.spring.bean.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import kr.or.ddit.member.model.MemberVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDao implements UserDaoInf{
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	public UserDao(){
		String resource = "kr/or/ddit/db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> getUserList() {
		sqlSession = sqlSessionFactory.openSession();
		List<MemberVO> memberList = sqlSession.selectList("member.getMemberList");
		sqlSession.close();
		
		return memberList;
	}
}
