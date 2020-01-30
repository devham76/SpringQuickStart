package com.springbook.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository // 객체 생성
public class UserDAO{
	@Autowired // 의존성주입  해당 객체는 설정파일에서 bean으로 만들어줬다
	private JdbcTemplate jdbcTemplate;
	
	private String USER_CREATE = "CREATE TABLE USERS("
			+ "ID VARCHAR2(8),"
			+ "PASSWORD VARCHAR2(8),"
			+ "NAME VARCHAR2(20),"
			+ "ROLE VARCHAR2(5)"
			+ ")";
	private String USER_INSERT = "INSERT INTO USERS (ID,PASSWORD,NAME,ROLE) VALUES (?,?,?,?)";
	private String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";
	
	// 테이블 생성
	public void createTable() {
		System.out.println("==>SPRING JDBC로 createTable() 기능 처리");
		jdbcTemplate.execute(USER_CREATE);
	}
	// 사용자 등록
	public void insertUser(UserVO vo) {
		System.out.println("==>SPRING JDBC로 insertUser() 기능 처리");
		jdbcTemplate.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}
	// 특정 사용자 가져오기
	public UserVO getUser(UserVO vo) {
		System.out.println("==>SPRING JDBC로 getUser() 기능 처리");
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