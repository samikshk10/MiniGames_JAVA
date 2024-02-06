/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

import java.sql.*;
/**
 *
 * @author Samik Shk
 */
public class DBConnection {

    public  static final String DB_url = "jdbc:mysql://localhost/snakeandladder";
    public  static final String username= "root";
    public static final String password = "";
    public static Connection connectDB(){
        Connection conn;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_url, username, password);
            System.out.println("Database connection successfull");
            return conn;

        }catch(Exception ex)
        {
            System.out.println(ex);
            return null;
        }
    }


}