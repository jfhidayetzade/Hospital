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
public  abstract  class HospitalModel {
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	private long id;
	private int active;
        private long r;

    public long getR() {
        return r;
    }

    public void setR(long r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "HospitalModel{" + "id=" + id + ", active=" + active + ", r=" + r + '}';
    }
    
    
    
}
