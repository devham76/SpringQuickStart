/*
 * Controller 클래스 통합해서 사용
 * 기존에 사용하던 클래스 파일은 .trash패키지로 옮겼다.
 * 
 * */

package com.springbook.view.board;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDao, Model model) {
		System.out.println("글 상세보기 처리");
		model.addAttribute("board", boardDao.getBoard(vo));		// Model 정보 저장
		return "getBoard.jsp";	// 이동할 View는 String으로 처리
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("작성자", "WRITER");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList( @RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			BoardDAO boardDao, BoardVO vo, Model model) {
		// 매개변수로 선언하면 컨테이너가 자동으로 객체생성해준다
		System.out.println("글 목록 가져오기 처리");

		// 임시글 작성 - 테스트용
		vo.setTitle("제목 테스트얌");
		vo.setWriter("이혜미");
		vo.setContent("임시 내용이라능 spring boot 뿌셔버리자능~~");
		boardDao.insertBoard(vo);
		
		System.out.println("검색 조건 : "+ condition);
		System.out.println("검색 키워드 : " + keyword);
		// 3. 결과값을 model에 저장, 이동할곳(view)을 리턴
		model.addAttribute("boardList", boardDao.getBoardList());
		return "getBoardList.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDao) {
		System.out.println("글 등록 처리");
		boardDao.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO board, BoardDAO boardDao, ModelAndView mav) {
		System.out.println("글 수정 처리");
		boardDao.updateBoard(board);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO board, BoardDAO boardDao) {
		System.out.println("글 삭제 처리");
		boardDao.deleteBoard(board);
		return "getBoardList.do";
	}
}
