package com.gzu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns="/demo19")
public class MyServlet19 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws SecurityException, IOException {
        System.out.println("demo19 执行了...");
        HttpSession session = req.getSession();
        String gender=(String) session.getAttribute("gender");
        System.out.println("Session id:");

    }


}
