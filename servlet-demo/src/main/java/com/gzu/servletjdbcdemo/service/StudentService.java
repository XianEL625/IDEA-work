package com.gzu.servletjdbcdemo.service;

import com.gzu.servletjdbcdemo.entity.Student;

import java.util.List;

public interface StudentService {
    //查询全部学生
    public List<Student> queryAll()throws Exception;
}
