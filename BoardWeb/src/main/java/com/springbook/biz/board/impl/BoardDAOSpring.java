package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtill;

// DAO(Data Access Object)
@Repository // 객체 생성 @Component와 비슷한일을 하지만 데이터 관리에 더 특화되어있다
public class BoardDAOSpring {
	
	@Autowired // 의존성주입  해당 객체는 설정파일에서 bean으로 만들어줬다
	private JdbcTemplate jdbcTemplate;
	
	// SQL 쿼리문
	private final String BOARD_INSERT 	= "insert into BOARD (seq, title, writer, content) values ( (select nvl(max(seq), 0)+1 from board), ?,?,?)";
	private final String BOARD_UPDATE 	= "update BOARD set title=?, content=? where seq=?";
	private final String BOARD_DELETE	= "delete BOARD where seq=?";
	private final String BOARD_GET 		= "select * from BOARD  where seq=?";
	private final String BOARD_LIST 	= "select * from BOARD  order by seq desc";
	private final String BOARD_CREATE 	= 	"create table board(" + 
			"					seq number(5) primary key," + 
			"					title varchar2(200)," + 
			"					writer varchar2(20)," + 
			"					content varchar2(2000)," + 
			"					regdate date default sysdate," + 
			"					cnt number(5) default 0" + 
			"					)";
	
	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
	
	
	public void createtable() {
		System.out.println("==>SPRING JDBC로 createtable() 기능 처리");
		jdbcTemplate.execute(BOARD_CREATE);
	}
	//-- CRUD 기능 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("==>SPRING JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("==>SPRING JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("==>SPRING JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==>SPRING JDBC로 getBoard() 기능 처리");		
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("==>SPRING JDBC로 getBoardList() 기능 처리");
		String query="";
		if (vo.getSearchCondition().equals("TITLE"))
			query = BOARD_LIST_T;
		else if (vo.getSearchCondition().equals("CONTENT"))
			query = BOARD_LIST_C;
		
		//return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
		Object[] args = {vo.getSearchKeyword()};
		return jdbcTemplate.query(query, args, new BoardRowMapper());
	}
}
class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}
	
}
