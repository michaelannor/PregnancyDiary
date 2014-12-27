/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregnancydiary.controllers;


import pregnancydiary.models.Medical;
import pregnancydiary.models.MotherCRUD;
import pregnancydiary.models.HealthStats;
import pregnancydiary.models.AppointmentCRUD;
import pregnancydiary.models.PregnancyRecords;
import pregnancydiary.models.DiaryCRUD;
import pregnancydiary.models.Mother;
import pregnancydiary.models.Appointment;
import pregnancydiary.views.SignupForm;
import pregnancydiary.views.Home;
import pregnancydiary.views.LoginForm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author michaelannor
 */
public class Controller {
    
    	private Home homeView;
	private Mother recordsModel;
        private Appointment appointment;
        private LoginForm loginView;
        private SignupForm signupView;
        private MotherCRUD motherCRUD;
        private AppointmentCRUD appointmentCRUD;
        private DiaryCRUD diaryCRUD;
        private static final int PREGNANCY_WEEKS = 36;
        private static final int MILLISECONDS_IN_SECS = 1000;
        private static final int MINUTES_HOURS_IN_SECS = 60;
        private static final int HOURS_IN_DAY =24;
        private static final int DAYS_IN_WEEK = 7;
        private TableRowSorter<TableModel> rowSorter;
        
        public static java.sql.Connection conn = null;

        
        public static TreeMap pregnancyRecordsMap = new TreeMap();
        
        /**
         * Method to initialize the database controller
         */
        public void initializeDatabase(){ 
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/pregnancydiary?user=root&password=");
        }
        catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        } 
        System.out.println("Connection established");
        }
        
        /**
         * Method to hash the passwords
         * @param md5 String password
         * @return Hashed password
         */
        public String MD5(String md5) {
   try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
       }
        return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
}

        /**
         * Accessor method to get the home object
         * @return Home View Object
         */
        public Home getHome(){
            return homeView;
        }
        /**
         * Accessor method to get the mother object
         * @return Mother Object
         */
        public Mother getMother(){
            return recordsModel;
        }

        /**
         * Constructor to creater a controller object
         * @param model the mother object
         * @param view the view object
         * @param login the login object
         * @param signup the signup object
         */
	public Controller(Mother model, Home view, LoginForm login, SignupForm signup){
            homeView = view;
            loginView = login;
            recordsModel = model;
            signupView = signup;
            motherCRUD = new MotherCRUD();
            appointmentCRUD = new AppointmentCRUD();
            diaryCRUD = new DiaryCRUD();
            
            homeView.getSaveEditBtn_Mother().setIcon(homeView.getEditIcon());

            initializeDatabase();
            
            summaryMenuBtnControl();
            
            rowSorter = new TableRowSorter<>(homeView.getAppointmentsTableModel());
            homeView.getAppointsmentTable_Appointments().setRowSorter(rowSorter);
            //homeView.getSummaryMenuBtn();
        }
        
    //signup controls
        /**
         * Control for the signup button action
         */
        public void signupBtnControl(){
        signupView.getSignUpSignupBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                signupBtnActionPerformed(evt);
            }
        });  
    }
        /**
         * Method to control the signup button
         * @param evt Action Event
         */
        private void signupBtnActionPerformed(ActionEvent evt) {
            //insert signup action here:
            //create mother object if not exist in database
            
            
            
            recordsModel = new Mother(signupView.getUsernameText_Signup().getText(),
                    signupView.getFirstNameText_Signup().getText() , 
                    signupView.getSurnameText_Signup().getText(), 
                    (new java.sql.Date(signupView.getDobDateChooser_Signup().getDate().getTime())), 
                    (MD5(new String(signupView.getPasswordText_Signup().getPassword()))), 
                    new Medical(signupView.getHospitalText_Signup().getText()));
            
            try{
            motherCRUD.addMother(recordsModel);
            }
            catch(Exception e){
                //already exists
                System.out.println("Exception occured: " + e);
                System.out.println("duplicate, exists");
            }
            
            signupView.dispose();
            homeView.setVisible(true);
            homeView.getFirstNameText_Mother().setText(recordsModel.getFirstName());
            homeView.getSurnameText_Mother().setText(recordsModel.getSurname());
            homeView.getDobDateChooser_Mother().setDate(recordsModel.getDateOfBirth());
            homeView.getEmailText_Mother().setText(recordsModel.getMotherUsername());
            homeView.getHospitalText_Mother().setText(recordsModel.getMedicalInfo().getHospital());
            //cover info update:
            homeView.getMotherNameLabel_Cover().setText(recordsModel.getFirstName() + " " + recordsModel.getSurname());
            System.out.println("signup really works");
            
        }
        
    //login controls
        /**
         * Control for the login action
         */
    public void loginBtnControl(){
        loginView.getSignInLoginBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });  
    }
    /**
         * Method to control the login
         * @param evt Action Event
         */
        private void loginBtnActionPerformed(ActionEvent evt) {
            //insert login action here:
            //search database where username and password are equal
            //if true, 
            
            String user = loginView.getUsernameText_Login().getText();
            String pass = MD5(new String(loginView.getPasswordText_Login().getPassword()));
            
            recordsModel = motherCRUD.confirmLogin(user, pass);
            System.out.println("Mother: " + recordsModel);
            if (recordsModel != null){
            homeView.getFirstNameText_Mother().setText(recordsModel.getFirstName());
            homeView.getSurnameText_Mother().setText(recordsModel.getSurname());
            homeView.getDobDateChooser_Mother().setDate(recordsModel.getDateOfBirth());
            homeView.getEmailText_Mother().setText(recordsModel.getMotherUsername());
            homeView.getHospitalText_Mother().setText(recordsModel.getMedicalInfo().getHospital());
            homeView.getDoctorText_Mother().setText(recordsModel.getMedicalInfo().getDoctor() );
            homeView.getConceptionDateChooser_Mother().setDate(recordsModel.getMedicalInfo().getConceptionDate() );
            homeView.getAsthmaCheckBox_Mother().setSelected( recordsModel.getMedicalInfo().getAsthma() );
            homeView.getHivCheckBox_Mother().setSelected(recordsModel.getMedicalInfo().getHiv() );
            homeView.getBloodGroupComboBox_Mother().setSelectedItem(recordsModel.getMedicalInfo().getBloodGroup());
            //cover info update:
            homeView.getMotherNameLabel_Cover().setText(recordsModel.getFirstName() + " " + recordsModel.getSurname());
            
            
            Date conceptionDateFromDB = motherCRUD.getConceptionDate(recordsModel);
            System.out.println("date from db " + conceptionDateFromDB);
            if (conceptionDateFromDB != null){
                
                
            Calendar cal = Calendar.getInstance();
            cal.setTime(conceptionDateFromDB);
            long time = cal.getTimeInMillis();
                        System.out.println("long time " + time);

            cal.setTime(new java.util.Date());
            long now = cal.getTimeInMillis();
            long millisecondsPreg = now - time;
            Long weeksPregLong = millisecondsPreg/(MILLISECONDS_IN_SECS * MINUTES_HOURS_IN_SECS * MINUTES_HOURS_IN_SECS * HOURS_IN_DAY * DAYS_IN_WEEK);
                        System.out.println("weeks long preg " + weeksPregLong);

            int weeksRemainingInt = PREGNANCY_WEEKS - weeksPregLong.intValue();
            if (weeksRemainingInt > 0){
            homeView.getWeeksLeftLabel_Cover().setText("You have about " + weeksRemainingInt + " weeks to go");
            }
            else{
               homeView.getWeeksLeftLabel_Cover().setText("You should be due by now");
            }
            
            }
            
            loginView.dispose();
            homeView.setVisible(true);

                
            System.out.println("login works");
            }
            
            else {
                loginView.getError().setVisible(true);
                System.out.println("Error:Maybe couldn't find user");
            }
            
            //recordsModel = new Mother(signupView.getUsernameText_Signup().getText(),

            

        }
        
        /**
         * Sign up control action
         */
        public void signUpControl(){
            loginView.getSignUpLoginBtn().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                signupBtn_LoginMouseClicked(evt);
            }
        });
            
            
            loginView.getSignUpLoginBtn().addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent evt) {
                signupBtn_LoginMouseEntered(evt);
            }
        });
            
            loginView.getSignUpLoginBtn().addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent evt) {
                signupBtn_LoginMouseExited(evt);
            }
        });
            
        }
        
        
        private void signupBtn_LoginMouseClicked(MouseEvent evt) {                                               
        // TODO add your handling code here:
                        //insert sign up action here:
            loginView.getSignUpLoginBtn().setBorder(new LineBorder(Color.decode("#2A6BDD")));
            loginView.getSignUpLoginBtn().setForeground(Color.LIGHT_GRAY);
            loginView.dispose();
            signupView.setVisible(true);
            System.out.println("signup works-->");
            //show that button pressed

    }
        
        private void signupBtn_LoginMouseEntered(MouseEvent evt) {
                        System.out.println("hover works");

            loginView.getSignUpLoginBtn().setForeground(Color.DARK_GRAY);

        }
        
        private void signupBtn_LoginMouseExited(MouseEvent evt) {
                        System.out.println("exit works");

            loginView.getSignUpLoginBtn().setForeground(Color.decode("#2A6BDD"));

        }

        
        
    //sidebar button controls
        /**
         * Summary Menu Button Control
         */
    public void summaryMenuBtnControl(){
        
      homeView.getSummaryMenuBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                summaryMenuBtnActionPerformed(evt);
            }
        });  
        }
        
    private void summaryMenuBtnActionPerformed(ActionEvent evt) {                                               

        String summary = (" Name: " + recordsModel.getFirstName() + " " + recordsModel.getSurname() + "\n Date of Birth: "
                + recordsModel.getDateOfBirth() + " \n Hospital: "+ recordsModel.getMedicalInfo().getHospital() + " \n Doctor: "+  recordsModel.getMedicalInfo().getDoctor() +
                 " \n Conception Date: "+ recordsModel.getMedicalInfo().getConceptionDate() +  " \n Blood Group: "+ recordsModel.getMedicalInfo().getBloodGroup() +  " \n Asthma Status: "+ 
                recordsModel.getMedicalInfo().getAsthma() +  " \n HIV Status: "+  recordsModel.getMedicalInfo().getHiv() 
                
                + "\n " + " \n Today's Details:"
                );
        
        
        
        homeView.getsummaryTextArea().setText(summary + "\n "+ lastDiary);
        //homeView.getsummaryTextArea().setText(lastDiary);
        
        homeView.getMotherMainPanel().setVisible(false);
        homeView.getDiaryMainPanel().setVisible(false);
        homeView.getSummaryMainPanel().setVisible(true);
        homeView.getAppointmentsMainPanel().setVisible(false);
        homeView.getRecordsMainPanel().setVisible(false);
        
        
    } 
        /**
         * Diary Menu Button control
         */
    public void diaryMenuBtnControl(){
                    
      homeView.getDiaryMenuBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                diaryMenuBtnActionPerformed(evt);
            }
        });  
        }
        
    private void diaryMenuBtnActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
           
        homeView.getMotherMainPanel().setVisible(false);
        homeView.getDiaryMainPanel().setVisible(true);
        homeView.getSummaryMainPanel().setVisible(false);
        homeView.getAppointmentsMainPanel().setVisible(false);
        homeView.getRecordsMainPanel().setVisible(false);
    }                                            
/**
 * Mother Menu Button Control
 */
    public void motherMenuBtnControl(){
                    
      homeView.getMotherMenuBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                motherMenuBtnActionPerformed(evt);
            }
        });  
            
        }
        
    private void motherMenuBtnActionPerformed(ActionEvent evt) {                                              
        // TODO add your handling code here:
        
        homeView.getMotherMainPanel().setVisible(true);
        homeView.getDiaryMainPanel().setVisible(false);
        homeView.getSummaryMainPanel().setVisible(false);
        homeView.getAppointmentsMainPanel().setVisible(false);
        homeView.getRecordsMainPanel().setVisible(false);

    }                                             
/**
 * Appointment Details Menu Button Control
 */
    public void appointmentDetailsMenuBtnControl(){
                            
      homeView.getAppointmentDetailsMenuBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                appointmentDetailsMenuBtnActionPerformed(evt);
            }
        });  
           
    }
    
    private void appointmentDetailsMenuBtnActionPerformed(ActionEvent evt) {                                                          
        // TODO add your handling code here:
        homeView.getMotherMainPanel().setVisible(false);
        homeView.getDiaryMainPanel().setVisible(false);
        homeView.getSummaryMainPanel().setVisible(false);
        homeView.getAppointmentsMainPanel().setVisible(true);
        homeView.getRecordsMainPanel().setVisible(false);
        
        homeView.getAppointmentsMonthListModel().clear();
        
        HashMap<Integer, Integer> monthMap = appointmentCRUD.getMonths(recordsModel);
        Collection<Integer> monthCollection = monthMap.values();
        Object[] monthArray = monthCollection.toArray();
        
        //list
        for (int i=0; i< monthArray.length; i++){
             
                    
      switch ((Integer)monthArray[i]){
      case 0:  homeView.getAppointmentsMonthListModel().addElement("All"); break;
      case 1:  homeView.getAppointmentsMonthListModel().addElement("January"); break;
      case 2:  homeView.getAppointmentsMonthListModel().addElement("February"); break;
      case 3:  homeView.getAppointmentsMonthListModel().addElement("March"); break;
      case 4:  homeView.getAppointmentsMonthListModel().addElement("April"); break;
      case 5:  homeView.getAppointmentsMonthListModel().addElement("May"); break;
      case 6:  homeView.getAppointmentsMonthListModel().addElement("June"); break;
      case 7:  homeView.getAppointmentsMonthListModel().addElement("July"); 
                      System.out.println("Look, probably adds July to the list");
      break;
      case 8:  homeView.getAppointmentsMonthListModel().addElement("August"); break;
      case 9:  homeView.getAppointmentsMonthListModel().addElement("September"); break;
      case 10: homeView.getAppointmentsMonthListModel().addElement("October"); break;
      case 11: homeView.getAppointmentsMonthListModel().addElement("November"); break;
      case 12: homeView.getAppointmentsMonthListModel().addElement("December"); 
                System.out.println("Look, probably adds December to the list");

      break;

      default:           System.out.println("Look, probably doesn't add the months to the list");
;
    }
                            
        }
        
        //set selected index of list to All
        homeView.getMonthlyAppointmentList_Appointments().setSelectedIndex(0);
        
    }                                                         
/**
 * Appointment Month List Item Control
 */
    public void appointmentMonthListItemControl(){
       //change item below

        homeView.getMonthlyAppointmentList_Appointments().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                appointmentMonthListItemActionPerformed(evt);
                
            }
            
            
            
            
        });  
           
    }
    
    
    
    private void appointmentMonthListItemActionPerformed(MouseEvent evt) {                                                          
        // TODO add your handling code here:

                         System.out.println("I'm getting confused 2");
        
        homeView.getAppointmentsTableModel().setRowCount(0);
        
        Vector<Appointment> getAppointments = appointmentCRUD.getAppointments(
                (String)homeView.getMonthlyAppointmentList_Appointments().getSelectedValue(), recordsModel);
        //Collection<Integer> monthCollection = monthMap.values();
        //Object[] monthArray = monthCollection.toArray();
        
        //list
        for (int i=0; i< getAppointments.size(); i++){
                                      System.out.println("I'm getting confused 3 and size of vector is " + getAppointments.size());

                    homeView.getAppointmentsTableModel().addRow(new Object[] {
                        getAppointments.get(i).getID(),
                        getAppointments.get(i).getPurpose(), getAppointments.get(i).getDate(),
                        getAppointments.get(i).getHospital(),getAppointments.get(i).getDoctor(),
                        getAppointments.get(i).getTime(),getAppointments.get(i).getMother(),
                        getAppointments.get(i).getMonth() //,getAppointments.get(i).getID()
                    });
      
                            
        }
        
    }
    
    /**
     * Edit Okay Button Control
     */
    public void editOkayBtnControl(){
                    
      loginView.getErrorOkayBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
        loginView.getError().dispose();
            }
        }); 
      
      homeView.getErrorOkayBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                homeView.getError().dispose();
            }
        }); 
            
        }
    
        
    /**
     * Appointment Table Item Control
     */
    
    public void appointmentTableItemControl(){
       //change item below

        homeView.getAppointsmentTable_Appointments().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                appointmentTableItemControlActionPerformed(evt);
            }
            
            
            
            
        });  
           
    }
    
    private void appointmentTableItemControlActionPerformed(MouseEvent evt) {                                                          
        // TODO add your handling code here:

                         System.out.println("I'm getting confused 4");
        
        
        int tableIndex = homeView.getAppointsmentTable_Appointments().getSelectedRow();
        
        String id = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(tableIndex, 0));
        String purpose = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(tableIndex, 1));
        String date = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(tableIndex, 2));
        String hospital = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(tableIndex, 3));
        String doctor = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(tableIndex, 4));
        String time = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(tableIndex, 5));
        //String mother = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(tableIndex, 5));
        //String month = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(tableIndex, 6));                                                        
        
        homeView.getSelectedAppointmentText_Appointments().setText(
        
                "Appointment Details: \n" +
                //"Id: " + id + "\n" +
                "Purpose: " + purpose + "\n" +
                "Date: " + date + "\n" +
                "Hospital: " + hospital + "\n" +
                "Doctor: " + doctor + "\n" +
                "Time: " + time );        
        
        
        
        
        
        
    }
    /**
     * Records Menu Button Control
     */
    public void recordsMenuBtnControl(){
                            
      homeView.getRecordsMenuBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                recordsMenuBtnActionPerformed(evt);
            }
        });    
    }
    
    private void recordsMenuBtnActionPerformed(ActionEvent evt) {                                               
        // TODO add your handling code here:
        homeView.getMotherMainPanel().setVisible(false);
        homeView.getDiaryMainPanel().setVisible(false);
        homeView.getSummaryMainPanel().setVisible(false);
        homeView.getAppointmentsMainPanel().setVisible(false);
        homeView.getRecordsMainPanel().setVisible(true);

    }
    
    
    //Main Panel Button Controls
    /**
     * Save Button Diary Control
     */
    public void saveBtn_DiaryControl(){
        homeView.getSaveBtn_Diary().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
              //  try{
                saveBtn_DiaryActionPerformed(evt);
                /*}
                catch(Exception e){
                    System.out.println(e.toString() + ": Yelp! Error!");
                }*/
            }
        });
        
    }
    
    public String lastDiary = "No Diary Entry Today";
    
    private void saveBtn_DiaryActionPerformed(ActionEvent evt){
        //what should save button do?
        //add the information in the form to a database or collection
        try{
        HealthStats stats = new HealthStats(
                Double.parseDouble(homeView.getWeightText_Diary().getText()), 
                Integer.parseInt(homeView.getBloodPressureText_Diary().getText()),
                Double.parseDouble(homeView.getHeightText_Diary().getText()), 
                Double.parseDouble(homeView.getBumpText_Diary().getText()),
                homeView.getFeelingText_Diary().getText());
      
        

        PregnancyRecords rec = new PregnancyRecords(recordsModel,  new java.sql.Date(homeView.getRecordDateChooser_Diary().getDate().getTime()), stats);
        
        diaryCRUD.addDiary(rec);
        
        pregnancyRecordsMap.put(rec.getDateRecord(),rec);
        lastDiary = (/*"Size " + pregnancyRecordsMap.size() + */
                "Weight: " + Double.parseDouble(homeView.getWeightText_Diary().getText()) + " \n " + 
                "Blood Pressure: " + Integer.parseInt(homeView.getBloodPressureText_Diary().getText()) + " \n " +
                "Height : " + Double.parseDouble(homeView.getHeightText_Diary().getText()) + " \n " +
                "Bump Size: " + Double.parseDouble(homeView.getBumpText_Diary().getText()) + " \n " +
                
                
                ""
                + ""
                + ""
                + ""
                + " \n Your BMI is: " + rec.getStatsRecord().getBodyMassIndex() + " \n So you are: " + rec.getStatsRecord().getBmiExplanation() +
                
                "\n \n" +
                
                " Journal Entry: " + homeView.getFeelingText_Diary().getText() 
                
                );
        System.out.println("The date is: " + rec.getDateRecord());
        
        }
        catch (Exception e){
            System.out.println("Whoops, Error!: " + e.toString());
                                        homeView.getError().setVisible(true);

        }
   
        //put in collection: if old date exists, old date is overwritten
        //put in database
        //dialog box to show success or warning or fail
        //reset fields to blank
        
        setDiaryFieldsBlank();
        
    }
    /**
     * Method to set diary fields blank
     */
    private void setDiaryFieldsBlank(){
        homeView.getRecordDateChooser_Diary().setDate(null);
        homeView.getWeightText_Diary().setText("");
        homeView.getBloodPressureText_Diary().setText("");
        homeView.getHeightText_Diary().setText("");
        homeView.getBumpText_Diary().setText("");
        homeView.getFeelingText_Diary().setText("");
    }
    /**
     * Save Edit Button Control
     */
    public void saveEditBtn_MotherControl(){
        homeView.getSaveEditBtn_Mother().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                saveEditBtn_MotherActionPerformed(evt);
            }
        });
        
    }
    
    private void saveEditBtn_MotherActionPerformed(ActionEvent evt){
        //what should edit/save button do?
        if (homeView.getSaveEditState() == homeView.EDIT_STATE){
            //homeView.getSaveEditBtn_Mother().getText().equalsIgnoreCase("Edit")){
            homeView.setSaveEditState(homeView.SAVE_STATE);
            //change icon
            System.out.println("changing icon");
            homeView.getSaveEditBtn_Mother().setIcon(homeView.getSaveIcon());
            //homeView.getSaveEditBtn_Mother().setText("Save");
            homeView.getFirstNameText_Mother().setEditable(true);
            homeView.getSurnameText_Mother().setEditable(true);
            homeView.getDobDateChooser_Mother().setEnabled(true);
            homeView.getEmailText_Mother().setEditable(true);
            homeView.getHospitalText_Mother().setEditable(true);
            homeView.getDoctorText_Mother().setEditable(true); 
            homeView.getConceptionDateChooser_Mother().setEnabled(true);
            homeView.getAsthmaCheckBox_Mother().setEnabled(true);
            homeView.getHivCheckBox_Mother().setEnabled(true);
            homeView.getBloodGroupComboBox_Mother().setEnabled(true);
                        
        }
        
        else if (homeView.getSaveEditState() == homeView.SAVE_STATE){
            //homeView.getSaveEditBtn_Mother().getText().equalsIgnoreCase("Save")) {
            homeView.setSaveEditState(homeView.EDIT_STATE);
            //change icon
                        System.out.println("changing icon 2");
            homeView.getSaveEditBtn_Mother().setIcon(homeView.getEditIcon());
            //homeView.getSaveEditBtn_Mother().setText("Edit");
            homeView.getFirstNameText_Mother().setEditable(false);
            homeView.getSurnameText_Mother().setEditable(false);
            homeView.getDobDateChooser_Mother().setEnabled(false);
            homeView.getEmailText_Mother().setEditable(false);
            homeView.getHospitalText_Mother().setEditable(false);
            homeView.getDoctorText_Mother().setEditable(false);
            homeView.getConceptionDateChooser_Mother().setEnabled(false);
            homeView.getAsthmaCheckBox_Mother().setEnabled(false);
            homeView.getHivCheckBox_Mother().setEnabled(false);
            homeView.getBloodGroupComboBox_Mother().setEnabled(false);
            
            recordsModel.setFirstName(homeView.getFirstNameText_Mother().getText());
            recordsModel.setSurname(homeView.getSurnameText_Mother().getText());
            recordsModel.setDateOfBirth( new java.sql.Date( homeView.getDobDateChooser_Mother().getDate().getTime()));
            recordsModel.setMotherUsername(homeView.getEmailText_Mother().getText());
            recordsModel.setMedicalInfo(new Medical(homeView.getHospitalText_Mother().getText(), 
                    homeView.getDoctorText_Mother().getText(), 
                    (new java.sql.Date(homeView.getConceptionDateChooser_Mother().getDate().getTime())),
                    homeView.getAsthmaCheckBox_Mother().isSelected(), 
                    homeView.getHivCheckBox_Mother().isSelected(),
                    (String) homeView.getBloodGroupComboBox_Mother().getSelectedItem()
            
            ));
            
            //cover info update:
            //homeView.getWeeksLeftLabel_Cover().setText(.getFirstName() + " " + recordsModel.getSurname());
            
            
            Calendar cal = Calendar.getInstance();
    cal.setTime(recordsModel.getMedicalInfo().getConceptionDate());
    long time = cal.getTimeInMillis();
    cal.setTime(new java.util.Date());
            long now = cal.getTimeInMillis();
    long millisecondsPreg = now - time;
    Long weeksPregLong = millisecondsPreg/(MILLISECONDS_IN_SECS * MINUTES_HOURS_IN_SECS * MINUTES_HOURS_IN_SECS * HOURS_IN_DAY * DAYS_IN_WEEK);
    int weeksRemainingInt = PREGNANCY_WEEKS - weeksPregLong.intValue();
            
        
if (weeksRemainingInt > 0){
            homeView.getWeeksLeftLabel_Cover().setText("You have about " + weeksRemainingInt + " weeks to go");
            }
            else{
               homeView.getWeeksLeftLabel_Cover().setText("You should be due by now");
            }
                        
            
            motherCRUD.updateMother(recordsModel);

            
        }
        //include actual save or edit code
    }
        
    /**
     * New Appointment Button Control
     */
       public void newAppointmentBtn_AppointmentsControl(){
        
      homeView.getNewAppointmentBtn_Appointments().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                newAppointmentBtn_AppointmentsActionPerformed(evt);
            }
        });  
        }
        
    private void newAppointmentBtn_AppointmentsActionPerformed(ActionEvent evt) {                                               
        System.out.println("10:24pm ;)");
        homeView.getNewAppointmentDialog_Appointments().setVisible(true);
        

        
    }
    
    /**
     * Delete Appointment Button Control
     */
    public void deleteAppointmentBtn_AppointmentsControl(){
        
      homeView.getDeleteAppointmentBtn_Appointments().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                deleteAppointmentBtn_AppointmentsActionPerformed(evt);
            }
        });  
        }
        
    private void deleteAppointmentBtn_AppointmentsActionPerformed(ActionEvent evt) {                                               

        //find & delete in table, database and refresh table
        try{
        int row = homeView.getAppointsmentTable_Appointments().getSelectedRow();
        int id = (Integer)homeView.getAppointsmentTable_Appointments().getValueAt(row, 0);
        System.out.println("Id at index 0 is: " + id);
        
        homeView.getAppointmentsTableModel().removeRow(row);
        
        appointmentCRUD.deleteAppointment(id);
        
        //refresh list & table
        //int index = homeView.getMonthlyAppointmentList_Appointments().getSelectedIndex();
        //homeView.getMonthlyAppointmentList_Appointments().setSelectedIndex(index);
        
        appointmentDetailsMenuBtnActionPerformed(null);
        homeView.getSelectedAppointmentText_Appointments().setText(null);
        
        }
        catch(Exception e){
            //dialog: select something
        }
        
    }
    
    /**
     * Export Menu Control
     */
       public void exportMenuControl(){
        
      homeView.getExportMenu().addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                newExportMenuActionPerformed(evt);
            }
        });
        }
        
    private void newExportMenuActionPerformed(MouseEvent evt) {                                               
    
    
        String appointmentID;
        String date; 
        String hospital;
        String doctor;
        String time;
        String mother;
        String month;
    
        JOptionPane myPane = new JOptionPane("Notifier");
    
        System.out.println("Exporting");
    
        File file;
        PrintWriter outputStream;
        JFileChooser myFileChooser = new JFileChooser();
        myFileChooser.setDialogTitle("Save Appointments to File");
        myFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY );
        int result = myFileChooser.showSaveDialog( null );
    
    
        if ( result == JFileChooser.CANCEL_OPTION ){
            return;
        }
        
        file = myFileChooser.getSelectedFile();
     
        if ( file == null || file.getName().equals("") ) {
            JOptionPane.showMessageDialog(myPane, "Invalid File");
        }
    
        else {
            try {        
                if (file.getName().contains(".csv")){          
                    outputStream = new PrintWriter(file);
                }
                else
                {
                    outputStream = new PrintWriter(file + ".csv");
                }
                outputStream.println("appointmentID , date , hospital , doctor , time , mother , month");
        
                for (int rowNum = 0; rowNum < homeView.getAppointsmentTable_Appointments().getRowCount(); rowNum++) {
          
          appointmentID = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(rowNum, 0));
          date = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(rowNum, 1));
          hospital = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(rowNum, 2));
          doctor = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(rowNum, 3));
          time = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(rowNum, 4));
          mother = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(rowNum, 5));
          month = String.valueOf(homeView.getAppointsmentTable_Appointments().getValueAt(rowNum, 6));
          
          
          outputStream.println(appointmentID + "," + date + "," + hospital + "," + doctor + "," + time + "," + mother + "," +month);
        }
        
        outputStream.close();
      }
      catch (IOException e) {
        JOptionPane.showMessageDialog(myPane, "Failed to read or write to file");
        
      }
    }

    
    }
    
    /**
     * Add Button Control
     */
    public void addBtn_AppointmentsControl(){
        
      homeView.getAddBtn_AppointmentsDialog().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                addBtn_AppointmentActionPerformed(evt);
            }
        });  
        }
        
    private void addBtn_AppointmentActionPerformed(ActionEvent evt) {                                               
          appointment = new Appointment(recordsModel,
          (new java.sql.Date(homeView.getDateDate_AppointmentsDialog().getDate().getTime())),
          (homeView.getPurposeText_AppointmentsDialog().getText()),
          (homeView.getHospitalText_AppointmentsDialog().getText()),
          (homeView.getDoctorText_AppointmentsDialog().getText()),
          ((String)(homeView.getTimeCombo_AppointmentsDialog().getSelectedItem())));

        try{
            System.out.println("Yeah, adding to appointments");
            appointmentCRUD.addAppointment(appointment);
            homeView.getNewAppointmentDialog_Appointments().dispose();
            
            //set fields blank:
            homeView.getPurposeText_AppointmentsDialog().setText("");
            homeView.getHospitalText_AppointmentsDialog().setText("");
            homeView.getDoctorText_AppointmentsDialog().setText("");
            homeView.getDateDate_AppointmentsDialog().setDate(null);
            homeView.getTimeCombo_AppointmentsDialog().setSelectedItem(null);
                    
            appointmentDetailsMenuBtnActionPerformed(null);
            

            }
            catch(Exception e){
                //already exists
                System.out.println("Exception occured: " + e);
                System.out.println("duplicate, exists");
            }
        homeView.getAppointmentDetailsMenuBtn().doClick();
    }
    
    private void searchAppointmentBtn_AppointmentsActionPerformed(ActionEvent evt){
        if (homeView.getSearchAppointmentText_Appointments().getText().trim().length() == 0){
            rowSorter.setRowFilter(null);
        }
        else {
            rowSorter.setRowFilter((RowFilter.regexFilter(homeView.getSearchAppointmentText_Appointments().getText())));
        }
        System.out.println("Searching");
        
        homeView.getSearchAppointmentText_Appointments().setText("");
    }
    
    /**
     * Search Appointment Button Control
     */
    public void searchAppointmentBtn_AppointmentsControl(){
        homeView.getSearchAppointmentBtn_Appointments().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                searchAppointmentBtn_AppointmentsActionPerformed(evt);
            }
            
        });
    }

                                    


        
}       

