package com.gzu.Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2")
public class MyServlet2 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("MyServlet2 正在初始化...");
    }
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        res.setContentType("text/html;charset=utf-8");
        System.out.println("demo2 is running...");
        res.getWriter().write("demo2 is running...");
    }
    public void destroy() {
        System.out.println("MyServlet2 正在被销毁");
    }
}