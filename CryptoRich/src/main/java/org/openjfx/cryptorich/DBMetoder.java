/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.cryptorich;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author peter
 */
public class DBMetoder {

    private final String connectionString = "jdbc:sqlite:src/cryptoRichDB.db";
    public String UserExists;

    public void RegisterUser(User u, String userConfirm) throws SQLException, Exception {
        Connection conn = null;
        Class.forName("org.sqlite.JDBC");
        String sql = "SELECT * FROM User WHERE Username = '" + userConfirm + "'";
        String sql2 = "INSERT INTO User(Username,Password) VALUES('" + u.getUsername() + "','" + u.getPassword() + "');";
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(connectionString);
            System.out.println("Working db connection");
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        if (u.getIdUser() != -1) {

        } else {
            if (UserExists == "Username already exists") {
                UserExists = null;
            } else {
                try {
                    ps = conn.prepareStatement(sql);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        UserExists = "Username already exists";

                    }

                } catch (SQLException e) {
                    System.out.println("Gone wrong");

                }

                try {
                    ps = conn.prepareStatement(sql2);
                    ps.executeUpdate();
                   UserExists = "Succesful registration";

                } catch (SQLException e) {
                    System.out.println("DB Error: " + e.getMessage());
                } finally {
                    conn.close();
                }
            }
        }
    }
    
    public boolean VerifyLogin(){
    
    return true;    
    }
    
}

