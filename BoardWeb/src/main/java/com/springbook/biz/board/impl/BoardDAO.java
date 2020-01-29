package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtill;;


// DAO(Data Access Object)
@Repository("boardDAO")	// ��ü�� �ڵ� ����, boardDAO��� �̸����� �ٸ������� �����Ҽ�����, repository�������� �˼����� 
public class BoardDAO {
	// JDBC ���� ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL ������
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
