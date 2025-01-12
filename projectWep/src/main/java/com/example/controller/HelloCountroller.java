package com.example.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloCountroller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // 모델 데이터 설정
        request.setAttribute("message", "Hello, MVC World!");
        return "hello"; // 뷰 이름 반환
    }
}
