/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dujun
 */
public class DBManager {

    String conn = "jdbc:mysql://localhost:3307/dbhockeyleague?useSSL=false&serverTimezone=Asia/Shanghai";
    String user = "root";
    String pass = "pass";
    String driver = "com.mysql.cj.jdbc.Driver";

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(conn, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error getting connection: " + e);
        }
        return con;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Connection con = getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                rs = st.executeQuery(sql);
            }
        } catch (Exception e) {
            System.out.println("Error executing query: " + e);
        }

        return rs;
    }

    public int executeUpdate(String sql) {
        int update = -1;
        try {
            Connection con = getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                update = st.executeUpdate(sql);
            }
        } catch (Exception e) {
            System.out.println("Error executing update: " + e);
        }
        return update;
    }
}
