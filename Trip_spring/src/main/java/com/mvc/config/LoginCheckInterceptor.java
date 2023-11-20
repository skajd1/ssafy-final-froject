package com.mvc.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.SessionManager;

public class LoginCheckInterceptor implements HandlerInterceptor {

	private SessionManager sessionManager = new SessionManager();
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
//		if(sessionManager.getSession(request) == null) {
//			System.out.println(123);
//			response.sendError(404,"너 못들어와");
//			
//			return false;
//		}
		return true;
	}
}
