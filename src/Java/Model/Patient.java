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
public class Patient extends HospitalModel{
    private String name;
    private String surname;
    private String gender;
    private Date dob;
    private String adress;
    private String eadress;
    private Building building;
    private Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEadress() {
        return eadress;
    }

    public void setEadress(String eadress) {
        this.eadress = eadress;
    }

    @Override
    public String toString() {
        return "Patient{" + "name=" + name + ", surname=" + surname + ", gender=" + gender + ", dob=" + dob + ", adress=" + adress + ", eadress=" + eadress + ", building=" + building + ", doctor=" + doctor + '}';
    }
    
    

    

    
   
    
        
}
