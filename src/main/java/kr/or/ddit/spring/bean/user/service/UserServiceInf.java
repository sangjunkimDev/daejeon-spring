package kr.or.ddit.spring.bean.user.service;

import java.util.List;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.spring.bean.user.dao.UserDaoInf;

public interface UserServiceInf {
	
	/**
	 * Method : getUserList
	 * 최초작성일 : 2018. 5. 23.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	List<MemberVO> getUserList();
	
	UserDaoInf getUserDao();
	void setUserDao(UserDaoInf userDao);
}
