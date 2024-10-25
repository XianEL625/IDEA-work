package com.gzu.Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns="/demo20")
public class MyServlet20 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws SecurityException, IOException {
        System.out.println("demo20 执行了...");
        HttpSession session = req.getSession();

    }


}
