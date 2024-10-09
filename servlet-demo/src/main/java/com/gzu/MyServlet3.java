package com.gzu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns={"/demo3","/demo3-1"}, loadOnStartup = 1)
public class MyServlet3 extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=utf-8");
        System.out.println("demo3 is running...");
        res.getWriter().write("demo3 is running...");

    }
}
