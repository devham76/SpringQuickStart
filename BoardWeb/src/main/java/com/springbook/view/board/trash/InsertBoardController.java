//package com.springbook.view.board.trash;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.springbook.biz.board.BoardVO;
//import com.springbook.biz.board.impl.BoardDAO;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class InsertBoardController {
//
//	@RequestMapping(value="/insertBoard.do")
//	public String insertBoard(BoardVO vo, BoardDAO boardDao) {
//		// vo, boardDao�� ������ �����̳ʰ� �ڵ����� �������ش�
//		System.out.println("�� ��� ó��");
//		boardDao.insertBoard(vo);
//		return "getBoardList.do";
//	}
//}
