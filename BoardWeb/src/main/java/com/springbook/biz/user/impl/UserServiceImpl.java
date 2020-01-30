package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service("userService") // 비즈니스 클래스,메소드
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public void createTable() {
		userDAO.createTable();
	}

	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

}
