/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Dao;

import Java.Jdbc.Utilty;
import Java.Model.A;
import Java.Model.B;
import Java.Model.Building;
import Java.Model.Doctor;
import Java.Model.Patient;
import Java.Model.Payment;
import Java.Model.Schedule;
import Java.Model.Soreness;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class HospitalImple implements HospitalDao {

    @Override
    public List<Patient> getpatientlist() throws Exception {
        List<Patient> patientlist = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r, P.ID, P.NAME, P.SURNAME, P.GENDER, P.DOB, P.EMAIL_ADRESS, ADDRESS FROM PATIENT P\n"
                + "WHERE P.ACTIVE=1";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Patient pt = new Patient();
                    pt.setR(rs.getLong("r"));
                    pt.setId(rs.getLong("ID"));
                    pt.setName(rs.getString("NAME"));
                    pt.setSurname(rs.getString("SURNAME"));
                    pt.setGender(rs.getString("GENDER"));
                    pt.setDob(rs.getDate("DOB"));
                    pt.setAdress(rs.getString("EMAIL_ADRESS"));
                    pt.setEadress(rs.getString("ADDRESS"));
//                    Building building = new Building();
//                    building.setId(rs.getLong("B_ID"));
//                    building.setBuilding_Type(rs.getString("BUILDING_TYPE"));
//                    building.setRooms_No(rs.getInt("ROOM_NO"));
//                    building.setRooms_Type(rs.getString("ROOM_TYPE"));
//                    building.setPrice(rs.getInt("PRICE"));
//                    pt.setBuilding(building);
                    patientlist.add(pt);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }

        return patientlist;
    }

    @Override
    public List<Doctor> getdoctorlist() throws Exception {
        List<Doctor> doctorlist = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r, ID, NAME, SURNAME, GENDER, TASK, DEPARTAMENT FROM DOCTOR\n"
                + "WHERE ACTIVE=1";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Doctor dr = new Doctor();
                    dr.setR(rs.getLong("r"));
                    dr.setId(rs.getLong("ID"));
                    dr.setName(rs.getString("NAME"));
                    dr.setSurname(rs.getString("SURNAME"));
                    dr.setGender(rs.getString("GENDER"));
                    dr.setTask(rs.getString("TASK"));
                    dr.setDepartament(rs.getString("DEPARTAMENT"));
                    doctorlist.add(dr);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }

        return doctorlist;

    }

    @Override
    public boolean addpatient(Patient patient) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO PATIENT (ID, NAME, SURNAME, GENDER, DOB, EMAIL_ADRESS, ADDRESS)\n"
                + "VALUES (PATIENT_SEQ.NEXTVAL, ?,?,?,?,?,?)";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, patient.getName());
                ps.setString(2, patient.getSurname());
                ps.setString(3, patient.getGender());
                ps.setDate(4, new java.sql.Date(patient.getDob().getTime()));
                ps.setString(5, patient.getAdress());
                ps.setString(6, patient.getEadress());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            c.commit();
            Utilty.close(c, ps, null);
        }

        return result;
    }

    @Override
    public Patient getPatientId(long patientid) throws Exception {
        Patient pt = new Patient();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r, P.ID, P.NAME, P.SURNAME, P.GENDER, P.DOB, P.EMAIL_ADRESS, ADDRESS FROM PATIENT P\r\n"
                + "WHERE P.ACTIVE=1 AND P.ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, patientid);
                rs = ps.executeQuery();
                if (rs.next()) {
                    pt.setR(rs.getLong("R"));
                    pt.setId(rs.getShort("ID"));
                    pt.setName(rs.getString("NAME"));
                    pt.setSurname(rs.getString("SURNAME"));
                    pt.setGender(rs.getString("GENDER"));
                    pt.setDob(rs.getDate("DOB"));
                    pt.setAdress(rs.getString("EMAIL_ADRESS"));
                    pt.setEadress(rs.getString("ADDRESS"));

                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }

        return pt;
    }

    @Override
    public boolean updatepatient(Patient patient, long patientid) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PATIENT SET NAME=?, SURNAME=?, GENDER=?, DOB=?, EMAIL_ADRESS=?, ADDRESS=?\n"
                + "WHERE ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, patient.getName());
                ps.setString(2, patient.getSurname());
                ps.setString(3, patient.getGender());
                ps.setDate(4, new java.sql.Date(patient.getDob().getTime()));
                ps.setString(5, patient.getAdress());
                ps.setString(6, patient.getEadress());
                ps.setLong(7, patientid);
                ps.executeUpdate();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, null);
        }

        return result;
    }

    @Override
    public boolean deletepatient(long DpatientId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PATIENT SET ACTIVE=0"
                + "WHERE ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, DpatientId);
                ps.executeUpdate();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, null);
        }
        return result;

    }

    @Override
    public boolean adddoctor(Doctor doctor) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO DOCTOR (ID, NAME, SURNAME, GENDER, TASK, DEPARTAMENT)\n"
                + "VALUES (DOCTOR_SEQ.NEXTVAL, ?,?,?,?,?)";

        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, doctor.getName());
                ps.setString(2, doctor.getSurname());
                ps.setString(3, doctor.getGender());
                ps.setString(4, doctor.getTask());
                ps.setString(5, doctor.getDepartament());
                ps.execute();
                result = true;

            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            c.commit();
            Utilty.close(c, ps, null);
        }

        return result;

    }

    @Override
    public Doctor getDoctorId(long doctorId) throws Exception {
        Doctor dr = new Doctor();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID, NAME, SURNAME, GENDER, TASK, DEPARTAMENT FROM DOCTOR\n"
                + "WHERE ACTIVE=1 AND ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, doctorId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    dr.setId(rs.getLong("ID"));
                    dr.setName(rs.getString("NAME"));
                    dr.setSurname(rs.getString("SURNAME"));
                    dr.setGender(rs.getString("GENDER"));
                    dr.setTask(rs.getString("TASK"));
                    dr.setDepartament(rs.getString("DEPARTAMENT"));
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return dr;
    }

    @Override
    public boolean updatedoctor(Doctor doctor, long doctorId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE DOCTOR SET NAME=?, SURNAME=?,GENDER=?, TASK=?, DEPARTAMENT=?\n"
                + "WHERE ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, doctor.getName());
                ps.setString(2, doctor.getSurname());
                ps.setString(3, doctor.getGender());
                ps.setString(4, doctor.getTask());
                ps.setString(5, doctor.getDepartament());
                ps.setLong(6, doctorId);
                ps.executeUpdate();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean deletedoctor(long DeletedoctorId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE DOCTOR SET ACTIVE=0\n"
                + "WHERE ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, DeletedoctorId);
                ps.executeUpdate();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, null);
        }

        return result;
    }

    @Override
    public List<Soreness> getsorenesslist() throws Exception {
        List<Soreness> sorenesslist = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r, S.ID, S.DIAGONIS, S.MEDICINES FROM SORENESS S\n"
                + "WHERE S.ACTIVE=1";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Soreness sor = new Soreness();
                    sor.setR(rs.getLong("r"));
                    sor.setId(rs.getLong("ID"));
                    sor.setDiagonis(rs.getString("DIAGONIS"));
                    sor.setMedicines(rs.getString("MEDICINES"));
                    sorenesslist.add(sor);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return sorenesslist;
    }

    @Override
    public List<Building> getbuildinglist() throws Exception {
        List<Building> buildings = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID, BUILDING_TYPE, ROOM_NO, ROOM_TYPE, PRICE FROM BUILDING\n"
                + "WHERE ACTIVE=1";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Building building = new Building();
                    building.setId(rs.getLong("ID"));
                    building.setBuilding_Type(rs.getString("BUILDING_TYPE"));
                    building.setRooms_No(rs.getInt("ROOM_NO"));
                    building.setRooms_Type(rs.getString("ROOM_TYPE"));
                    building.setPrice(rs.getInt("PRICE"));
                    buildings.add(building);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return buildings;
    }

    @Override
    public boolean addPBuilding(Patient patient) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO PATIENT (ID, NAME, SURNAME, GENDER, DOB, EMAIL_ADRESS, BUILDING_ID)\n"
                + "VALUES(PATIENT_SEQ.NEXTVAL, ?,?,?,?,?,?)";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, patient.getName());
                ps.setString(2, patient.getSurname());
                ps.setString(3, patient.getGender());
                ps.setDate(4, new java.sql.Date(patient.getDob().getTime()));
                ps.setString(5, patient.getAdress());
                ps.setLong(6, patient.getBuilding().getId());
                ps.execute();
                result = true;

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public List<Schedule> getschedulelist() throws Exception {
        List<Schedule> schedules = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, SC.ID, P.ID P_ID, P.NAME, P.SURNAME, D.ID D_ID, D.NAME D_NAME, D.SURNAME D_SURNAME, S.ID S_ID, S.DIAGONIS, S.MEDICINES FROM SCHEDULE SC\n"
                + "INNER JOIN PATIENT P ON SC.P_ID=P.ID\n"
                + "INNER JOIN SORENESS S ON SC.S_ID=S.ID\n"
                + "INNER JOIN DOCTOR D ON SC.D_ID=D.ID\n"
                + "WHERE SC.ACTIVE=1 AND P.ACTIVE=1";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Schedule schedule = new Schedule();
                    schedule.setR(rs.getLong("R"));
                    schedule.setId(rs.getLong("ID"));
                    Patient patient = new Patient();
                    patient.setId(rs.getLong("P_ID"));
                    patient.setName(rs.getString("NAME"));
                    patient.setSurname(rs.getString("SURNAME"));
                    Soreness soreness = new Soreness();
                    soreness.setId(rs.getLong("S_ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    Doctor doctor = new Doctor();
                    doctor.setId(rs.getLong("D_ID"));
                    doctor.setName(rs.getString("D_NAME"));
                    doctor.setSurname(rs.getString("D_SURNAME"));
                    schedule.setPatient(patient);
                    schedule.setSoreness(soreness);
                    schedule.setDoctor(doctor);
                    schedules.add(schedule);

                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return schedules;
    }

    @Override
    public boolean addSchedule(Schedule schedule) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO SCHEDULE (ID, P_ID, S_ID, D_ID)\n"
                + "VALUES(SCHEDULE_SEQ.NEXTVAL, ?,?,?)";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, schedule.getPatient().getId());
                ps.setLong(2, schedule.getSoreness().getId());
                ps.setLong(3, schedule.getDoctor().getId());
                ps.execute();
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, null);
        }
        return result;
    }

    @Override
    public Schedule getScheduleId(long scheduleId) throws Exception {
        Schedule schedule = new Schedule();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT SC.ID, P.ID P_ID, P.NAME, P.SURNAME, D.ID D_ID, D.NAME D_NAME, D.SURNAME D_SURNAME, S.ID S_ID, S.DIAGONIS, S.MEDICINES FROM SCHEDULE SC\n"
                + "INNER JOIN PATIENT P ON SC.P_ID=P.ID\n"
                + "INNER JOIN SORENESS S ON SC.S_ID=S.ID\n"
                + "INNER JOIN DOCTOR D ON SC.D_ID=D.ID\n"
                + "WHERE SC.ACTIVE=1 AND P.ACTIVE=1 AND SC.ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, scheduleId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    schedule.setId(rs.getLong("ID"));
                    Patient patient = new Patient();
                    patient.setId(rs.getLong("P_ID"));
                    patient.setName(rs.getString("NAME"));
                    patient.setSurname(rs.getString("SURNAME"));
                    Soreness soreness = new Soreness();
                    soreness.setId(rs.getLong("S_ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    Doctor doctor = new Doctor();
                    doctor.setId(rs.getLong("D_ID"));
                    doctor.setName(rs.getString("D_NAME"));
                    doctor.setSurname(rs.getString("D_SURNAME"));
                    schedule.setPatient(patient);
                    schedule.setSoreness(soreness);
                    schedule.setDoctor(doctor);

                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return schedule;
    }

    @Override
    public boolean updateSchedule(Schedule schedule, long scheduleId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE SCHEDULE SET P_ID=?, S_ID=?, D_ID=?\n"
                + "WHERE ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, schedule.getPatient().getId());
                ps.setLong(2, schedule.getSoreness().getId());
                ps.setLong(3, schedule.getDoctor().getId());
                ps.setLong(4, scheduleId);
                ps.execute();
                result = true;

            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            Utilty.close(c, ps, null);
        }

        return result;
    }

    @Override
    public List<Building> comboBuildings() throws Exception {
        List<Building> buildings = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT BUILDING_TYPE FROM BUILDING\n"
                + "WHERE active=1";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Building building = new Building();
                    building.setBuilding_Type(rs.getString("BUILDING_TYPE"));
                    buildings.add(building);
                }
            } else {
                System.out.println("Conncetion is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return buildings;
    }

    @Override
    public List<Patient> searchPatientDataa(String keyword) throws Exception {
        List<Patient> patients = new ArrayList<Patient>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, ID, NAME, SURNAME, GENDER, DOB, EMAIL_ADRESS FROM PATIENT \n"
                + "WHERE ACTIVE=1 AND (LOWER (NAME) LIKE LOWER ('%" + keyword + "%') OR LOWER (SURNAME) LIKE LOWER ('%" + keyword + "%') OR"
                + " LOWER (GENDER) LIKE LOWER ('%" + keyword + "%') OR LOWER (EMAIL_ADRESS) LIKE LOWER ('%" + keyword + "%'))";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Patient patient = new Patient();
                    patient.setR(rs.getLong("R"));
                    patient.setId(rs.getLong("ID"));;
                    patient.setName(rs.getString("NAME"));
                    patient.setSurname(rs.getString("SURNAME"));
                    patient.setGender(rs.getString("GENDER"));
                    patient.setDob(rs.getDate("DOB"));
                    patient.setAdress(rs.getString("EMAIL_ADRESS"));
                    patients.add(patient);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return patients;
    }

    @Override
    public List<Soreness> searchsorenessData(String keyword) throws Exception {
        List<Soreness> sorenesses = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, ID, DIAGONIS, MEDICINES FROM SORENESS\n"
                + "WHERE ACTIVE=1 AND (LOWER (DIAGONIS) LIKE LOWER ('%" + keyword + "%') OR "
                + " LOWER (MEDICINES) LIKE LOWER ('%" + keyword + "%'))";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Soreness soreness = new Soreness();
                    soreness.setR(rs.getLong("R"));
                    soreness.setId(rs.getLong("ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    sorenesses.add(soreness);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return sorenesses;
    }

    @Override
    public List<Doctor> searchDoctorData(String keyword) throws Exception {
        List<Doctor> doctors = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, ID, NAME, SURNAME, TASK, DEPARTAMENT FROM DOCTOR\n"
                + "WHERE ACTIVE=1 AND (LOWER (NAME) LIKE LOWER ('%" + keyword + "%') OR "
                + " LOWER (SURNAME) LIKE LOWER ('%" + keyword + "%') OR LOWER (TASK) LIKE LOWER ('%" + keyword + "%') )";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setR(rs.getLong("R"));
                    doctor.setId(rs.getLong("ID"));
                    doctor.setName(rs.getString("NAME"));
                    doctor.setSurname(rs.getString("SURNAME"));
                    doctor.setTask(rs.getString("TASK"));
                    doctor.setDepartament(rs.getString("DEPARTAMENT"));
                    doctors.add(doctor);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return doctors;
    }

    @Override
    public List<Schedule> searchScheduleData(String keyword) throws Exception {
        List<Schedule> schedules = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, SC.ID, P.ID P_ID, P.NAME,  P.SURNAME, S.ID S_ID, S.DIAGONIS, S.MEDICINES, D.ID D_ID, D.NAME D_NAME, D.SURNAME D_SUNRMAE FROM SCHEDULE SC\n"
                + "INNER JOIN PATIENT P ON SC.P_ID=P.ID\n"
                + "INNER JOIN SORENESS S ON SC.S_ID=S.ID\n"
                + "INNER JOIN DOCTOR D ON SC.D_ID=D.ID\n"
                + "WHERE SC.ACTIVE=1 AND P.ACTIVE=1 AND (LOWER (P.NAME) LIKE LOWER ('%" + keyword + "%') OR LOWER (P.SURNAME) LIKE LOWER ('" + keyword + "') OR LOWER (S.DIAGONIS) LIKE LOWER ('%" + keyword + "%') OR "
                + "LOWER (S.MEDICINES) LIKE LOWER ('" + keyword + "') OR"
                + " LOWER (D.NAME) LIKE LOWER ('%" + keyword + "%') OR LOWER (D.SURNAME) LIKE LOWER ('" + keyword + "'))";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Schedule schedule = new Schedule();
                    schedule.setR(rs.getLong("R"));
                    schedule.setId(rs.getLong("ID"));
                    Patient patient = new Patient();
                    patient.setName(rs.getString("NAME"));
                    patient.setSurname(rs.getString("SURNAME"));
                    Doctor doctor = new Doctor();
                    doctor.setName(rs.getString("D_NAME"));
                    doctor.setSurname(rs.getString("D_SUNRMAE"));
                    Soreness soreness = new Soreness();
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    schedule.setPatient(patient);
                    schedule.setDoctor(doctor);
                    schedule.setSoreness(soreness);
                    schedules.add(schedule);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return schedules;
    }

    @Override
    public boolean addsoreness(Soreness soreness) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO SORENESS(ID, DIAGONIS, MEDICINES)\n"
                + "VALUES (SORENESS_SEQ.NEXTVAL, ?,?)";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, soreness.getDiagonis());
                ps.setString(2, soreness.getMedicines());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, null);
        }
        return result;
    }

    @Override
    public Soreness getSorenessbyId(long SorenessId) throws Exception {
        Soreness soreness = new Soreness();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r, S.ID, S.DIAGONIS, S.MEDICINES FROM SORENESS S\r\n"
                + "WHERE S.ACTIVE=1 AND S.ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, SorenessId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    soreness.setR(rs.getLong("R"));
                    soreness.setId(rs.getShort("ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    soreness.setMedicines(rs.getString("MEDICINES"));

                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }

        return soreness;
    }

    @Override
    public boolean updateSoreness(Soreness soreness, long SorenessId) {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE SORENESS SET DIAGONIS=?, MEDICINES=?\n"
                + "WHERE ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, soreness.getDiagonis());
                ps.setString(2, soreness.getMedicines());
                ps.setLong(3, SorenessId);
                ps.executeUpdate();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Utilty.close(c, ps, null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public List<Payment> getpaymentlist() throws Exception {
        List<Payment> payments = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, PY.ID, P.ID P_ID, P.NAME, P.SURNAME, D.ID D_ID, D.NAME D_NAME, D.SURNAME D_SURNAME, S.ID S_ID, S.DIAGONIS, PAYMENT_DATE , S.MEDICINES, AMOUNT FROM PAYMENTT PY\n"
                + "INNER JOIN PATIENT P ON PY.P_ID=P.ID\n"
                + "INNER JOIN DOCTOR D ON PY.D_ID=D.ID\n"
                + "INNER JOIN SORENESS S ON PY.S_ID=S.ID\n"
                + "WHERE PY.ACTIVE=1 AND P.ACTIVE=1 ";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setR(rs.getLong("R"));
                    payment.setId(rs.getLong("ID"));
                    Patient patient = new Patient();
                    patient.setId(rs.getLong("P_ID"));
                    patient.setName(rs.getString("NAME"));
                    patient.setSurname(rs.getString("SURNAME"));
                    Doctor doctor = new Doctor();
                    doctor.setId(rs.getLong("D_ID"));
                    doctor.setName(rs.getString("D_NAME"));
                    doctor.setSurname(rs.getString("D_SURNAME"));
                    Soreness soreness = new Soreness();
                    soreness.setId(rs.getLong("S_ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    payment.setDate(rs.getDate("PAYMENT_DATE"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    payment.setAmount(rs.getLong("AMOUNT"));
                    payment.setPatient(patient);
                    payment.setDoctor(doctor);
                    payment.setSoreness(soreness);
                    payments.add(payment);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return payments;
    }

    @Override
    public boolean addPayment(Payment payment) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO PAYMENTT (ID, P_ID, S_ID, D_ID,AMOUNT, PAYMENT_DATE )\n"
                + "VALUES(PAYMENTT_SEQ.NEXTVAL, ?,?,?, ?, ?)";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, payment.getPatient().getId());
                ps.setLong(2, payment.getSoreness().getId());
                ps.setLong(3, payment.getDoctor().getId());
                ps.setLong(4, payment.getAmount());
                ps.setDate(5, new java.sql.Date(payment.getDate().getTime()));
                ps.execute();
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean deletesoreness(long deleteSorenessId) {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE SORENESS SET ACTIVE=0"
                + "WHERE ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, deleteSorenessId);
                ps.executeUpdate();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Utilty.close(c, ps, null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;

    }

    @Override
    public Payment getpaymentById(long paymentId) throws Exception {
        Payment payment = new Payment();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT PY.ID, P.ID P_ID, P.NAME, P.SURNAME, D.ID D_ID, D.NAME D_NAME, D.SURNAME D_SURNAME, S.ID S_ID, S.DIAGONIS, PAYMENT_DATE, S.MEDICINES, AMOUNT FROM PAYMENTT PY\n"
                + "INNER JOIN PATIENT P ON PY.P_ID=P.ID\n"
                + "INNER JOIN SORENESS S ON PY.S_ID=S.ID\n"
                + "INNER JOIN DOCTOR D ON PY.D_ID=D.ID\n"
                + "WHERE PY.ACTIVE=1 AND P.ACTIVE=1 AND PY.ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, paymentId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    payment.setId(rs.getLong("ID"));
                    Patient patient = new Patient();
                    patient.setId(rs.getLong("P_ID"));
                    patient.setName(rs.getString("NAME"));
                    patient.setSurname(rs.getString("SURNAME"));
                    Doctor doctor = new Doctor();
                    doctor.setId(rs.getLong("D_ID"));
                    doctor.setName(rs.getString("D_NAME"));
                    doctor.setSurname(rs.getString("D_SURNAME"));
                    Soreness soreness = new Soreness();
                    soreness.setId(rs.getLong("S_ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    payment.setDate(rs.getDate("PAYMENT_DATE"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    payment.setAmount(rs.getLong("AMOUNT"));
                    payment.setPatient(patient);
                    payment.setSoreness(soreness);
                    payment.setDoctor(doctor);

                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return payment;
    }

    @Override
    public boolean updatepayment(Payment payment, long paymentId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PAYMENTT SET P_ID=?, D_ID=?, S_ID=?, AMOUNT=?, PAYMENT_DATE=? \n"
                + "WHERE ID=?";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, payment.getPatient().getId());
                ps.setLong(2, payment.getSoreness().getId());
                ps.setLong(3, payment.getDoctor().getId());
                ps.setLong(4, payment.getAmount());
                ps.setDate(5, new java.sql.Date(payment.getDate().getTime()));
                ps.setLong(6, paymentId);
                ps.executeUpdate();
                result = true;

            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            Utilty.close(c, ps, null);
        }

        return result;
    }

    @Override
    public List<Payment> searchPaymentData(String keyword) throws Exception {
        List<Payment> payments = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R, PY.ID, P.ID P_ID, P.NAME, P.SURNAME, D.ID D_ID, D.NAME D_NAME, D.SURNAME D_SURNAME, S.ID S_ID, S.DIAGONIS, PAYMENT_DATE, S.MEDICINES, AMOUNT FROM PAYMENTT PY\n"
                + "INNER JOIN PATIENT P ON PY.P_ID=P.ID\n"
                + "INNER JOIN SORENESS S ON PY.S_ID=S.ID\n"
                + "INNER JOIN DOCTOR D ON PY.D_ID=D.ID\n"
                + "WHERE PY.ACTIVE=1 AND P.ACTIVE=1 AND (LOWER (P.NAME) LIKE LOWER ('%"+keyword+"%') OR LOWER (P.SURNAME) LIKE LOWER ('"+keyword+"') OR "
                + "LOWER (D.NAME) LIKE LOWER ('%"+keyword+"%') OR LOWER (D.SURNAME) LIKE LOWER ('"+keyword+"') OR LOWER (AMOUNT) LIKE LOWER ('%"+keyword+"%'))";
        try {
            c = DBhelper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setR(rs.getLong("R"));
                    payment.setId(rs.getLong("ID"));
                    Patient patient = new Patient();
                    patient.setId(rs.getLong("P_ID"));
                    patient.setName(rs.getString("NAME"));
                    patient.setSurname(rs.getString("SURNAME"));
                    Doctor doctor = new Doctor();
                    doctor.setId(rs.getLong("D_ID"));
                    doctor.setName(rs.getString("D_NAME"));
                    doctor.setSurname(rs.getString("D_SURNAME"));
                    Soreness soreness = new Soreness();
                    soreness.setId(rs.getLong("S_ID"));
                    soreness.setDiagonis(rs.getString("DIAGONIS"));
                    payment.setDate(rs.getDate("PAYMENT_DATE"));
                    soreness.setMedicines(rs.getString("MEDICINES"));
                    payment.setAmount(rs.getLong("AMOUNT"));
                    payment.setPatient(patient);
                    payment.setDoctor(doctor);
                    payment.setSoreness(soreness);
                    payments.add(payment);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Utilty.close(c, ps, rs);
        }
        return payments;
    }
    
    

}
