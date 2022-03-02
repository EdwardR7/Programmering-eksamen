/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.cryptorich;
import java.security.*;
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
         try {
    //Vha. MessageDigest kan vi anvende en hashing algoritme.... her SHA-256 ...
    //prøv f.eks. MD5 og se om du kan bryde den ved at søge på nettet!
    MessageDigest md = MessageDigest.getInstance("SHA-256"); 

    //MassageDigest objektet "fodres" med teksten, der skal "hashes"
    md.update(password.getBytes());    

    //digest funktionen giver "hash-værdien", men i hexadecimale bytes 
    byte[] byteList = md.digest();

    //Her anvendes processings hex funktion, der kan konvertere hexadecimale bytes til Strings
    //så det er muligt at læse "hash-værdien"
    StringBuffer hashedValueBuffer = new StringBuffer();
    for (byte b : byteList)hashedValueBuffer.append(Integer.toHexString(b)); 

    //Her udskrives den oprindelige tekst
    System.out.println("Den oprindelige tekst: "+ password);
    //Her udskrives "hash-værdien" af teksten
    
    System.out.println("SHA-256 værdien af teksten: " +hashedValueBuffer.toString());
    
    password = hashedValueBuffer.toString();
    return password;
  }

  catch (Exception e) {
    System.out.println("Exception: "+e);
       return "";
  }
   
    }
}




