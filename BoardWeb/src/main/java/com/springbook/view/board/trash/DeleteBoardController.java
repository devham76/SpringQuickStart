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
//		System.out.println("글 삭제 처리");
//		boardDao.deleteBoard(board);
//		return "getBoardList.do";
//		
////		// 1. 사용자 입력 정보 추출
////		String seq = request.getParameter("seq");
////		
////		// 2. DB 연동
////		BoardVO board = new BoardVO();
////		board.setSeq(Integer.parseInt(seq));
////		
////		BoardDAO boardDao = new BoardDAO();
////		boardDao.deleteBoard(board);
////		
////		// 3. 화면 네비게이션
////		ModelAndView mv = new ModelAndView();
////		mv.setViewName("redirect:getBoardList.do");
////		return mv;
//	}
//
//}
