package com.gzu.servletjdbcdemo.dao;

import com.gzu.servletjdbcdemo.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    public List<Teacher> queryAll()throws  Exception;
    public Teacher queryById(int id);
    public  void add(Teacher teacher);
    public  void update(Teacher teacher);
    public  void delete(int id);
}
