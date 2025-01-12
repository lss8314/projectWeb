package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController {
	 public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	        // 로그인 처리
	        if ("POST".equalsIgnoreCase(request.getMethod())) {
	            String username = request.getParameter("username");
	            String password = request.getParameter("password");

	            if ("admin".equals(username) && "password".equals(password)) {
	                request.setAttribute("message", "Login successful!");
	                return "login-success";
	            } else {
	                request.setAttribute("message", "Invalid username or password.");
	                return "login";
	            }
	        }
	        return "login"; // 기본 로그인 페이지
	    }
	 
}
