package com.sherry.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zxin on 16/11/21.
 */
public class DBConnetctionTest {

    public static void main(String[] args){
        try {
            getDBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getDBConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/beauty?connectTimeout=3000";

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}
