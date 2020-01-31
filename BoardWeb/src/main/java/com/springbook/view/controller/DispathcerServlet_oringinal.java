//
//package com.springbook.view.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.springbook.biz.board.BoardVO;
//import com.springbook.biz.board.impl.BoardDAO;
//import com.springbook.biz.user.UserVO;
//import com.springbook.biz.user.impl.UserDAO;
//
///**
// * Servlet implementation class DispatcherServlet
// */
//public class DispathcerServlet_oringinal extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DispathcerServlet_oringinal() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		process(request,response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		process(request,response);
//	}
//	
//	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
//		// 1. 클라이언트의 요청 path 정보를 추출한다.
//		
//		String uri = request.getRequestURI();
//		String path = uri.substring(uri.lastIndexOf("/"));
//		System.out.println(path);
//		
//		// 2. 클라이언트의 요청 path에 따랄 적절히 분기저리 한다.
//		if (path.equals("/login.do")) {
//			
//			System.out.println("login처리");
//			// 1. 사용자 입력 정보 추출
//			String id = request.getParameter("id");
//			String password = request.getParameter("password");
//			
//			// 2. DB연동 처리
//			UserVO vo = new UserVO();
//			vo.setId(id);
//			vo.setPassword(password);
//			
//			UserDAO userdao = new UserDAO();
//			UserVO user = userdao.getUser(vo);
//			if(user != null){
//				response.sendRedirect("getBoardList.do");
//			}else {
//				response.sendRedirect("login.jsp");
//			}
//			
//		} else if (path.equals("/logout.do")) {
//			System.out.println("로그아웃 처리");
//			
//			HttpSession session = request.getSession();
//			// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
//			session.invalidate();
//			
//			// 2. 세션 종료 후, 메인 화면으로 이동한다.
//			response.sendRedirect("login.jsp");
//			
//		} else if (path.equals("/insertBoard.do")) {
//			System.out.println("글 등록 처리");
//			String title = request.getParameter("title");
//			String writer = request.getParameter("writer");
//			String content = request.getParameter("content");
//			
//			BoardVO vo = new BoardVO();
//			vo.setTitle(title);
//			vo.setWriter(writer);
//			vo.setContent(content);
//			
//			BoardDAO boardDao = new BoardDAO();
//			boardDao.insertBoard(vo);
//			
//			response.sendRedirect("getBoardList.do");
//			
//		} else if (path.equals("/updateBoard.do")) {
//			System.out.println("글 수정 처리");
//			
//			// 1. 사용자 입력 정보 추출
//			request.setCharacterEncoding("UTF-8");
//			String title = request.getParameter("title");
//			String content = request.getParameter("title");
//			String seq = request.getParameter("seq");
//			
//			// 2. DB 연동
//			BoardVO board = new BoardVO();
//			board.setSeq(Integer.parseInt(seq));
//			board.setTitle(title);
//			board.setContent(content);
//			
//			BoardDAO boardDao = new BoardDAO();
//			boardDao.updateBoard(board);
//			
//			// 3. 화면 네비게이션
//			response.sendRedirect("getBoardList.do");
//			
//		} else if (path.equals("/deleteBoard.do")) {
//			System.out.println("글 삭제 처리");
//			
//			// 1. 사용자 입력 정보 추출
//			String seq = request.getParameter("seq");
//			
//			// 2. DB 연동
//			BoardVO board = new BoardVO();
//			board.setSeq(Integer.parseInt(seq));
//			
//			BoardDAO boardDao = new BoardDAO();
//			boardDao.deleteBoard(board);
//			
//			// 3. 화면 네비게이션
//			response.sendRedirect("getBoardList.do");
//			
//		} else if (path.equals("/getBoard.do")) {
//			System.out.println("글 상세보기 처리");
//			
//			// 1. 검색할 게시글 번호 추출
//			String seq = request.getParameter("seq");
//
//			// 2. DB연동
//			BoardVO vo = new BoardVO();
//			vo.setSeq(Integer.parseInt(seq));
//			
//			BoardDAO boardDao = new BoardDAO();
//			BoardVO boardVo = boardDao.getBoard(vo);
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("board", boardVo);
//			response.sendRedirect("getBoard.jsp");
//			
//			
//		} else if (path.equals("/getBoardList.do")) {
//			System.out.println("글 목록 가져오기 처리");
//			
//			// 1. 사용자 입력 정보추출(검색 기능은 나주에 구현)
//			// 2. DB 연동 처리
//			//BoardDAOSpring boardDao = new BoardDAOSpring();
//			BoardDAO boardDao = new BoardDAO();
//			// 테이블 생성
//			//boardDao.createtable();
//			// 임시글 작성
//			BoardVO vo = new BoardVO();
//			vo.setTitle("제목 테스트얌");
//			vo.setWriter("이혜미");
//			vo.setContent("임시 내용이라능 spring boot 뿌셔버리자능~~");
//			boardDao.insertBoard(vo);
//			
//			List<BoardVO> boardList = boardDao.getBoardList();
//			
//			// 3. 세션에 담아서 전달
//			HttpSession session = request.getSession();
//			session.setAttribute("boardList",boardList);
//			response.sendRedirect("getBoardList.jsp");
//			
//		}
//	}
//}
