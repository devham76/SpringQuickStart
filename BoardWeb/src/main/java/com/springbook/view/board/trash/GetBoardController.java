//package com.springbook.view.board.trash;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.springbook.biz.board.BoardVO;
//import com.springbook.biz.board.impl.BoardDAO;
//
//@Controller
//public class GetBoardController{
//
//	@RequestMapping("/getBoard.do")
//	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDao, ModelAndView mv) {
//		System.out.println("�� �󼼺��� ó��");
//		
////		// 1. �˻��� �Խñ� ��ȣ ����
////		String seq = request.getParameter("seq");
////
////		// 2. DB����
////		BoardVO vo = new BoardVO();
////		vo.setSeq(Integer.parseInt(seq));
////		
////		BoardDAO boardDao = new BoardDAO();
////		BoardVO boardVo = boardDao.getBoard(vo);
//		
//		// 3. �˻� ����� ȭ�� ������ �����Ͽ� �����Ѵ�
//		mv.addObject("board", boardDao.getBoard(vo));		// Model ���� ����
//		mv.setViewName("getBoard");		// View ���� ����
//		return mv;
//		
//		/*
//		�������� �������� �����߾���
//		HttpSession session = request.getSession();
//		session.setAttribute("board", boardVo);
//		return "getBoard";
//		*/
//	}
//
//}
