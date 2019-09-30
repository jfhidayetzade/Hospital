/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Service;

import Java.Model.A;
import Java.Model.B;
import Java.Model.Building;
import Java.Model.Doctor;
import Java.Model.Login;
import Java.Model.Patient;
import Java.Model.Payment;
import Java.Model.Schedule;
import Java.Model.Soreness;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public interface HospitalService {

    List<Patient> getpatientlist() throws Exception;

    List<Doctor> getdoctorlist() throws Exception;

    List<Soreness> getsorenesslist() throws Exception;

    List<Schedule> getschedulelist() throws Exception;

    boolean addpatient(Patient patient) throws Exception;

    boolean adddoctor(Doctor doctor) throws Exception;

    boolean addPBuilding(Patient patient) throws Exception;

    boolean addSchedule(Schedule schedule) throws Exception;

    Patient getPatientId(long patientid) throws Exception;

    boolean updatepatient(Patient patient, long patientid) throws Exception;

    boolean deletepatient(long DpatientId) throws Exception;

    Doctor getDoctorId(long doctorId) throws Exception;

    boolean updatedoctor(Doctor doctor, long doctorId) throws Exception;

    boolean deletedoctor(long DeletedoctorId) throws Exception;

    List<Building> getbuildinglist() throws Exception;

    Schedule getScheduleId(long scheduleId) throws Exception;

    boolean updateSchedule(Schedule schedule, long scheduleId) throws Exception;

    List<Building> comboBuildings() throws Exception;

    List<Patient> searchPatientDataa(String keyword) throws Exception;

    List<Soreness> searchsorenessData(String keyword) throws Exception;

    List<Doctor> searchDoctorData(String keyword) throws Exception;

    List<Schedule> searchScheduleData(String keyword) throws Exception;

    boolean addsoreness(Soreness soreness) throws Exception;

    Soreness getSorenessbyId(long SorenessId) throws Exception;

    boolean updateSoreness(Soreness soreness, long SorenessId);

    List<Payment> getpaymentlist() throws Exception;

    boolean addPayment(Payment payment) throws Exception;

    boolean deletesoreness(long deleteSorenessId) throws Exception;

    Payment getpaymentById(long paymentId) throws Exception;

    boolean updatepayment(Payment payment, long paymentId) throws Exception;

    List<Payment> searchPaymentData(String keyword) throws Exception;

    
}
