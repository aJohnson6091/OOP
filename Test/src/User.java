/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author austin
 */
public class User {
    public String name;
    public String password;
    public String realName;

    User(String name, String password, String realName) {
        this.name = name;
        this.password = password;
        this.realName = realName;    
    }
   
    
    
    public String[] varToArray(){
        String[] s = {this.name,this.password,this.realName};
        return s;
    }
}
