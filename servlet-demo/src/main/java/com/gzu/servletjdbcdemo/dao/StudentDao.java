package com.gzu.servletjdbcdemo.dao;

import com.gzu.servletjdbcdemo.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> queryAll()throws  Exception;
    public  Student queryById(int id);
    public  void add(Student student);
    public  void update(Student student);
    public  void delete(int id);
}
