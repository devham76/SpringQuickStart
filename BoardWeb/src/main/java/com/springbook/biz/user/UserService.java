package com.springbook.biz.user;

public interface UserService {
	public void createTable();
	public void insertUser(UserVO vo);
	public UserVO getUser(UserVO vo);
}
