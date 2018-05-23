package kr.or.ddit.spring.bean.user.service;

import java.util.List;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.spring.bean.user.dao.UserDaoInf;

public class UserService implements UserServiceInf {
	
	private UserDaoInf userDao;

	@Override
	public List<MemberVO> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public UserDaoInf getUserDao() {
		return userDao;
	}

	@Override
	public void setUserDao(UserDaoInf userDao) {
		this.userDao = userDao;
	}

}
