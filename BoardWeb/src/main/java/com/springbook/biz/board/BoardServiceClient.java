package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너 구동한다.
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 BoardServiceImpl 객체를 요청(Lookup)한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//-- 테이블 생성 테스트 
		boardService.createtable();
		
		// 3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("제목 테스트얌");
		vo.setWriter("이혜미");
		vo.setContent("임시 내용이라능 spring boot 뿌셔버리자능~~");
		boardService.insertBoard(vo);
		
		// 4. 글 목록 검색 기능 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board:boardList) {
			System.out.println("-->"+board.toString());
		}
		
		// 5. Spring컨터이터 종료
		container.close();
	}

}
