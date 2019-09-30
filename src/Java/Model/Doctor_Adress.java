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
public class Doctor_Adress extends HospitalModel{
    private String country;
    private String city;
    private String settlement;
    private Date dob;
    private int M_number;
    
    

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    private String m_number;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

   

    public String getM_number() {
        return m_number;
    }

    public void setM_number(String m_number) {
        this.m_number = m_number;
    }

    @Override
    public String toString() {
        return "Doctor_Adress{" + "country=" + country + ", city=" + city + ", settlement=" + settlement + ", dob=" + dob + ", m_number=" + m_number + '}';
    }
    
}
