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
public class A extends HospitalModel{
     private int R_NO;

    public int getR_NO() {
        return R_NO;
    }

    public void setR_NO(int R_NO) {
        this.R_NO = R_NO;
    }

    @Override
    public String toString() {
        return "A{" + "R_NO=" + R_NO + '}';
    }

    
}
