/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Model;

import java.util.Date;

/**
 *
 * @author User
 */
public class Login extends HospitalModel{
    private String username;
    private String password;
   // private String role;
    private String name;
    private String surname;
    private Date Login_date;
    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getLogin_date() {
        return Login_date;
    }

    public void setLogin_date(Date Login_date) {
        this.Login_date = Login_date;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Login{" + "username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname + ", Login_date=" + Login_date + ", role=" + role + '}';
    }

   
  
    

    
    
}
