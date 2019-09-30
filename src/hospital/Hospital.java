/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import Java.Dao.HospitalDao;
import Java.Dao.HospitalImple;
import Java.Gui.LoginFrame;
import Java.Gui.MainFrame;
import Java.Jdbc.Method;
import Java.Model.Doctor;
import Java.Model.Patient;
import Java.Service.HospitalSerImple;
import Java.Service.HospitalService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
//            Scanner scan=new Scanner(System.in);
//            List<Patient> patients=hospitalService.getpatientlist();
//            Method.getPatientlist(patients);
//            System.out.println("Redakte etmek istediyiniz hekimin adini daxil edin");
//            long DoNo=scan.nextLong();
//            Patient dr=hospitalService.getPatientId(DoNo);
//            System.out.println("Name:" +dr.getName());
//            System.out.println("Su:" +dr.getSurname());
//            Patient dor=new Patient();
//            System.out.println("Yeni ad");
//            dr.setName(scan.next());
//            System.out.println("Yeni su");
//            dr.setName(scan.next());
//            
//               boolean isu= hospitalService.updatepatient(dor, DoNo);
//               if(isu){
//                   System.out.println("Ugurla deyishildi");
//               }else{
//                   System.out.println("Problem ash verid");
//               }
            HospitalDao hospitaldao = new HospitalImple();
            HospitalService hospitalService = new HospitalSerImple(hospitaldao);
            LoginFrame loginFrame = new LoginFrame(hospitalService);
            loginFrame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
