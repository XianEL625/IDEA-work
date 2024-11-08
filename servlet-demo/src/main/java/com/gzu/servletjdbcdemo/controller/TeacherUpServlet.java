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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/teachers/up/*")
public class TeacherUpServlet extends HttpServlet {
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

        if (splits.length != 5) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "输入格式无效，应该是 /teachers/add/id/name/course/birthday");
            return;
        }

        int id;
        String name;
        String course;
        String birthdaystr;
        try {
            id = Integer.parseInt(splits[1]);
            name = splits[2];
            course = splits[3];
            birthdaystr = splits[4];
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "教师ID格式无效");
            return;
        }

        Date birthday;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = dateFormat.parse(birthdaystr);
        } catch (ParseException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "生日格式无效，应为 yyyy-MM-dd");
            return;
        }

        Teacher teacher = new Teacher();
        teacher.id = id;
        teacher.name = name;
        teacher.course = course;
        teacher.birthday = birthday;

        try {
            Teacher teachers = teacherService.update(teacher);
            result.setCode("200");
            result.setMessage("更新成功");
            result.setData(teachers);
            out.write(objectMapper.writeValueAsString(result));
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 设置 HTTP 请求状态
            result.setCode("500");
            result.setMessage("更新失败: " + e.getMessage()); // 返回具体的异常信息
            out.write(objectMapper.writeValueAsString(result));
        }
    }
}
