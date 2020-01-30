package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.LogAdvice;


@Service("boardService")	// 객체를 자동으로 생성, Component대신 Service로 사용했다.
public class BoardServiceImpl implements BoardService {
	
	@Autowired	// 의존성 주입, boardDAO이름으로 객체 생성됨
	private BoardDAOSpring boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
	//	if(vo.getSeq() == 0)
	//		throw new IllegalArgumentException("0번 글은 등록불가합니다 ");
		boardDAO.insertBoard(vo);
	}
 
	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
	public void createtable() {
		boardDAO.createtable();
	}

}
