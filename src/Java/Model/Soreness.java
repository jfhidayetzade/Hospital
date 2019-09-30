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
public class Soreness extends HospitalModel{
    
	private String diagonis;
	private String medicines;

    public String getDiagonis() {
        return diagonis;
    }

    public void setDiagonis(String diagonis) {
        this.diagonis = diagonis;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "Soreness{" + "diagonis=" + diagonis + ", medicines=" + medicines + '}';
    }
        
}
