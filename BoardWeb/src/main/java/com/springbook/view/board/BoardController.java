/*
 * Controller Ŭ���� �����ؼ� ���
 * ������ ����ϴ� Ŭ���� ������ .trash��Ű���� �Ű��.
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
		System.out.println("�� �󼼺��� ó��");
		model.addAttribute("board", boardDao.getBoard(vo));		// Model ���� ����
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
	public String getBoardList( @RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			BoardDAO boardDao, BoardVO vo, Model model) {
		// �Ű������� �����ϸ� �����̳ʰ� �ڵ����� ��ü�������ش�
		System.out.println("�� ��� �������� ó��");

		// �ӽñ� �ۼ� - �׽�Ʈ��
		vo.setTitle("���� �׽�Ʈ��");
		vo.setWriter("������");
		vo.setContent("�ӽ� �����̶�� spring boot �ѼŹ����ڴ�~~");
		boardDao.insertBoard(vo);
		
		System.out.println("�˻� ���� : "+ condition);
		System.out.println("�˻� Ű���� : " + keyword);
		// 3. ������� model�� ����, �̵��Ұ�(view)�� ����
		model.addAttribute("boardList", boardDao.getBoardList());
		return "getBoardList.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDao) {
		System.out.println("�� ��� ó��");
		boardDao.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO board, BoardDAO boardDao, ModelAndView mav) {
		System.out.println("�� ���� ó��");
		boardDao.updateBoard(board);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO board, BoardDAO boardDao) {
		System.out.println("�� ���� ó��");
		boardDao.deleteBoard(board);
		return "getBoardList.do";
	}
}
