package com.gzu.servletjdbcdemo.dao.impl;

import com.gzu.servletjdbcdemo.dao.StudentDao;
import com.gzu.servletjdbcdemo.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:13306/jdbc_demo?serverTimezone=GMT&characterEncoding=UTF-8";
    // 数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "mimashi625";

    @Override
    public List<Student> queryAll() throws Exception {
        // 定义一个学生列表
        List<Student> students = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行查询
            String sql = "SELECT * FROM student";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                students.add(student);
            }

            return students;
        } catch (SQLException se) {
            se.printStackTrace();
            throw new Exception("数据库错误");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("系统错误");
        } finally {
            // 关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public Student queryById(int id) {
        return null;
    }

    @Override
    public void add(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }


}
