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
//		// 1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�.
//		
//		String uri = request.getRequestURI();
//		String path = uri.substring(uri.lastIndexOf("/"));
//		System.out.println(path);
//		
//		// 2. Ŭ���̾�Ʈ�� ��û path�� ���� ������ �б����� �Ѵ�.
//		if (path.equals("/login.do")) {
//			
//			System.out.println("loginó��");
//			// 1. ����� �Է� ���� ����
//			String id = request.getParameter("id");
//			String password = request.getParameter("password");
//			
//			// 2. DB���� ó��
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
//			System.out.println("�α׾ƿ� ó��");
//			
//			HttpSession session = request.getSession();
//			// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
//			session.invalidate();
//			
//			// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
//			response.sendRedirect("login.jsp");
//			
//		} else if (path.equals("/insertBoard.do")) {
//			System.out.println("�� ��� ó��");
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
//			System.out.println("�� ���� ó��");
//			
//			// 1. ����� �Է� ���� ����
//			request.setCharacterEncoding("UTF-8");
//			String title = request.getParameter("title");
//			String content = request.getParameter("title");
//			String seq = request.getParameter("seq");
//			
//			// 2. DB ����
//			BoardVO board = new BoardVO();
//			board.setSeq(Integer.parseInt(seq));
//			board.setTitle(title);
//			board.setContent(content);
//			
//			BoardDAO boardDao = new BoardDAO();
//			boardDao.updateBoard(board);
//			
//			// 3. ȭ�� �׺���̼�
//			response.sendRedirect("getBoardList.do");
//			
//		} else if (path.equals("/deleteBoard.do")) {
//			System.out.println("�� ���� ó��");
//			
//			// 1. ����� �Է� ���� ����
//			String seq = request.getParameter("seq");
//			
//			// 2. DB ����
//			BoardVO board = new BoardVO();
//			board.setSeq(Integer.parseInt(seq));
//			
//			BoardDAO boardDao = new BoardDAO();
//			boardDao.deleteBoard(board);
//			
//			// 3. ȭ�� �׺���̼�
//			response.sendRedirect("getBoardList.do");
//			
//		} else if (path.equals("/getBoard.do")) {
//			System.out.println("�� �󼼺��� ó��");
//			
//			// 1. �˻��� �Խñ� ��ȣ ����
//			String seq = request.getParameter("seq");
//
//			// 2. DB����
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
//			System.out.println("�� ��� �������� ó��");
//			
//			// 1. ����� �Է� ��������(�˻� ����� ���ֿ� ����)
//			// 2. DB ���� ó��
//			//BoardDAOSpring boardDao = new BoardDAOSpring();
//			BoardDAO boardDao = new BoardDAO();
//			// ���̺� ����
//			//boardDao.createtable();
//			// �ӽñ� �ۼ�
//			BoardVO vo = new BoardVO();
//			vo.setTitle("���� �׽�Ʈ��");
//			vo.setWriter("������");
//			vo.setContent("�ӽ� �����̶�� spring boot �ѼŹ����ڴ�~~");
//			boardDao.insertBoard(vo);
//			
//			List<BoardVO> boardList = boardDao.getBoardList();
//			
//			// 3. ���ǿ� ��Ƽ� ����
//			HttpSession session = request.getSession();
//			session.setAttribute("boardList",boardList);
//			response.sendRedirect("getBoardList.jsp");
//			
//		}
//	}
//}
