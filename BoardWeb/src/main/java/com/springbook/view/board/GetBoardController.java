package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� �󼼺��� ó��");
		
		// 1. �˻��� �Խñ� ��ȣ ����
		String seq = request.getParameter("seq");

		// 2. DB����
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDao = new BoardDAO();
		BoardVO boardVo = boardDao.getBoard(vo);
		
		// 3. �˻� ����� ȭ�� ������ �����Ͽ� �����Ѵ�
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", boardVo);		// Model ���� ����
		mv.setViewName("getBoard");		// View ���� ����
		return mv;
		
		/*
		�������� �������� �����߾���
		HttpSession session = request.getSession();
		session.setAttribute("board", boardVo);
		return "getBoard";
		*/
	}

}
