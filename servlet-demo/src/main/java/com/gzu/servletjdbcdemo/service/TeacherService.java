package com.gzu.servletjdbcdemo.service;

import com.gzu.servletjdbcdemo.entity.Teacher;

import java.util.List;

public interface TeacherService {
    //查询全部学生
    public List<Teacher> queryAll()throws Exception;
    public Teacher queryById(int id);
    public Teacher add(Teacher teacher);
    public Teacher update(Teacher teacher);
    public Teacher delete(int id);
}
