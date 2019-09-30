/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Gui;

import Java.Model.Doctor;
import Java.Model.Item;
import Java.Model.Patient;
import Java.Model.Schedule;
import Java.Model.Soreness;
import Java.Service.HospitalService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class EditTreatmentFrame extends javax.swing.JFrame {

    private long selectRow;
    private HospitalService hospitalService;
    public EditTreatmentFrame() {
        initComponents();
    }

    public EditTreatmentFrame(long selectRow, HospitalService hospitalService) {
        try {
            initComponents();
            this.selectRow=selectRow;
            this.hospitalService=hospitalService;
            Schedule schedule=hospitalService.getScheduleId(selectRow);
            editpatientCombo(schedule);
            editsorenesscombo(schedule);
            editdoctorCombo(schedule);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        updateBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Patient:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Soreness:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Doctor:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Patient" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Soreness" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Doctor" }));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 140, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, 140, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(updateBtn)
                        .addGap(26, 26, 26)
                        .addComponent(cancelBtn)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(cancelBtn))
                .addGap(110, 110, 110))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
             try {
            Schedule schedule = new Schedule();
            Item patientItem = (Item) jComboBox1.getSelectedItem();
            Item sorenessItem = (Item) jComboBox2.getSelectedItem();
            Item doctorItem = (Item) jComboBox3.getSelectedItem();
            Patient patient=new Patient();
            patient.setId(patientItem.getId());
            Soreness soreness=new Soreness();
            soreness.setId(sorenessItem.getId());
            Doctor doctor=new Doctor();
            doctor.setId(doctorItem.getId());
            schedule.setPatient(patient);
            schedule.setSoreness(soreness);
            schedule.setDoctor(doctor);
            boolean isUpdated=hospitalService.updateSchedule(schedule, selectRow);
            if(isUpdated){
                JOptionPane.showMessageDialog(null, "Schedule has been successfully added!", "success", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Schedule has not been successfully added!", "error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
         this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void editpatientCombo(Schedule schedule) {
        try {
            DefaultComboBoxModel patientcombomodel = (DefaultComboBoxModel) jComboBox1.getModel();
            List<Patient> patients = hospitalService.getpatientlist();
            for (Patient patient : patients) {
                patientcombomodel.addElement(new Item(patient.getId(), patient.getName() + " " + patient.getSurname()));
            }
            patientcombomodel.setSelectedItem(new Item(schedule.getPatient().getId(), schedule.getPatient().getName()+ " " +schedule.getPatient().getSurname()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void editsorenesscombo(Schedule schedule) {
        try {
            DefaultComboBoxModel sorenesscombomodel = (DefaultComboBoxModel) jComboBox2.getModel();
            List<Soreness> sorenesses = hospitalService.getsorenesslist();
            for (Soreness soreness : sorenesses) {
                sorenesscombomodel.addElement(new Item(soreness.getId(), soreness.getDiagonis() + " " + soreness.getMedicines()));
            }
            sorenesscombomodel.setSelectedItem(new Item(schedule.getSoreness().getId(), schedule.getSoreness().getDiagonis()+ " " +schedule.getSoreness().getMedicines()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void editdoctorCombo(Schedule schedule) {
        try {
            DefaultComboBoxModel doctorcombomodel = (DefaultComboBoxModel) jComboBox3.getModel();
            List<Doctor> doctors = hospitalService.getdoctorlist();
            for (Doctor doctor : doctors) {
                doctorcombomodel.addElement(new Item(doctor.getId(), doctor.getName() + " " + doctor.getSurname()));
            }
            doctorcombomodel.setSelectedItem(new Item(schedule.getDoctor().getId(), schedule.getDoctor().getName()+ " " +schedule.getDoctor().getSurname()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}