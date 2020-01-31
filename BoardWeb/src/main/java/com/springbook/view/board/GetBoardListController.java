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
		System.out.println("글 목록 가져오기 처리");
		
		// 1. 사용자 입력 정보추출(검색 기능은 나주에 구현)
		// 2. DB 연동 처리
		//BoardDAOSpring boardDao = new BoardDAOSpring();
		BoardDAO boardDao = new BoardDAO();
		// 테이블 생성
		//boardDao.createtable();
		// 임시글 작성
		BoardVO vo = new BoardVO();
		vo.setTitle("제목 테스트얌");
		vo.setWriter("이혜미");
		vo.setContent("임시 내용이라능 spring boot 뿌셔버리자능~~");
		boardDao.insertBoard(vo);
		
		List<BoardVO> boardList = boardDao.getBoardList();
		
		// 3. 결과값을 model에 저장, 이동할곳을 view에저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList",boardList);
		mav.setViewName("getBoardList");
		return mav;
	}

}
