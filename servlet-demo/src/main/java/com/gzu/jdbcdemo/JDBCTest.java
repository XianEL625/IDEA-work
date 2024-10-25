package com.gzu.jdbcdemo;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo?serverTimezone=GMT&characterEncoding=UTF-8";
        String user = "root";
        String password = "mimashi625";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 加载mysql驱动
            conn = DriverManager.getConnection(url, user, password);
            // 创建Statement对象
            ps = conn.prepareStatement("SELECT * FROM student");
            // 执行查询
            rs = ps.executeQuery();
            // 输出查询结果
            while (rs.next()) {
                System.out.println(rs.getObject(1)+" "+rs.getObject(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
