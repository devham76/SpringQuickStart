package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtill;;


// DAO(Data Access Object)
@Repository("boardDAO")	// 객체를 자동 생성, boardDAO라는 이름으로 다른곳에서 참조할수있음, repository역할임을 알수있음 
public class BoardDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 쿼리문
	private final String BOARD_INSERT = "insert into board(seq, title, writer"
			+ ", content) values ( (select nvl(max(seq), 0)+1 from board), ?,?,?)";
	
	private final String BOARD_UPDATE = "";
	private final String BOARD_DELETE = "";
	private final String BOARD_GET = "";
	private final String BOARD_LIST = "";
	
	public void insertBoard() {
		
	}
	public void updateBoard() {
		
	}
	public void deleteBoard() {
		
	}
	public void getBoard() {
		
	}
	public List<BoardVO> getBoardList() {
		return null;
	}

}
