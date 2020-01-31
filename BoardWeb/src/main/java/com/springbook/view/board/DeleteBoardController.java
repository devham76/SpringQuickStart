package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;


public class DeleteBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ���� ó��");
		
		// 1. ����� �Է� ���� ����
		String seq = request.getParameter("seq");
		
		// 2. DB ����
		BoardVO board = new BoardVO();
		board.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDao = new BoardDAO();
		boardDao.deleteBoard(board);
		
		// 3. ȭ�� �׺���̼�
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:getBoardList.do");
		return mv;
	}

}
