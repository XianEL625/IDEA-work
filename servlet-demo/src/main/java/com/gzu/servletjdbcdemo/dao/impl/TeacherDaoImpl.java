package com.gzu.servletjdbcdemo.dao.impl;

import com.gzu.servletjdbcdemo.dao.TeacherDao;
import com.gzu.servletjdbcdemo.entity.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_test?serverTimezone=GMT&characterEncoding=UTF-8";
    // 数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "mimashi625";

    @Override
    public List<Teacher> queryAll() throws Exception {
        // 定义一个学生列表
        List<Teacher> students = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行查询
            String sql = "SELECT * FROM teacher";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setCourse(rs.getString("course"));
                teacher.setBirthday(rs.getDate("birthday"));
                students.add(teacher);
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
    public Teacher queryById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行查询
            String sql = "SELECT * FROM teacher WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            Teacher teacher = new Teacher();
            if (rs.next()) {
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setCourse(rs.getString("course"));
                teacher.setBirthday(rs.getDate("birthday"));
            }
            return teacher;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public void add(Teacher teacher) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO teacher(id, name, course, birthday) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, teacher.id);
            pstmt.setString(2, teacher.name);
            pstmt.setString(3, teacher.course);

            // 将 java.util.Date 转换为 java.sql.Date
            pstmt.setDate(4, new java.sql.Date(teacher.birthday.getTime()));

            pstmt.executeUpdate(); // 使用 executeUpdate
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void update(Teacher teacher) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE teacher SET id=?, name=?, course=?, birthday=? WHERE id=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, teacher.id);
            pstmt.setString(2, teacher.name);
            pstmt.setString(3, teacher.course);

            // 将 java.util.Date 转换为 java.sql.Date
            pstmt.setDate(4, new java.sql.Date(teacher.birthday.getTime()));
            pstmt.setInt(5, teacher.id);
            pstmt.executeUpdate(); // 使用 executeUpdate
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "delete from teacher where id=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate(); // 使用 executeUpdate
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


}
