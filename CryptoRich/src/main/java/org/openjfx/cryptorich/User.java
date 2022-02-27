/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.cryptorich;

/**
 *
 * @author peter
 */
public class User {
    
    private int idUser;
    private String username;
    private String password;


  
    public User(int _idUser, String _username, String _password) {
        idUser= _idUser;
        username= _username;
        password= _password;
    }
    
    //Getter 

    public int getIdUser() {
        return idUser;
    }


    public String getUsername() {
        return username;
    }
        

    public String getPassword() {
        return password;
    }
}




