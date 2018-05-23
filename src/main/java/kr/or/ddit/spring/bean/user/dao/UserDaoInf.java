package kr.or.ddit.spring.bean.user.dao;

import java.util.List;

import kr.or.ddit.member.model.MemberVO;

public interface UserDaoInf {
	
	List<MemberVO> getUserList();
}
