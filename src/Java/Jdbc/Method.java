/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Jdbc;

import Java.Model.Building;
import Java.Model.Doctor;
import Java.Model.Patient;
import java.util.List;

/**
 *
 * @author User
 */
public class Method {

    public static void getPatientlist(List<Patient> patients) {
        for (Patient pt : patients) {
            System.out.println(pt.getId() + " " + pt.getName() + " " + pt.getSurname() /*+ " " + pt.getGender() + " " + pt.getDob() + " " + pt.getAdress()+ " " +pt.getBuilding().getRooms_No()*/);
        }
    }

    public static void getDoctorlist(List<Doctor> doctors) {
        for (Doctor dr : doctors) {
            System.out.println(dr.getId() + " " + dr.getName() + " " + dr.getSurname() + " " + dr.getTask() + " " + dr.getDepartament());
        }
    }
    
    public static void getBuldinigList(List<Building> buildings){
        for(Building building: buildings){
            System.out.println(building.getId()+ " " +building.getBuilding_Type()+ " " +building.getRooms_No()+ " " +building.getRooms_Type()+ " " +building.getPrice());
        }
            
    }

}
