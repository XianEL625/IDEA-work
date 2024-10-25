package com.gzu.Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/demo18")
public class MyServlet18 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws SecurityException,IOException{
        System.out.println("demo18 执行了...");
        Cookie cookie=new Cookie("name","张三");
        cookie.setMaxAge(3600); // 设置有效期为1小时
        cookie.setDomain("example.com");
        cookie.setPath("/");
        resp.addCookie(cookie);
    }


}
