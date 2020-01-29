package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	private final String BOARD_INSERT = "insert into BOARD (seq, title, writer, content) values ( (select nvl(max(seq), 0)+1 from board), ?,?,?)";
	
	private final String BOARD_UPDATE = "update BOARD set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete BOARD where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD  order by seq desc";

	public void createtable() {
		System.out.println("==>createtable 기능 처리");
		//BoardVO board = null;
		try {
			String BOARD_CREATE = 	"create table board(" + 
					"					seq number(5) primary key," + 
					"					title varchar2(200)," + 
					"					writer varchar2(20)," + 
					"					content varchar2(2000)," + 
					"					regdate date default sysdate," + 
					"					cnt number(5) default 0" + 
					"					)";
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(BOARD_CREATE);
			stmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtill.close(rs, stmt, conn);
		}
	}
	//-- CRUD 기능 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("==>JDBC로 insertBoard() 기능 처리");
		try{
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			System.out.println("~~~>>"+stmt.executeUpdate());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtill.close(stmt, conn);
		}
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("==>JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtill.close(stmt, conn);
		}
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("==>JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtill.close(stmt, conn);
		}
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==>JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtill.close(rs, stmt, conn);
		}
		return board;
	}
	public List<BoardVO> getBoardList() {
		System.out.println("==>JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs!=null) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtill.close(rs, stmt, conn);
		}
		return boardList;
	}

}
