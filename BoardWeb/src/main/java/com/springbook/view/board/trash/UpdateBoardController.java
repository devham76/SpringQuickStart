//package com.springbook.view.board.trash;
//
//import java.io.UnsupportedEncodingException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.springbook.biz.board.BoardVO;
//import com.springbook.biz.board.impl.BoardDAO;
//
//@Controller
//public class UpdateBoardController {
//
//	@RequestMapping("/updateBoard.do")
//	public String updateBoard(BoardVO board, BoardDAO boardDao, ModelAndView mav) {
//		System.out.println("�� ���� ó��");
//		boardDao.updateBoard(board);
//		return "getBoardList.do";
//		
////		// 1. ����� �Է� ���� ����
////		try {
////			request.setCharacterEncoding("UTF-8");
////		} catch (UnsupportedEncodingException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		String title = request.getParameter("title");
////		String content = request.getParameter("title");
////		String seq = request.getParameter("seq");
////		
////		// 2. DB ����
////		BoardVO board = new BoardVO();
////		board.setSeq(Integer.parseInt(seq));
////		board.setTitle(title);
////		board.setContent(content);
////		
////		BoardDAO boardDao = new BoardDAO();
////		boardDao.updateBoard(board);
//		
//		// 3. ȭ�� �׺���̼�
////		mav.setViewName("redirect:getBoardList.do");
////		return mav;
//		
//	}
//
//	
//}
