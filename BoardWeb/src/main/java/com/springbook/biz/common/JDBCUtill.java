package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtill {

	// DB연결 
	public static Connection getConnection() {
		try {
			Class.forName ("org.h2.Driver"); 
			return DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
		}catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return null;
	}
	
	// DB접속 연결 해제
	public static void close(PreparedStatement stmt, Connection conn) {
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if (conn != null) {
			try {
				if(!conn.isClosed()) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	// DB접속 연결 해제
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if(rs != null) {
			try {
				if(!rs.isClosed()) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
		
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if (conn != null) {
			try {
				if(!conn.isClosed()) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
}
