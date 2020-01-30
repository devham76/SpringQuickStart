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
@Repository // ��ü ���� @Component�� ��������� ������ ������ ������ �� Ưȭ�Ǿ��ִ�
public class BoardDAOSpring {
	
	@Autowired // ����������  �ش� ��ü�� �������Ͽ��� bean���� ��������
	private JdbcTemplate jdbcTemplate;
	
	// SQL ������
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
	
	public void createtable() {
		System.out.println("==>SPRING JDBC�� createtable() ��� ó��");
		jdbcTemplate.execute(BOARD_CREATE);
	}
	//-- CRUD ��� �޼ҵ� ����
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("==>SPRING JDBC�� insertBoard() ��� ó��");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("==>SPRING JDBC�� updateBoard() ��� ó��");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("==>SPRING JDBC�� deleteBoard() ��� ó��");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==>SPRING JDBC�� getBoard() ��� ó��");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList() {
		System.out.println("==>SPRING JDBC�� getBoardList() ��� ó��");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
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
