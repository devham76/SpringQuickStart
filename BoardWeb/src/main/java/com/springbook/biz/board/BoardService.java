package com.springbook.biz.board;

import java.util.List;

public interface BoardService {

	public void insertBoard();
	public void updateBoard();
	public void deleteBoard();
	public BoardVO getBoard();
	public List<BoardVO> getBoardList();
}
