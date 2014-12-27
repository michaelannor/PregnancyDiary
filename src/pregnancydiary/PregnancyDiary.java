package pregnancydiary;


import pregnancydiary.controllers.Controller;
import pregnancydiary.models.Mother;
import pregnancydiary.views.SignupForm;
import pregnancydiary.views.Home;
import pregnancydiary.views.LoginForm;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author michaelannor
 */
public class PregnancyDiary {
     /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
                 // TODO code application logic here

                Mother model = new Mother();
                Home view = new Home();
                LoginForm login = new LoginForm();
                SignupForm signup = new SignupForm();
                Controller controller = new Controller(model,view,login,signup);
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                login.setVisible(true);
                
                
                controller.loginBtnControl();
                controller.signUpControl();
                
                controller.signupBtnControl();
                
                controller.summaryMenuBtnControl();
                controller.diaryMenuBtnControl();
                controller.motherMenuBtnControl();
                controller.appointmentDetailsMenuBtnControl();
                controller.recordsMenuBtnControl();
                controller.saveBtn_DiaryControl();
                controller.saveEditBtn_MotherControl();
                controller.newAppointmentBtn_AppointmentsControl();
                controller.addBtn_AppointmentsControl();
                controller.appointmentMonthListItemControl();
                controller.appointmentTableItemControl();
                controller.exportMenuControl();
                controller.editOkayBtnControl();
                controller.deleteAppointmentBtn_AppointmentsControl();
                controller.searchAppointmentBtn_AppointmentsControl();
                        
            }
        });
            
        }  
    }

