package com.gzu.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/demo17")
public class MyServlet17 extends MyServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        System.out.println("demo17 执行了...");

        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            Arrays.stream(cookies).forEach(cookie -> {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            });
        }
    }
}
