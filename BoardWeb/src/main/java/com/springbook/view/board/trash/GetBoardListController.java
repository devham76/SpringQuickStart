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
//		// �Ű������� �����ϸ� �����̳ʰ� �ڵ����� ��ü�������ش�
//		System.out.println("�� ��� �������� ó��");
//
//		// �ӽñ� �ۼ� - �׽�Ʈ��
//		vo.setTitle("���� �׽�Ʈ��");
//		vo.setWriter("������");
//		vo.setContent("�ӽ� �����̶�� spring boot �ѼŹ����ڴ�~~");
//		boardDao.insertBoard(vo);
//		
//		// 3. ������� model�� ����, �̵��Ұ��� view������
//		mav.addObject("boardList", boardDao.getBoardList());
//		mav.setViewName("getBoardList");
//		return mav;
//	}
//
//}
