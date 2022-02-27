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
    public String verifyMessage;
    public String LoginString;

    public void RegisterUser(User u, String userConfirm) throws SQLException, Exception {
        Connection conn = null;
        Class.forName("org.sqlite.JDBC");
        String sql = "SELECT * FROM User WHERE Username = '" + userConfirm + "'";
        String sql2 = "INSERT INTO User(Username,Password) VALUES('" + u.getUsername() + "','" + u.getPassword() + "');";
        ResultSet rs = null;
        PreparedStatement ps = null;

        //Uses imported driver manager to create a connection to database//
        //The connection is put within a try catch, to ensure the program doesn't crash, if the connection fails, but instead a error message is returned//
        try {
            conn = DriverManager.getConnection(connectionString);
            System.out.println("Working db connection");
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        //Since the id of a user cannot be 0, we don't check if the id is 0, we check that when upon a user is created, is the id of the user is not equal to -1 and if it is we create a user//
        //In the registrecontroller we just set the users id to be -1 everytime, so that when it runs, it creates a new user everytime//
        if (u.getIdUser() != -1) {

        } else {
            //Checks if string further down is already created, if it is, then don't do anything and return a error message, which can be inserted into a box in the program to show the user//
            if (UserExists == "Username already exists") {
                UserExists = null;
            } else {
                try {
                    ps = conn.prepareStatement(sql);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        //Tests if the username exists and if it does, it sets the string to a message, which can be checked earlier//
                        UserExists = "Username already exists";

                    }

                } catch (SQLException e) {
                    //Returns this if the connection and resultset statements are broken in some kind of way/
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

    //Sets 2 strings for the username and passwords, then checks if these exist in the database//
    //If the user or password does not exist, it returns false, and gives an error message//
    //If the statement returns true, it sets a login string for a given user, which is meant to be hashed and changed and random//
    //The login string is made random and hashed so nobody can figure out what user is joined at what time, not even the programmers, this string is specific and randome very time//
    //Real system would require a checker if a login string is = another one, but since this is not an online project we only set 1 singular login string//
    public boolean loginVerficiation(String username, String password) throws SQLException, Exception {
        Connection conn = null;
        Class.forName("org.sqlite.JDBC");
        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;

        //Connects to database//
        try {
            conn = DriverManager.getConnection(connectionString);
            System.out.println("Working db connection");
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        try {
            //Allows us to insert a username from another class into our sql statements, which then can return a true or false value, based on whether our login statements match a user in the database//

            //In this part of code, it checks if there is a username and password MATCHING, the reason it doesn't check if username is true or password is true is for safety//
            //It is easier to check if a singular name is correct, than to check if both a username and password is matching, as in there are far more combinations and it is far harder to hack//
            //Since the values will be hashed, it will ensure an even safer system//
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                verifyMessage = "Correct user and pass";
                LoginString = "WorkingTest";
                return true;
            } else {

                verifyMessage = "Username or password is incorrect";
                LoginString = "Not working";
                return false;
            }
        } catch (SQLException e) {
            //Not written for user, for safety//

            return false;
        } finally {
            conn.close();
        }
    }

}

// INVOLVER OM NAVNET EKSISTERER ALLEREDE OG TILFØJ FEJL BESKED//
/*
        try{
            u.getIdUser() =
             
        }
        
                 
        }
 */
