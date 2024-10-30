package com.gzu.servletjdbcdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzu.servletjdbcdemo.entity.Student;
import com.gzu.servletjdbcdemo.service.StudentService;
import com.gzu.servletjdbcdemo.service.impl.StudentServiceImpl;
import com.gzu.servletjdbcdemo.utils.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentAllServlet extends HttpServlet {
    private StudentService studentService=new StudentServiceImpl();
    private ObjectMapper objectMapper = new ObjectMapper();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Result result = new Result();
        try {
            List<Student> students = studentService.queryAll();
            result.setCode("200");
            result.setMessage("查询成功");
            result.setData(students);
            out.write(objectMapper.writeValueAsString(result));
        } catch (Exception e) {
            result.setCode("500");
            result.setMessage("查询失败");
            out.write(objectMapper.writeValueAsString(result));
        }
    }
}
