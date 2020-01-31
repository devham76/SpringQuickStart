package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �������� ó��");
		
		// 1. ����� �Է� ��������(�˻� ����� ���ֿ� ����)
		// 2. DB ���� ó��
		//BoardDAOSpring boardDao = new BoardDAOSpring();
		BoardDAO boardDao = new BoardDAO();
		// ���̺� ����
		//boardDao.createtable();
		// �ӽñ� �ۼ�
		BoardVO vo = new BoardVO();
		vo.setTitle("���� �׽�Ʈ��");
		vo.setWriter("������");
		vo.setContent("�ӽ� �����̶�� spring boot �ѼŹ����ڴ�~~");
		boardDao.insertBoard(vo);
		
		List<BoardVO> boardList = boardDao.getBoardList();
		
		// 3. ������� model�� ����, �̵��Ұ��� view������
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList",boardList);
		mav.setViewName("getBoardList");
		return mav;
	}

}
