package com.springbook.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository // ��ü ����
public class UserDAO{
	@Autowired // ����������  �ش� ��ü�� �������Ͽ��� bean���� ��������
	private JdbcTemplate jdbcTemplate;
	
	private String USER_CREATE = "CREATE TABLE USERS("
			+ "ID VARCHAR2(8),"
			+ "PASSWORD VARCHAR2(8),"
			+ "NAME VARCHAR2(20),"
			+ "ROLE VARCHAR2(5)"
			+ ")";
	private String USER_INSERT = "INSERT INTO USERS (ID,PASSWORD,NAME,ROLE) VALUES (?,?,?,?)";
	private String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";
	
	// ���̺� ����
	public void createTable() {
		System.out.println("==>SPRING JDBC�� createTable() ��� ó��");
		jdbcTemplate.execute(USER_CREATE);
	}
	// ����� ���
	public void insertUser(UserVO vo) {
		System.out.println("==>SPRING JDBC�� insertUser() ��� ó��");
		jdbcTemplate.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}
	// Ư�� ����� ��������
	public UserVO getUser(UserVO vo) {
		System.out.println("==>SPRING JDBC�� getUser() ��� ó��");
		Object[] args = {vo.getId(), vo.getPassword()};
		System.out.println(vo.getId()+", "+vo.getPassword());
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
}
class UserRowMapper implements RowMapper<UserVO>{

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		user.setId(rs.getString("ID"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setName(rs.getString("NAME"));
		user.setRole(rs.getString("ROLE"));
		return user;
	}
	
}