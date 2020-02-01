//package com.springbook.view.board.trash;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.springbook.biz.board.BoardVO;
//import com.springbook.biz.board.impl.BoardDAO;
//
//@Controller
//public class GetBoardListController{
//
//	@RequestMapping("/getBoardList.do")
//	public ModelAndView getBoardList(BoardDAO boardDao, BoardVO vo, ModelAndView mav) {
//		// 매개변수로 선언하면 컨테이너가 자동으로 객체생성해준다
//		System.out.println("글 목록 가져오기 처리");
//
//		// 임시글 작성 - 테스트용
//		vo.setTitle("제목 테스트얌");
//		vo.setWriter("이혜미");
//		vo.setContent("임시 내용이라능 spring boot 뿌셔버리자능~~");
//		boardDao.insertBoard(vo);
//		
//		// 3. 결과값을 model에 저장, 이동할곳을 view에저장
//		mav.addObject("boardList", boardDao.getBoardList());
//		mav.setViewName("getBoardList");
//		return mav;
//	}
//
//}
