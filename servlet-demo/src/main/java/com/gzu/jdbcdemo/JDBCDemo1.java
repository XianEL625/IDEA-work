package com.gzu.jdbcdemo;
import java.sql.*;
public class JDBCDemo1 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo?serverTimezone=GMT&characterEncoding=UTF-8";
        String user = "root";
        String password = "mimashi625";
        String sql=" ";
        try(Connection conn =DriverManager.getConnection(url,user,password)){
            try {
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
