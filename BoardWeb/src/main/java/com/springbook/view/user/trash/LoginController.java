//package com.springbook.view.user.trash;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
////import org.springframework.web.servlet.mvc.Controller;
//
//import com.springbook.biz.user.UserVO;
//import com.springbook.biz.user.impl.UserDAO;
//
//
//@Controller
//public class LoginController{
//
//	@RequestMapping("/login.do")
//	public String login(UserVO vo, UserDAO userdao) {
//		System.out.println("loginó��");
//		if(userdao.getUser(vo) != null){
//			return "getBoardList.do";
//		}
//		else {
//			return "login.jsp";
//		}
////		// 1. ����� �Է� ���� ����
////		String id = request.getParameter("id");
////		String password = request.getParameter("password");
////		
////		// 2. DB���� ó��
////		UserVO vo = new UserVO();
////		vo.setId(id);
////		vo.setPassword(password);
////		
////		UserDAO userdao = new UserDAO();
////		UserVO user = userdao.getUser(vo);
////		
////		// 3. ȭ��׺���̼�
////		ModelAndView mav = new ModelAndView();
////		if(user != null){
////			mav.setViewName("redirect:getBoardList.do");
////		}else {
////			mav.setViewName("recirect:login.jsp");
////		}
//		
//	}
//}
