//package com.springbook.view.board.trash;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.springbook.biz.board.BoardVO;
//import com.springbook.biz.board.impl.BoardDAO;
//
//@Controller
//public class DeleteBoardController{
//	
//	@RequestMapping("/deleteBoard.do")
//	public String deleteBoard(BoardVO board, BoardDAO boardDao) {
//		System.out.println("�� ���� ó��");
//		boardDao.deleteBoard(board);
//		return "getBoardList.do";
//		
////		// 1. ����� �Է� ���� ����
////		String seq = request.getParameter("seq");
////		
////		// 2. DB ����
////		BoardVO board = new BoardVO();
////		board.setSeq(Integer.parseInt(seq));
////		
////		BoardDAO boardDao = new BoardDAO();
////		boardDao.deleteBoard(board);
////		
////		// 3. ȭ�� �׺���̼�
////		ModelAndView mv = new ModelAndView();
////		mv.setViewName("redirect:getBoardList.do");
////		return mv;
//	}
//
//}
