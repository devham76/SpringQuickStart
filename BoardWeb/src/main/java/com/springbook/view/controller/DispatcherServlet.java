package com.springbook.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�.
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. Ŭ���̾�Ʈ�� ��û path�� ���� ������ �б����� �Ѵ�.
		if (path.equals("/login.do")) {
			
			System.out.println("loginó��");
			// 1. ����� �Է� ���� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB���� ó��
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userdao = new UserDAO();
			UserVO user = userdao.getUser(vo);
			if(user != null){
				response.sendRedirect("getBoardList.do");
			}else {
				response.sendRedirect("login.jsp");
			}
			
		} else if (path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			
			HttpSession session = request.getSession();
			// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
			session.invalidate();
			
			// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
			response.sendRedirect("login.jsp");
			
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("�۵�� ó��");
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("updateBoardó��");
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("deleteBoardó��");
		} else if (path.equals("/getBoard.do")) {
			System.out.println("�� �󼼺��� ó��");
			
			
		} else if (path.equals("/getBoardList.do")) {
			System.out.println("getBoardListó��");
		}
	}
}
