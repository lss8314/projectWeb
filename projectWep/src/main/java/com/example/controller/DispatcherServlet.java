package com.example.controller;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

public class DispatcherServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI().substring(request.getContextPath().length());

        // 라우팅
        if (path.equals("/hello")) {
        	HelloCountroller controller = new HelloCountroller();
            String viewName = controller.handleRequest(request, response);

            // JSP로 포워드
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/" + viewName + ".jsp");
            dispatcher.forward(request, response);
        } else if (path.equals("/login")) {
            LoginController controller = new LoginController();
            String viewName = controller.handleRequest(request, response);

            // JSP로 포워드
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/" + viewName + ".jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page Not Found");
        }
    }
}
