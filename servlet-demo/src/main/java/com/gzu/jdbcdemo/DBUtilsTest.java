package com.gzu.jdbcdemo;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class DBUtilsTest {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_demo?serverTimezone=GMT&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "mimashi625";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);
            QueryRunner queryRunner = new QueryRunner();
            String sql = "SELECT * FROM student";
            List<Student> students = queryRunner.query(conn, sql, new BeanListHandler<>(Student.class));
            System.out.println(students);
            String insertSql = "INSERT INTO student(name,age,gender) VALUES(?,?,?)";
            int rowsAffected = queryRunner.update(conn, insertSql, "李四", 20, String.valueOf('女'));
            DbUtils.commitAndClose(conn);
        } catch (SQLException e) {
            try {
                if (conn!= null) {
                    conn.rollback();
                    System.out.println("事务回滚。");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}