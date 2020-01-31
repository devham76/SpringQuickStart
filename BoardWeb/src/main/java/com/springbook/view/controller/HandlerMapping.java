/*
package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.user.*;
import com.springbook.view.board.*;

// path에 따라 사용할 controller 객체를 넘겨준다
public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String,Controller>();
		mappings.put("login.do", new LoginController());
		mappings.put("logout.do", new LogoutController());
		mappings.put("insertBoard.do", new InsertBoardController());
		mappings.put("updateBoard.do", new UpdateBoardController());
		mappings.put("deleteBoard.do", new DeleteBoardController());
		mappings.put("getBoard.do", new GetBoardController());
		mappings.put("getBoardList.do", new GetBoardListController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
*/
