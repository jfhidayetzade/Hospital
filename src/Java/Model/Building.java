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
public class Building extends HospitalModel{
    private String Building_Type;
    private int Rooms_No;
    private String Rooms_Type;
    private int price;

    


    public String getBuilding_Type() {
        return Building_Type;
    }

    public void setBuilding_Type(String Building_Type) {
        this.Building_Type = Building_Type;
    }

    public int getRooms_No() {
        return Rooms_No;
    }

    public void setRooms_No(int Rooms_No) {
        this.Rooms_No = Rooms_No;
    }

    public String getRooms_Type() {
        return Rooms_Type;
    }

    public void setRooms_Type(String Rooms_Type) {
        this.Rooms_Type = Rooms_Type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
