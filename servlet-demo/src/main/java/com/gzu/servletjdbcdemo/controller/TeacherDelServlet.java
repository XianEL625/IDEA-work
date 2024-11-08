package com.gzu.servletjdbcdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet("/teachers/del/*")
public class TeacherDelServlet extends HttpServlet {
    private TeacherService teacherService = new TeacherServiceImpl();
    private ObjectMapper objectMapper = new ObjectMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Result result = new Result();
        String pathInfo = request.getPathInfo();
        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid teacher ID");
            return;
        }
        Integer id = null ;
        try {
            id = Integer.parseInt(splits[1]);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid student ID format");
        }
        try {
            Teacher teachers = teacherService.delete(id);
            result.setCode("200");
            result.setMessage("删除成功");
            result.setData(teachers);
            out.write(objectMapper.writeValueAsString(result));
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 设置 HTTP 请求状态
            result.setCode("500");
            result.setMessage("删除失败: " + e.getMessage()); // 返回具体的异常信息
            out.write(objectMapper.writeValueAsString(result));
        }
    }
}
