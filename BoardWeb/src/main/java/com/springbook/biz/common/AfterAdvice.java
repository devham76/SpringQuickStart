package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.board.BoardVO;

public class AfterAdvice {
	public void finallyLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if(returnObj instanceof BoardVO) {
			BoardVO board = (BoardVO)returnObj;
			if(board.getCnt() == 0) {
				System.out.println("cnt값은 0");
			}
		}
		System.out.println("[사후 처리] "+method+ returnObj.toString());
	}
}
