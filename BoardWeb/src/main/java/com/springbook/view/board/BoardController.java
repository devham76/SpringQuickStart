/*
 * Controller Ŭ���� �����ؼ� ���
 * ������ ����ϴ� Ŭ���� ������ .trash��Ű���� �Ű��.
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
@SessionAttributes("board")	// Model�� board��� �̸����� ����Ǵ� �����Ͱ� �ִٸ� ���ǿ� �ڵ����� �����Ѵ�
public class BoardController {
	@Autowired
	private BoardService boardService;
	
//	@RequestMapping("/getBoard.do")
//	public String getBoard(BoardVO vo, BoardDAO boardDao, Model model) {
//		System.out.println("�� �󼼺��� ó��");
//		model.addAttribute("board", boardDao.getBoard(vo));		// Model ���� ����
//		return "getBoard.jsp";	// �̵��� View�� String���� ó��
//	}
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo) {
		System.out.println("�� �󼼺��� ó��");
		boardService.getBoard(vo);
		return "getBoard.jsp";	// �̵��� View�� String���� ó��
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("�ۼ���", "WRITER");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		// �Ű������� �����ϸ� �����̳ʰ� �ڵ����� ��ü�������ش�
		System.out.println("�� ��� �������� ó��");
		boardService.createtable();
		// null check
		if (vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		// 3. ������� model�� ����, �̵��Ұ�(view)�� ����
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		System.out.println("�� ��� ó��");
		
		// ���� ���ε� ó��
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
		//@ModelAttribute : board�� ����� �����Ͱ� �ִ��� Ȯ�� ��, ���ǿ��� ������ vo�� �Ҵ�
		System.out.println("�� ���� ó��");
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO board) {
		System.out.println("�� ���� ó��");
		boardService.deleteBoard(board);
		return "getBoardList.do";
	}
}
