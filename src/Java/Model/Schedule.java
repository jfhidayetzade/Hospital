/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Model;

/**
 *
 * @author User
 */
public class Schedule extends HospitalModel{
    private Patient patient;
    private Doctor doctor;
    private Patient_Adress p_adress;
    private Doctor_Adress d_adress;
    private Rooms rooms;
    private Soreness soreness;
    private Working_time w_time;
    private Building building;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient_Adress getP_adress() {
        return p_adress;
    }

    public void setP_adress(Patient_Adress p_adress) {
        this.p_adress = p_adress;
    }

    public Doctor_Adress getD_adress() {
        return d_adress;
    }

    public void setD_adress(Doctor_Adress d_adress) {
        this.d_adress = d_adress;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Soreness getSoreness() {
        return soreness;
    }

    public void setSoreness(Soreness soreness) {
        this.soreness = soreness;
    }

    public Working_time getW_time() {
        return w_time;
    }

    public void setW_time(Working_time w_time) {
        this.w_time = w_time;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Schedule{" + "patient=" + patient + ", doctor=" + doctor + ", p_adress=" + p_adress + ", d_adress=" + d_adress + ", rooms=" + rooms + ", soreness=" + soreness + ", w_time=" + w_time + ", building=" + building + '}';
    }

    

    

   
    
    
    
}
