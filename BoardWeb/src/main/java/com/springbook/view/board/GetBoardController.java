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
		System.out.println("글 상세보기 처리");
		
		// 1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");

		// 2. DB연동
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDao = new BoardDAO();
		BoardVO boardVo = boardDao.getBoard(vo);
		
		// 3. 검색 결과와 화면 정보를 저장하여 리턴한다
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", boardVo);		// Model 정보 저장
		mv.setViewName("getBoard");		// View 정보 저장
		return mv;
		
		/*
		기존에는 세션으로 저장했었다
		HttpSession session = request.getSession();
		session.setAttribute("board", boardVo);
		return "getBoard";
		*/
	}

}
