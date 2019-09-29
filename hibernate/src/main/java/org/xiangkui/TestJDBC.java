package org.xiangkui;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args){
        String jdbcURL = "jdbc:mysql://localhost:3306/hibernate?useSSL=false";
        String user = "root";
        String passwd = "12345678";
        try {
            System.out.println("Connecting to database "+jdbcURL);
            Connection connection = DriverManager.getConnection(jdbcURL,user,passwd);
            System.out.println("Successful!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
