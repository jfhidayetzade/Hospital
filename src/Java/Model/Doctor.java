/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Model;

import java.util.Arrays;

/**
 *
 * @author User
 */
public class Doctor extends HospitalModel {

    private String name;
    private String surname;
    private String gender;
    private String task;
    private String departament;
    
    private byte [] picture;

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
    

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return "Doctor{" + "name=" + name + ", surname=" + surname + ", gender=" + gender + ", task=" + task + ", departament=" + departament + ", picture=" + picture + '}';
    }

    

    
    
    

}
