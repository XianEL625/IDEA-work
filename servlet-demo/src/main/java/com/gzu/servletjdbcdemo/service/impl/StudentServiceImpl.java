package com.gzu.servletjdbcdemo.service.impl;

import com.gzu.servletjdbcdemo.dao.StudentDao;
import com.gzu.servletjdbcdemo.dao.impl.StudentDaoImpl;
import com.gzu.servletjdbcdemo.entity.Student;
import com.gzu.servletjdbcdemo.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> queryAll() throws Exception {
        return studentDao.queryAll();
    }
}
