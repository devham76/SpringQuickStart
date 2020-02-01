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
//		// vo, boardDao는 스프링 컨테이너가 자동으로 생성해준다
//		System.out.println("글 등록 처리");
//		boardDao.insertBoard(vo);
//		return "getBoardList.do";
//	}
//}
