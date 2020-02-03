/*
 * Controller 클래스 통합해서 사용
 * 기존에 사용하던 클래스 파일은 .trash패키지로 옮겼다.
 * 
 * */

package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")	// Model에 board라는 이름으로 저장되는 데이터가 있다면 세션에 자동으로 저장한다
public class BoardController {
	@Autowired
	private BoardService boardService;
	
//	@RequestMapping("/getBoard.do")
//	public String getBoard(BoardVO vo, BoardDAO boardDao, Model model) {
//		System.out.println("글 상세보기 처리");
//		model.addAttribute("board", boardDao.getBoard(vo));		// Model 정보 저장
//		return "getBoard.jsp";	// 이동할 View는 String으로 처리
//	}
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo) {
		System.out.println("글 상세보기 처리");
		boardService.getBoard(vo);
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
	public String getBoardList(BoardVO vo, Model model) {
		// 매개변수로 선언하면 컨테이너가 자동으로 객체생성해준다
		System.out.println("글 목록 가져오기 처리");
		boardService.createtable();
		// null check
		if (vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		// 3. 결과값을 model에 저장, 이동할곳(view)을 리턴
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		System.out.println("글 등록 처리");
		
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/" + fileName));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		//@ModelAttribute : board로 저장된 데이터가 있는지 확인 후, 세션에서 꺼내서 vo에 할당
		System.out.println("글 수정 처리");
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO board) {
		System.out.println("글 삭제 처리");
		boardService.deleteBoard(board);
		return "getBoardList.do";
	}
}
