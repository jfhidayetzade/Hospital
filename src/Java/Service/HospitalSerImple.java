/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Service;

import Java.Dao.HospitalDao;
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

/**
 *
 * @author User
 */
public class HospitalSerImple implements HospitalService {

    private HospitalDao hospitalDao;

    public HospitalSerImple(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public List<Patient> getpatientlist() throws Exception {
        return hospitalDao.getpatientlist();
    }

    @Override
    public List<Doctor> getdoctorlist() throws Exception {
        return hospitalDao.getdoctorlist();
    }

    @Override
    public boolean addpatient(Patient patient) throws Exception {
        return hospitalDao.addpatient(patient);
    }

    @Override
    public Patient getPatientId(long patientid) throws Exception {

        return hospitalDao.getPatientId(patientid);
    }

    @Override
    public boolean updatepatient(Patient patient, long patientid) throws Exception {

        return hospitalDao.updatepatient(patient, patientid);

    }

    @Override
    public boolean deletepatient(long DpatientId) throws Exception {

        return hospitalDao.deletepatient(DpatientId);

    }

    @Override
    public boolean adddoctor(Doctor doctor) throws Exception {

        return hospitalDao.adddoctor(doctor);
    }

    @Override
    public Doctor getDoctorId(long doctorId) throws Exception {

        return hospitalDao.getDoctorId(doctorId);
    }

    @Override
    public boolean updatedoctor(Doctor doctor, long doctorId) throws Exception {
        return hospitalDao.updatedoctor(doctor, doctorId);
    }

    @Override
    public boolean deletedoctor(long DeletedoctorId) throws Exception {

        return hospitalDao.deletedoctor(DeletedoctorId);

    }

    @Override
    public List<Soreness> getsorenesslist() throws Exception {
        return hospitalDao.getsorenesslist();
    }

    @Override
    public List<Building> getbuildinglist() throws Exception {
        return hospitalDao.getbuildinglist();
    }

    @Override
    public boolean addPBuilding(Patient patient) throws Exception {
        return hospitalDao.addPBuilding(patient);
    }

    @Override
    public List<Schedule> getschedulelist() throws Exception {
        return hospitalDao.getschedulelist();
    }

    @Override
    public boolean addSchedule(Schedule schedule) throws Exception {
        return hospitalDao.addSchedule(schedule);
    }

    @Override
    public Schedule getScheduleId(long scheduleId) throws Exception {
        return hospitalDao.getScheduleId(scheduleId);
    }

    @Override
    public boolean updateSchedule(Schedule schedule, long scheduleId) throws Exception {
        return hospitalDao.updateSchedule(schedule, scheduleId);
    }

    @Override
    public List<Building> comboBuildings() throws Exception {
        return hospitalDao.comboBuildings();
    }

    @Override
    public List<Patient> searchPatientDataa(String keyword) throws Exception {
        return hospitalDao.searchPatientDataa(keyword);
    }

    @Override
    public List<Soreness> searchsorenessData(String keyword) throws Exception {
        return hospitalDao.searchsorenessData(keyword);
    }

    @Override
    public List<Doctor> searchDoctorData(String keyword) throws Exception {
        return hospitalDao.searchDoctorData(keyword);
    }

    @Override
    public List<Schedule> searchScheduleData(String keyword) throws Exception {
        return hospitalDao.searchScheduleData(keyword);
    }

    @Override
    public boolean addsoreness(Soreness soreness) throws Exception {
        return hospitalDao.addsoreness(soreness);
    }

    @Override
    public Soreness getSorenessbyId(long SorenessId) throws Exception {
        return hospitalDao.getSorenessbyId(SorenessId);
    }

    @Override
    public boolean updateSoreness(Soreness soreness, long SorenessId) {
        return hospitalDao.updateSoreness(soreness, SorenessId);
    }

    @Override
    public List<Payment> getpaymentlist() throws Exception {
        return hospitalDao.getpaymentlist();
    }

    @Override
    public boolean addPayment(Payment payment) throws Exception {
        return hospitalDao.addPayment(payment);
    }

    @Override
    public boolean deletesoreness(long deleteSorenessId) {
        return hospitalDao.deletesoreness(deleteSorenessId);
    }

    @Override
    public Payment getpaymentById(long paymentId) throws Exception {
        return hospitalDao.getpaymentById(paymentId);
    }

    @Override
    public boolean updatepayment(Payment payment, long paymentId) throws Exception {
        return hospitalDao.updatepayment(payment, paymentId);
    }

    @Override
    public List<Payment> searchPaymentData(String keyword) throws Exception {
        return hospitalDao.searchPaymentData(keyword);
    }

   

}
