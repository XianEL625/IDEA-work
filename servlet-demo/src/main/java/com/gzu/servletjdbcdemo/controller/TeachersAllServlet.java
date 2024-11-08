package com.gzu.servletjdbcdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzu.servletjdbcdemo.dao.TeacherDao;
import com.gzu.servletjdbcdemo.entity.Teacher;
import com.gzu.servletjdbcdemo.service.TeacherService;
import com.gzu.servletjdbcdemo.service.impl.TeacherServiceImpl;
import com.gzu.servletjdbcdemo.utils.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/teachers")
public class TeachersAllServlet extends HttpServlet {
    private TeacherService teacherService=new TeacherServiceImpl();
    private ObjectMapper objectMapper = new ObjectMapper();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Result result = new Result();
        try {
            List<Teacher> teachers = teacherService.queryAll();
            result.setCode("200");
            result.setMessage("查询成功");
            result.setData(teachers);
            out.write(objectMapper.writeValueAsString(result));
        } catch (Exception e) {
            result.setCode("500");
            result.setMessage("查询失败");
            out.write(objectMapper.writeValueAsString(result));
        }
    }
}
