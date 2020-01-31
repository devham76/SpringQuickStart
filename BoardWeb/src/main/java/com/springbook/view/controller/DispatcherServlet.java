///*
///package com.springbook.view.controller;
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
//public class DispatcherServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    private HandlerMapping handlerMapping;
//    private ViewResolver viewResolver;
//	
//    
//    // 스블릿 실행시 초기에 무조건 실행됨
//	public void init() throws ServletException{
//		// 어떤 컨트롤러를 가져올지 정함
//		handlerMapping = new HandlerMapping();
//		// 컨트롤러 실행 후 경로 지정
//		viewResolver = new ViewResolver();
//		viewResolver.setPrefix("./");
//		viewResolver.setSuffix(".jsp");
//	}
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
//		
//		// 1. 클라이언트의 요청 path 정보를 추출한다.
//		String uri = request.getRequestURI();
//		String path = uri.substring(uri.lastIndexOf("/"));
//		System.out.println(path);
//		
//		// 2. HandlerMappling을 통해 path에 해당하는 Controller반환
//		Controller ctrl = handlerMapping.getController(path);
//		
//		// 3. 검색된 Controller실행 후에 결과 파일 반환
//		String viewName = ctrl.handleRequest(request, response);
//		
//		 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
//		String view = null;
//		if(!viewName.contains(".do")) {
//			view = viewResolver.getView(viewName);
//		} else {
//			view = viewName;
//		}
//		
//		// 5. 해당화면으로 이동
//		response.sendRedirect(viewName);
//	}
//}
