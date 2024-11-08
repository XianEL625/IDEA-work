package com.gzu.servletjdbcdemo.service.impl;

import com.gzu.servletjdbcdemo.dao.TeacherDao;
import com.gzu.servletjdbcdemo.dao.impl.TeacherDaoImpl;
import com.gzu.servletjdbcdemo.entity.Teacher;
import com.gzu.servletjdbcdemo.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public List<Teacher> queryAll() throws Exception {
        return teacherDao.queryAll();
    }
    @Override
    public Teacher queryById(int id){
        return teacherDao.queryById(id);
    }

    @Override
    public Teacher add(Teacher teacher) {
        teacherDao.add(teacher);
        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) {
        teacherDao.update(teacher);
        return teacher;
    }

    @Override
    public Teacher delete(int id) {
        teacherDao.delete(id);
        return null;
    }
}
