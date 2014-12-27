package pregnancydiary.views;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author michaelannor
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        
        /*Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        System.out.println(sdf.format(date));
        
        (new Date()).toString()
        */
        
        timeCombo_AppointmentsDialog.setSelectedItem(null);
        bloodGroupComboBox_Mother.setSelectedItem(null);
        
        getDateLabel_Cover().setText("Today is " + (new SimpleDateFormat("EEE, MMM d, yyyy").format(new Date())));
                
        motherMainPanel.setVisible(false);
        summaryMainPanel.setVisible(true);
        this.summaryMenuBtn.doClick();
        diaryMainPanel.setVisible(false);
        appointmentsMainPanel.setVisible(false);
        recordsMainPanel.setVisible(false);
        
        setSaveEditState(EDIT_STATE);

    }
    
    /**
     * Accessor for Error Dialog
     * @return Error Dialog Box
     */
       public JDialog getError(){
       error.setLocationRelativeTo(null);
       return error;
   }
   /**
    * Accessor for Okay Button
    * @return Okay button on dialog box
    */
   public JButton getErrorOkayBtn(){
       return errorOkayBtn;
   }
    /**
     * Accessor method for summary text area
     * @return summary text area
     */
    public JTextArea getsummaryTextArea(){
        return summaryTextArea;
    }
    
    /**
     * Accessor method for delete appointment button
     * @return delete appointment button
     */
    public JButton getDeleteAppointmentBtn_Appointments(){
        return deleteAppointmentBtn_Appointments;
    }
    /**
     * Accessor method for search appointments button
     * @return appointments button
     */
    public JToggleButton getSearchAppointmentBtn_Appointments(){
        return searchAppointmentBtn_Appointments;
    }
    /**
     * Accessor method for search appointments text field
     * @return search appointments text field
     */
    public JTextField getSearchAppointmentText_Appointments(){
        return searchAppointmentText_Appointments;
    }
    
    /**
     * Accessor method for the appointments table model
     * @return The Appointments Table Model
     */
    public DefaultTableModel getAppointmentsTableModel(){
         DefaultTableModel appointmentsTable =  (DefaultTableModel)appointmentsTable_Appointments.getModel();
                 System.out.println("I'm getting confused 1");
         
                 if (appointmentsTable.getColumnCount()==0){
         appointmentsTable.addColumn("AppointmentID");
         appointmentsTable.addColumn("Purpose");
         appointmentsTable.addColumn("Date");
         appointmentsTable.addColumn("Hospital");
         appointmentsTable.addColumn("Doctor");
         appointmentsTable.addColumn("Time");
         appointmentsTable.addColumn("Mother");
         appointmentsTable.addColumn("Month");
                 }
                 
                     //TableColumn col = appointmentsTable.getColumn(;

                 
                 //getAppointsmentTable_Appointments().removeColumn(appointmentsTable.getColumn(0));
                 
                 
                 //appointmentsTable.setEnabled(false);
         
                /* (new Object[][] {}, (new String[] {"Purpose", "Date", "Hospital"}))
        {
        public boolean isCellEditable(int row, int col){
            if (row == 0){
                return false;
            }
            else return true;//come back
        }
        };*/
         return appointmentsTable;
    }
    
    public static final String MORNING_TIME_STRING = "Morning";
    public static final String AFTERNOON_TIME_STRING = "Afternoon";
    public static final String EVENING_TIME_STRING = "Evening";
    public static final String BLOOD_AA = "AA";
    public static final String BLOOD_BB = "BB";
    public static final String BLOOD_AB = "AB";
    public static final String BLOOD_OO = "OO";
    
    private final String[] bloodGroupArray = {BLOOD_AA, BLOOD_BB, BLOOD_AB, BLOOD_OO};

    /**
     * Accessor method to return the blood group list model
     * @return Blood Group List Model
     */
    public DefaultComboBoxModel getBloodGroupListModel(){
        DefaultComboBoxModel bloodGroupList = new DefaultComboBoxModel(bloodGroupArray);
        return bloodGroupList;
    }
    
    /**
     * Accessor method to return the month list model
     * @return Month List Model
     */
    public DefaultListModel getAppointmentsMonthListModel(){
        //DefaultListModel monthList = new DefaultListModel();
                                 System.out.println("I'm getting confused genesis");

        DefaultListModel monthList = (DefaultListModel)monthlyAppointmentList_Appointments.getModel();
        return monthList;
    }
    
    /**
     * Accessor for the new appointment dialog box
     * @return New Appointment Dialog
     */
    public JDialog getNewAppointmentDialog_Appointments(){
        return newAppointmentDialog_Appointments;
    }
  
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarBtnGrp = new javax.swing.ButtonGroup();
        newAppointmentDialog_Appointments = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        purposeLabel_AppointmentsDialog = new javax.swing.JLabel();
        hospitalLabel_AppointmentsDialog = new javax.swing.JLabel();
        purposeText_AppointmentsDialog = new javax.swing.JTextField();
        hospitalText_AppointmentsDialog = new javax.swing.JTextField();
        doctorLabel_AppointmentsDialog = new javax.swing.JLabel();
        doctorText_AppointmentsDialog = new javax.swing.JTextField();
        dateDate_AppointmentsDialog = new com.toedter.calendar.JDateChooser();
        dateLabel_AppointmentsDialog = new javax.swing.JLabel();
        timeCombo_AppointmentsDialog = new javax.swing.JComboBox();
        timeLabel_AppointmentsDialog = new javax.swing.JLabel();
        addBtn_AppointmentsDialog = new javax.swing.JButton();
        error = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        errorOkayBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pagePanel = new javax.swing.JPanel();
        sidebarPanel = new javax.swing.JPanel();
        ProfileCoverPanel = new javax.swing.JPanel();
        motherNameLabel_Cover = new javax.swing.JLabel();
        dateLabel_Cover = new javax.swing.JLabel();
        weeksLeftLabel_Cover = new javax.swing.JLabel();
        coverIcon_Cover = new javax.swing.JLabel();
        summaryPanel = new javax.swing.JPanel();
        summaryMenuBtn = new javax.swing.JToggleButton();
        diaryPanel = new javax.swing.JPanel();
        diaryMenuBtn = new javax.swing.JToggleButton();
        motherPanel = new javax.swing.JPanel();
        motherMenuBtn = new javax.swing.JToggleButton();
        appointmentDetails = new javax.swing.JPanel();
        appointmentDetailsMenuBtn = new javax.swing.JToggleButton();
        recordsPanel = new javax.swing.JPanel();
        recordsMenuBtn = new javax.swing.JToggleButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        motherMainPanel = new javax.swing.JPanel();
        firstNameText_Mother = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        firstNameLabel_Mother = new javax.swing.JLabel();
        personalLabel_Mother = new javax.swing.JLabel();
        medicalLabel_Mother = new javax.swing.JLabel();
        hospitalLabel_Mother = new javax.swing.JLabel();
        hospitalText_Mother = new javax.swing.JTextField();
        doctorLabel_Mother = new javax.swing.JLabel();
        doctorText_Mother = new javax.swing.JTextField();
        emailLabel_Mother = new javax.swing.JLabel();
        emailText_Mother = new javax.swing.JTextField();
        dobLabel_Mother = new javax.swing.JLabel();
        conceptionDateLabel_Mother = new javax.swing.JLabel();
        asthmaCheckBox_Mother = new javax.swing.JCheckBox();
        hivCheckBox_Mother = new javax.swing.JCheckBox();
        bloodGroupLabel_Mother = new javax.swing.JLabel();
        bloodGroupComboBox_Mother = new javax.swing.JComboBox();
        surnameLabel_Mother = new javax.swing.JLabel();
        surnameText_Mother = new javax.swing.JTextField();
        saveEditBtn_Mother = new javax.swing.JButton();
        conceptionDateChooser_Mother = new com.toedter.calendar.JDateChooser();
        dobDateChooser_Mother = new com.toedter.calendar.JDateChooser();
        summaryMainPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        summaryTextArea = new javax.swing.JTextArea();
        diaryMainPanel = new javax.swing.JPanel();
        healthStatsLabel_Diary = new javax.swing.JLabel();
        weightLabel_Diary = new javax.swing.JLabel();
        weightText_Diary = new javax.swing.JTextField();
        bumpLabel_Diary = new javax.swing.JLabel();
        bumpText_Diary = new javax.swing.JTextField();
        bloodPressureLabel_Diary = new javax.swing.JLabel();
        bloodPressureText_Diary = new javax.swing.JTextField();
        heightLabel_Diary = new javax.swing.JLabel();
        heightText_Diary = new javax.swing.JTextField();
        midSeparator_Diary = new javax.swing.JSeparator();
        feelingLabel_Diary = new javax.swing.JLabel();
        feelingScrollPane_Diary = new javax.swing.JScrollPane();
        feelingText_Diary = new javax.swing.JTextArea();
        saveBtn_Diary = new javax.swing.JButton();
        dateLabel_Diary = new javax.swing.JLabel();
        recordDateChooser_Diary = new com.toedter.calendar.JDateChooser();
        appointmentsMainPanel = new javax.swing.JPanel();
        appointmentsLabel_Appointments = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentsTable_Appointments = new javax.swing.JTable();
        newAppointmentBtn_Appointments = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedAppointmentText_Appointments = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        monthlyAppointmentList_Appointments = new javax.swing.JList();
        monthlyAppointmentLabel_Appointments = new javax.swing.JLabel();
        deleteAppointmentBtn_Appointments = new javax.swing.JButton();
        searchAppointmentText_Appointments = new javax.swing.JTextField();
        searchAppointmentBtn_Appointments = new javax.swing.JToggleButton();
        recordsMainPanel = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        ExportMenu = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        newAppointmentDialog_Appointments.setBackground(new java.awt.Color(255, 255, 255));
        newAppointmentDialog_Appointments.setLocation(new java.awt.Point(300, 200));
        newAppointmentDialog_Appointments.setModal(true);
        newAppointmentDialog_Appointments.setResizable(false);
        newAppointmentDialog_Appointments.setSize(new java.awt.Dimension(591, 360));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(42, 107, 221));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add New Appointment");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/dialog_cover.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        purposeLabel_AppointmentsDialog.setText("Purpose");

        hospitalLabel_AppointmentsDialog.setText("Hospital");

        hospitalText_AppointmentsDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hospitalText_AppointmentsDialogActionPerformed(evt);
            }
        });

        doctorLabel_AppointmentsDialog.setText("Doctor");

        dateLabel_AppointmentsDialog.setText("Date");

        timeCombo_AppointmentsDialog.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning", "Afternoon", "Evening" }));

        timeLabel_AppointmentsDialog.setText("Time");

        addBtn_AppointmentsDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/add_dialog_btn.png"))); // NOI18N
        addBtn_AppointmentsDialog.setBorderPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purposeLabel_AppointmentsDialog)
                    .addComponent(hospitalLabel_AppointmentsDialog)
                    .addComponent(doctorLabel_AppointmentsDialog)
                    .addComponent(dateLabel_AppointmentsDialog)
                    .addComponent(timeLabel_AppointmentsDialog))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(timeCombo_AppointmentsDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(addBtn_AppointmentsDialog))
                    .addComponent(purposeText_AppointmentsDialog)
                    .addComponent(hospitalText_AppointmentsDialog)
                    .addComponent(doctorText_AppointmentsDialog, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateDate_AppointmentsDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purposeLabel_AppointmentsDialog)
                    .addComponent(purposeText_AppointmentsDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hospitalText_AppointmentsDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hospitalLabel_AppointmentsDialog))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doctorText_AppointmentsDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doctorLabel_AppointmentsDialog))
                        .addGap(30, 30, 30)
                        .addComponent(dateLabel_AppointmentsDialog))
                    .addComponent(dateDate_AppointmentsDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBtn_AppointmentsDialog)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeCombo_AppointmentsDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLabel_AppointmentsDialog))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout newAppointmentDialog_AppointmentsLayout = new javax.swing.GroupLayout(newAppointmentDialog_Appointments.getContentPane());
        newAppointmentDialog_Appointments.getContentPane().setLayout(newAppointmentDialog_AppointmentsLayout);
        newAppointmentDialog_AppointmentsLayout.setHorizontalGroup(
            newAppointmentDialog_AppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        newAppointmentDialog_AppointmentsLayout.setVerticalGroup(
            newAppointmentDialog_AppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        error.setModal(true);
        error.setResizable(false);
        error.setSize(new java.awt.Dimension(488, 208));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(42, 107, 221));
        jLabel2.setText("Invalid input. Please try to be more careful here. ");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/dialog_icon_blue.png"))); // NOI18N

        errorOkayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/ok_btn_small.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(42, 107, 221));
        jLabel3.setText("Error:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorOkayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(errorOkayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout errorLayout = new javax.swing.GroupLayout(error.getContentPane());
        error.getContentPane().setLayout(errorLayout);
        errorLayout.setHorizontalGroup(
            errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        errorLayout.setVerticalGroup(
            errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pregnancy Diary");
        setBackground(new java.awt.Color(255, 255, 255));

        pagePanel.setBackground(new java.awt.Color(255, 255, 255));

        sidebarPanel.setBackground(new java.awt.Color(255, 255, 255));
        sidebarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 225, 225)));

        ProfileCoverPanel.setBackground(new java.awt.Color(42, 107, 221));

        motherNameLabel_Cover.setFont(new java.awt.Font("San Francisco Display", 1, 18)); // NOI18N
        motherNameLabel_Cover.setForeground(new java.awt.Color(255, 255, 255));
        motherNameLabel_Cover.setText("Mother Name");

        dateLabel_Cover.setFont(new java.awt.Font("San Francisco Display", 0, 14)); // NOI18N
        dateLabel_Cover.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel_Cover.setText("Today is 5th December, 2014");

        weeksLeftLabel_Cover.setFont(new java.awt.Font("San Francisco Display", 0, 14)); // NOI18N
        weeksLeftLabel_Cover.setForeground(new java.awt.Color(255, 255, 255));

        coverIcon_Cover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/cover.png"))); // NOI18N

        javax.swing.GroupLayout ProfileCoverPanelLayout = new javax.swing.GroupLayout(ProfileCoverPanel);
        ProfileCoverPanel.setLayout(ProfileCoverPanelLayout);
        ProfileCoverPanelLayout.setHorizontalGroup(
            ProfileCoverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileCoverPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(coverIcon_Cover)
                .addGap(18, 18, 18)
                .addGroup(ProfileCoverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weeksLeftLabel_Cover)
                    .addComponent(dateLabel_Cover)
                    .addComponent(motherNameLabel_Cover))
                .addContainerGap())
        );
        ProfileCoverPanelLayout.setVerticalGroup(
            ProfileCoverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileCoverPanelLayout.createSequentialGroup()
                .addGroup(ProfileCoverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProfileCoverPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(motherNameLabel_Cover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLabel_Cover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weeksLeftLabel_Cover))
                    .addGroup(ProfileCoverPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(coverIcon_Cover)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        summaryPanel.setBackground(new java.awt.Color(255, 255, 255));

        summaryMenuBtn.setBackground(new java.awt.Color(255, 255, 255));
        sidebarBtnGrp.add(summaryMenuBtn);
        summaryMenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/summary_unselect.png"))); // NOI18N
        summaryMenuBtn.setBorderPainted(false);
        summaryMenuBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/summary_select.png"))); // NOI18N
        summaryMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summaryMenuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout summaryPanelLayout = new javax.swing.GroupLayout(summaryPanel);
        summaryPanel.setLayout(summaryPanelLayout);
        summaryPanelLayout.setHorizontalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(summaryMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        summaryPanelLayout.setVerticalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(summaryMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        diaryPanel.setBackground(new java.awt.Color(255, 255, 255));

        diaryMenuBtn.setBackground(new java.awt.Color(255, 255, 255));
        sidebarBtnGrp.add(diaryMenuBtn);
        diaryMenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/diary_unselect.png"))); // NOI18N
        diaryMenuBtn.setBorderPainted(false);
        diaryMenuBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/diary_select.png"))); // NOI18N
        diaryMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaryMenuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diaryPanelLayout = new javax.swing.GroupLayout(diaryPanel);
        diaryPanel.setLayout(diaryPanelLayout);
        diaryPanelLayout.setHorizontalGroup(
            diaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(diaryMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        diaryPanelLayout.setVerticalGroup(
            diaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(diaryMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        motherPanel.setBackground(new java.awt.Color(255, 255, 255));

        motherMenuBtn.setBackground(new java.awt.Color(255, 255, 255));
        sidebarBtnGrp.add(motherMenuBtn);
        motherMenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/mother_unselect.png"))); // NOI18N
        motherMenuBtn.setBorderPainted(false);
        motherMenuBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/mother_select.png"))); // NOI18N
        motherMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motherMenuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout motherPanelLayout = new javax.swing.GroupLayout(motherPanel);
        motherPanel.setLayout(motherPanelLayout);
        motherPanelLayout.setHorizontalGroup(
            motherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(motherMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        motherPanelLayout.setVerticalGroup(
            motherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(motherMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        appointmentDetails.setBackground(new java.awt.Color(255, 255, 255));

        appointmentDetailsMenuBtn.setBackground(new java.awt.Color(255, 255, 255));
        sidebarBtnGrp.add(appointmentDetailsMenuBtn);
        appointmentDetailsMenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/appointments_unselect.png"))); // NOI18N
        appointmentDetailsMenuBtn.setBorderPainted(false);
        appointmentDetailsMenuBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/appointments_select.png"))); // NOI18N
        appointmentDetailsMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentDetailsMenuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout appointmentDetailsLayout = new javax.swing.GroupLayout(appointmentDetails);
        appointmentDetails.setLayout(appointmentDetailsLayout);
        appointmentDetailsLayout.setHorizontalGroup(
            appointmentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appointmentDetailsMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        appointmentDetailsLayout.setVerticalGroup(
            appointmentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appointmentDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appointmentDetailsMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        recordsPanel.setBackground(new java.awt.Color(255, 255, 255));

        recordsMenuBtn.setBackground(new java.awt.Color(255, 255, 255));
        sidebarBtnGrp.add(recordsMenuBtn);
        recordsMenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/records_unselect.png"))); // NOI18N
        recordsMenuBtn.setBorderPainted(false);
        recordsMenuBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/records_select.png"))); // NOI18N
        recordsMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordsMenuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout recordsPanelLayout = new javax.swing.GroupLayout(recordsPanel);
        recordsPanel.setLayout(recordsPanelLayout);
        recordsPanelLayout.setHorizontalGroup(
            recordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recordsMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        recordsPanelLayout.setVerticalGroup(
            recordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recordsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recordsMenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProfileCoverPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(diaryPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(motherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appointmentDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recordsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addComponent(ProfileCoverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(summaryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diaryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motherPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appointmentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recordsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        motherMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        firstNameText_Mother.setEditable(false);

        firstNameLabel_Mother.setText("First Name");

        personalLabel_Mother.setText("Personal:");

        medicalLabel_Mother.setText("Medical:");

        hospitalLabel_Mother.setText("Hospital");

        hospitalText_Mother.setEditable(false);

        doctorLabel_Mother.setText("Doctor");

        doctorText_Mother.setEditable(false);

        emailLabel_Mother.setText("Username");

        emailText_Mother.setEditable(false);

        dobLabel_Mother.setText("Date of Birth:");

        conceptionDateLabel_Mother.setText("Conception Date");

        asthmaCheckBox_Mother.setText("Asthma");
        asthmaCheckBox_Mother.setEnabled(false);
        asthmaCheckBox_Mother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asthmaCheckBox_MotherActionPerformed(evt);
            }
        });

        hivCheckBox_Mother.setText("HIV");
        hivCheckBox_Mother.setEnabled(false);
        hivCheckBox_Mother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hivCheckBox_MotherActionPerformed(evt);
            }
        });

        bloodGroupLabel_Mother.setText("Blood Group");

        bloodGroupComboBox_Mother.setModel(getBloodGroupListModel());
        bloodGroupComboBox_Mother.setEnabled(false);

        surnameLabel_Mother.setText("Surname");

        surnameText_Mother.setEditable(false);

        saveEditBtn_Mother.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/edit_btn.png"))); // NOI18N
        saveEditBtn_Mother.setBorder(null);
        saveEditBtn_Mother.setBorderPainted(false);
        saveEditBtn_Mother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditBtn_MotherActionPerformed(evt);
            }
        });

        conceptionDateChooser_Mother.setEnabled(false);

        dobDateChooser_Mother.setEnabled(false);

        javax.swing.GroupLayout motherMainPanelLayout = new javax.swing.GroupLayout(motherMainPanel);
        motherMainPanel.setLayout(motherMainPanelLayout);
        motherMainPanelLayout.setHorizontalGroup(
            motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motherMainPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicalLabel_Mother)
                    .addComponent(personalLabel_Mother))
                .addGap(0, 390, Short.MAX_VALUE))
            .addGroup(motherMainPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(motherMainPanelLayout.createSequentialGroup()
                        .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel_Mother)
                            .addComponent(dobLabel_Mother))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameText_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dobDateChooser_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(motherMainPanelLayout.createSequentialGroup()
                                .addComponent(emailLabel_Mother)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailText_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(motherMainPanelLayout.createSequentialGroup()
                                .addComponent(surnameLabel_Mother)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(surnameText_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(motherMainPanelLayout.createSequentialGroup()
                            .addComponent(hospitalLabel_Mother)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(hospitalText_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(doctorLabel_Mother)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(doctorText_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(motherMainPanelLayout.createSequentialGroup()
                            .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(conceptionDateLabel_Mother)
                                .addComponent(asthmaCheckBox_Mother))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(motherMainPanelLayout.createSequentialGroup()
                                    .addComponent(hivCheckBox_Mother)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bloodGroupLabel_Mother)
                                    .addGap(18, 18, 18)
                                    .addComponent(bloodGroupComboBox_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(motherMainPanelLayout.createSequentialGroup()
                                    .addComponent(conceptionDateChooser_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, motherMainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(saveEditBtn_Mother)
                .addGap(16, 16, 16))
        );
        motherMainPanelLayout.setVerticalGroup(
            motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motherMainPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(saveEditBtn_Mother)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(personalLabel_Mother)
                .addGap(33, 33, 33)
                .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameText_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameLabel_Mother)
                    .addComponent(surnameText_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLabel_Mother))
                .addGap(40, 40, 40)
                .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(motherMainPanelLayout.createSequentialGroup()
                        .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailText_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLabel_Mother)
                            .addComponent(dobLabel_Mother))
                        .addGap(57, 57, 57))
                    .addGroup(motherMainPanelLayout.createSequentialGroup()
                        .addComponent(dobDateChooser_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addComponent(medicalLabel_Mother)
                .addGap(24, 24, 24)
                .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(motherMainPanelLayout.createSequentialGroup()
                        .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hospitalText_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hospitalLabel_Mother)
                            .addComponent(doctorText_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doctorLabel_Mother))
                        .addGap(46, 46, 46)
                        .addComponent(conceptionDateLabel_Mother))
                    .addComponent(conceptionDateChooser_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(motherMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asthmaCheckBox_Mother)
                    .addComponent(hivCheckBox_Mother)
                    .addComponent(bloodGroupComboBox_Mother, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bloodGroupLabel_Mother))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        summaryMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("Summary:");

        summaryTextArea.setEditable(false);
        summaryTextArea.setColumns(20);
        summaryTextArea.setLineWrap(true);
        summaryTextArea.setRows(5);
        summaryTextArea.setWrapStyleWord(true);
        jScrollPane4.setViewportView(summaryTextArea);

        javax.swing.GroupLayout summaryMainPanelLayout = new javax.swing.GroupLayout(summaryMainPanel);
        summaryMainPanel.setLayout(summaryMainPanelLayout);
        summaryMainPanelLayout.setHorizontalGroup(
            summaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryMainPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(summaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(0, 301, Short.MAX_VALUE))
        );
        summaryMainPanelLayout.setVerticalGroup(
            summaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryMainPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        diaryMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        healthStatsLabel_Diary.setText("Health Stats:");

        weightLabel_Diary.setText("Weight (kg)");

        weightText_Diary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightText_DiaryActionPerformed(evt);
            }
        });

        bumpLabel_Diary.setText("Bump (cm)");

        bloodPressureLabel_Diary.setText("Blood Pressure");

        heightLabel_Diary.setText("Height (m)");

        heightText_Diary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightText_DiaryActionPerformed(evt);
            }
        });

        feelingLabel_Diary.setText("How are you feeling today?");

        feelingText_Diary.setColumns(20);
        feelingText_Diary.setLineWrap(true);
        feelingText_Diary.setRows(5);
        feelingText_Diary.setWrapStyleWord(true);
        feelingScrollPane_Diary.setViewportView(feelingText_Diary);

        saveBtn_Diary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/save_btn.png"))); // NOI18N
        saveBtn_Diary.setBorderPainted(false);
        saveBtn_Diary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtn_DiaryActionPerformed(evt);
            }
        });

        dateLabel_Diary.setText("Date: dd/mm/yy");

        javax.swing.GroupLayout diaryMainPanelLayout = new javax.swing.GroupLayout(diaryMainPanel);
        diaryMainPanel.setLayout(diaryMainPanelLayout);
        diaryMainPanelLayout.setHorizontalGroup(
            diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaryMainPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feelingLabel_Diary)
                    .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(saveBtn_Diary)
                        .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(feelingScrollPane_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthStatsLabel_Diary)))
                    .addGroup(diaryMainPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(diaryMainPanelLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(midSeparator_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(diaryMainPanelLayout.createSequentialGroup()
                                .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(diaryMainPanelLayout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(weightText_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(diaryMainPanelLayout.createSequentialGroup()
                                        .addComponent(bumpLabel_Diary)
                                        .addGap(24, 24, 24)
                                        .addComponent(bumpText_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(diaryMainPanelLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(heightLabel_Diary)
                                        .addGap(37, 37, 37))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diaryMainPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bloodPressureLabel_Diary)
                                        .addGap(18, 18, 18)))
                                .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(heightText_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bloodPressureText_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(diaryMainPanelLayout.createSequentialGroup()
                                .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateLabel_Diary, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(weightLabel_Diary, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(recordDateChooser_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(235, 381, Short.MAX_VALUE))
        );
        diaryMainPanelLayout.setVerticalGroup(
            diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaryMainPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(healthStatsLabel_Diary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateLabel_Diary)
                    .addComponent(recordDateChooser_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weightLabel_Diary)
                    .addComponent(weightText_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightText_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightLabel_Diary))
                .addGap(26, 26, 26)
                .addGroup(diaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bumpLabel_Diary)
                    .addComponent(bumpText_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bloodPressureText_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bloodPressureLabel_Diary))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(midSeparator_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(feelingLabel_Diary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feelingScrollPane_Diary, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(saveBtn_Diary)
                .addContainerGap(782, Short.MAX_VALUE))
        );

        appointmentsMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        appointmentsLabel_Appointments.setText("Appointments:");

        appointmentsTable_Appointments.setModel(new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){

                return false;

            }

        });
        jScrollPane1.setViewportView(appointmentsTable_Appointments);

        newAppointmentBtn_Appointments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/new_btn.png"))); // NOI18N
        newAppointmentBtn_Appointments.setBorderPainted(false);

        selectedAppointmentText_Appointments.setEditable(false);
        selectedAppointmentText_Appointments.setColumns(20);
        selectedAppointmentText_Appointments.setLineWrap(true);
        selectedAppointmentText_Appointments.setRows(5);
        jScrollPane2.setViewportView(selectedAppointmentText_Appointments);

        monthlyAppointmentList_Appointments.setModel(new DefaultListModel());
        jScrollPane3.setViewportView(monthlyAppointmentList_Appointments);

        monthlyAppointmentLabel_Appointments.setText("Show Appointments by Month:");

        deleteAppointmentBtn_Appointments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/delete_btn.png"))); // NOI18N
        deleteAppointmentBtn_Appointments.setBorderPainted(false);

        searchAppointmentText_Appointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAppointmentText_AppointmentsActionPerformed(evt);
            }
        });

        searchAppointmentBtn_Appointments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/search_btn.png"))); // NOI18N
        searchAppointmentBtn_Appointments.setBorderPainted(false);
        searchAppointmentBtn_Appointments.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/reset_btn.png"))); // NOI18N

        javax.swing.GroupLayout appointmentsMainPanelLayout = new javax.swing.GroupLayout(appointmentsMainPanel);
        appointmentsMainPanel.setLayout(appointmentsMainPanelLayout);
        appointmentsMainPanelLayout.setHorizontalGroup(
            appointmentsMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appointmentsMainPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(appointmentsMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(appointmentsMainPanelLayout.createSequentialGroup()
                        .addGroup(appointmentsMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addGroup(appointmentsMainPanelLayout.createSequentialGroup()
                                .addGroup(appointmentsMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(appointmentsLabel_Appointments)
                                    .addComponent(monthlyAppointmentLabel_Appointments))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(appointmentsMainPanelLayout.createSequentialGroup()
                        .addComponent(searchAppointmentText_Appointments)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchAppointmentBtn_Appointments)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteAppointmentBtn_Appointments)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newAppointmentBtn_Appointments)))
                .addGap(29, 29, 29))
        );
        appointmentsMainPanelLayout.setVerticalGroup(
            appointmentsMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentsMainPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(appointmentsMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newAppointmentBtn_Appointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteAppointmentBtn_Appointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchAppointmentBtn_Appointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchAppointmentText_Appointments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(appointmentsLabel_Appointments)
                .addGap(18, 18, 18)
                .addGroup(appointmentsMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(appointmentsMainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(14, 14, 14)
                        .addComponent(monthlyAppointmentLabel_Appointments)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recordsMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setText("Records:");

        javax.swing.GroupLayout recordsMainPanelLayout = new javax.swing.GroupLayout(recordsMainPanel);
        recordsMainPanel.setLayout(recordsMainPanelLayout);
        recordsMainPanelLayout.setHorizontalGroup(
            recordsMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordsMainPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel27)
                .addGap(0, 517, Short.MAX_VALUE))
        );
        recordsMainPanelLayout.setVerticalGroup(
            recordsMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordsMainPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel27)
                .addContainerGap(395, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(motherMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(summaryMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(diaryMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(appointmentsMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(recordsMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(motherMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(summaryMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(diaryMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(appointmentsMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(recordsMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1.setLayer(motherMainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(summaryMainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(diaryMainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(appointmentsMainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(recordsMainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pagePanelLayout = new javax.swing.GroupLayout(pagePanel);
        pagePanel.setLayout(pagePanelLayout);
        pagePanelLayout.setHorizontalGroup(
            pagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagePanelLayout.createSequentialGroup()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1))
        );
        pagePanelLayout.setVerticalGroup(
            pagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLayeredPane1)
        );

        jMenu3.setText("File");

        ExportMenu.setText("Export");
        jMenu3.add(ExportMenu);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pagePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Accessor to get the export menu
     * @return Export Menu
     */
    public JMenu getExportMenu(){
            return ExportMenu;
}
    
    //EditSave button check
    private boolean saveEditState;
    
    public static final boolean EDIT_STATE = true;
    public static final boolean SAVE_STATE = false;
    
    /**
     * Accessor to get the save/edit boolean
     * @return A boolean variable to show whether in save or edit mode
     */
    public boolean getSaveEditState(){
        return saveEditState;
    }

    /**
     * Mutator method to set the save/edit state
     * @param state Save/Edit state
     */
    public void setSaveEditState(boolean state){
        this.saveEditState = state;
    }
    
    private final ImageIcon EDIT_ICON = (new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/edit_btn.png")));
    private final ImageIcon SAVE_ICON = (new javax.swing.ImageIcon(getClass().getResource("/pregnancydiary/images/save_btn.png")));
    
    /**
     * Accessor to get the Edit Icon
     * @return Edit Icon
     */
    public ImageIcon getEditIcon(){
        return EDIT_ICON;
    }
    
    /**
     * Accessor to get the save icon
     * @return Save Icon
     */
    public ImageIcon getSaveIcon(){
        return SAVE_ICON;
    }
    
    //accessors: getters for buttons
    /**
     * Accessor method to get the summary menu button
     * @return Summary Menu Button
     */
     public JToggleButton getSummaryMenuBtn(){
        return summaryMenuBtn;
    }
     /**
      * Accessor method to return the Diary Menu Button
      * @return Diary Menu Button
      */
     public JToggleButton getDiaryMenuBtn() {
         return diaryMenuBtn;
     }
     
     /**
      * Accessor method to get the Mother Menu Button
      * @return Mother Menu Button
      */
     public JToggleButton getMotherMenuBtn() {
         return motherMenuBtn;
     }

     /**
      * Accessor method to get Appointments Details Menu Button
      * @return Appointments Details Menu Button
      */
     public JToggleButton getAppointmentDetailsMenuBtn() {
         return appointmentDetailsMenuBtn;
     }
     
     /**
      * Accessor method to get the Records Menu Button
      * @return Records Menu Button
      */
     public JToggleButton getRecordsMenuBtn() {
         return recordsMenuBtn;
     }
     
     /**
      * Accessor method to get the Save/Edit Button
      * @return Save/Edit Button
      */
     public JButton getSaveEditBtn_Mother(){
         return saveEditBtn_Mother;
     }
     
     /**
      * Accessor method for the Save Diary Button
      * @return Save Button
      */
     public JButton getSaveBtn_Diary(){
         return saveBtn_Diary;
     }
     
     /**
      * Accessor method to get new Appointments Button
      * @return new Appointments Button
      */
     public JButton getNewAppointmentBtn_Appointments(){
         return newAppointmentBtn_Appointments;
     }
     
     //accessors: main panels
     /**
      * Accessor method to get the Main Application Panel
      * @return 
      */
     public JPanel getMotherMainPanel(){
         return motherMainPanel;
     }
     
     /**
      * Accessor method to get the Diary Panel
      * @return Diary Panel
      */
     public JPanel getDiaryMainPanel(){
         return diaryMainPanel;
     }
     
          
      /**
      * Accessor method to get the Summary Panel
      * @return Summary Panel
      */
     public JPanel getSummaryMainPanel(){
         return summaryMainPanel;
     }
     
     /**
      * Accessor method to get the Appointments Panel
      * @return 
      */
     public JPanel getAppointmentsMainPanel(){
         return appointmentsMainPanel;
     }
     /**
      * Accessor method to get the Records Panel
      * @return Records Panel
      */
     public JPanel getRecordsMainPanel(){
         return recordsMainPanel;
     }
     
     //accessors: text fields + checkbox + combobox + lists + tables
     //Mother
     /**
      * Accessor method to get the first name text box
      * @return First name text box
      */
     public JTextField getFirstNameText_Mother(){
         return firstNameText_Mother;
     }
     /**
      * Accessor method to get the surname text box
      * @return Surname text box
      */
     public JTextField getSurnameText_Mother(){
         return surnameText_Mother;
     }
     
     /**
      * Accessor method to get the date of birth date chooser
      * @return Date of birth date chooser
      */
     public JDateChooser getDobDateChooser_Mother(){
         return dobDateChooser_Mother;
     }
     
     /**
      * Accessor method to get the email text box
      * @return the email text box
      */
     public JTextField getEmailText_Mother(){
         return emailText_Mother;
     }
     /**
      * Accessor to get the hospital text box
      * @return hospital text box
      */
     public JTextField getHospitalText_Mother(){
         return hospitalText_Mother;
     }
     /**
      * Accessor method to get the doctor text box
      * @return the doctor text box
      */
     public JTextField getDoctorText_Mother(){
         return doctorText_Mother;
     }
      /**
      * Accessor method to get the conception date chooser
      * @return Date of birth date chooser
      */
     public JDateChooser getConceptionDateChooser_Mother(){
         return conceptionDateChooser_Mother;
     }
     /**
      * Accessor method to get the asthma check box
      * @return the asthma check box
      */
     public JCheckBox getAsthmaCheckBox_Mother(){
         return asthmaCheckBox_Mother;
     }
     /**
      * Accessor method to get the HIV check box
      * @return the HIV check box
      */
     public JCheckBox getHivCheckBox_Mother(){
         return hivCheckBox_Mother;
     }
     /**
      * Accessor method to get the blood group combo box
      * @return the blood group combo box
      */
     public JComboBox getBloodGroupComboBox_Mother(){
         return bloodGroupComboBox_Mother;
     }
     
     //appointments
     /**
      * Accessor to get the appointment text box
      * @return the appointments text box
      */
     public JTextArea getSelectedAppointmentText_Appointments(){
         return selectedAppointmentText_Appointments;
     }
     /**
      * Accessor to get the monthly appointments list
      * @return Monthly Appointments List
      */
     public JList getMonthlyAppointmentList_Appointments(){
         return monthlyAppointmentList_Appointments;
     }
     
     /**
      * Accessor to get the appointments table
      * @return appointments table
      */
    public JTable getAppointsmentTable_Appointments(){
         return appointmentsTable_Appointments;
     }
    
    //appointments dialog
    /**
     * Accessor to get the add button on the appointments dialog
     * @return add button
     */
    public JButton getAddBtn_AppointmentsDialog(){
        return addBtn_AppointmentsDialog;
    }
    /**
     * Accessor to return the appointment purpose text box
     * @return appointment purpose text box
     */
    public JTextField getPurposeText_AppointmentsDialog(){
        return purposeText_AppointmentsDialog;
    }
    
    /**
     * Accessor to return the appointment hospital text box
     * @return appointment hospital text box
     */
    public JTextField getHospitalText_AppointmentsDialog(){
        return hospitalText_AppointmentsDialog;
    }
    /**
     * Accessor to return the appointment doctor text box
     * @return appointment doctor text box
     */
    public JTextField getDoctorText_AppointmentsDialog(){
        return doctorText_AppointmentsDialog;
    }
    /**
     * Accessor to return the appointment date text box
     * @return appointment date text box
     */
    public JDateChooser getDateDate_AppointmentsDialog(){
        return dateDate_AppointmentsDialog;
    }
    /**
     * Accessor to return the appointment time combo box
     * @return appointment time combo box
     */
    public JComboBox getTimeCombo_AppointmentsDialog(){
        return timeCombo_AppointmentsDialog;
    }
             
             
     
     //Diary
    /**
     * Accessor to get the weight text box
     * @return weight text box
     */
     public JTextField getWeightText_Diary(){
         return weightText_Diary;
     }
     /**
     * Accessor to get the height text box
     * @return height text box
     */
     public JTextField getHeightText_Diary(){
         return heightText_Diary;
     }
     /**
     * Accessor to get the stomach bump size text box
     * @return stomach bump size text box
     */
     public JTextField getBumpText_Diary(){
         return bumpText_Diary;
     }
     /**
     * Accessor to get the blood pressure text box
     * @return blood pressure text box
     */
     public JTextField getBloodPressureText_Diary(){
         return bloodPressureText_Diary;
     }
     /**
      * Accessor method to get the general feeling text box
      * @return general feeling text box
      */
     public JTextArea getFeelingText_Diary(){
         return feelingText_Diary;
     }
     /**
      * Accessor method to get the record date chooser
      * @return Record date chooser
      */
    public JDateChooser getRecordDateChooser_Diary(){
         return recordDateChooser_Diary;
     }
    
    //public JToggleButton get
    
    //accessors: cover
    /**
     * Accessor to get the Mother Name Cover Label
     * @return Mother Name Cover Label
     */
    public JLabel getMotherNameLabel_Cover(){
        return motherNameLabel_Cover;
    }
    /**
     * Accessor to get the date cover label
     * @return Date cover label
     */
    public JLabel getDateLabel_Cover(){
        return dateLabel_Cover;
    }
    /**
     * Accessor to get the weeks left cover label
     * @return Weeks Left Cover Label
     */
    public JLabel getWeeksLeftLabel_Cover(){
        return weeksLeftLabel_Cover;
    }
    
     
     //
     
    private void summaryMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summaryMenuBtnActionPerformed
        // TODO add your handling code here:
       /* motherMainPanel.setVisible(false);
        diaryMainPanel.setVisible(false);
        summaryMainPanel.setVisible(true);
        appointmentsMainPanel.setVisible(false);
        recordsMainPanel.setVisible(false);*/
    }//GEN-LAST:event_summaryMenuBtnActionPerformed

    private void diaryMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaryMenuBtnActionPerformed
        // TODO add your handling code here:
        motherMainPanel.setVisible(false);
        diaryMainPanel.setVisible(true);
        summaryMainPanel.setVisible(false);
        appointmentsMainPanel.setVisible(false);
        recordsMainPanel.setVisible(false);
    }//GEN-LAST:event_diaryMenuBtnActionPerformed

    private void motherMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motherMenuBtnActionPerformed
        // TODO add your handling code here:
        motherMainPanel.setVisible(true);
        diaryMainPanel.setVisible(false);
        summaryMainPanel.setVisible(false);
        appointmentsMainPanel.setVisible(false);
        recordsMainPanel.setVisible(false);

    }//GEN-LAST:event_motherMenuBtnActionPerformed

    private void appointmentDetailsMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentDetailsMenuBtnActionPerformed
        // TODO add your handling code here:
        motherMainPanel.setVisible(false);
        diaryMainPanel.setVisible(false);
        summaryMainPanel.setVisible(false);
        appointmentsMainPanel.setVisible(true);
        recordsMainPanel.setVisible(false);
    }//GEN-LAST:event_appointmentDetailsMenuBtnActionPerformed

    private void recordsMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordsMenuBtnActionPerformed
        // TODO add your handling code here:
        motherMainPanel.setVisible(false);
        diaryMainPanel.setVisible(false);
        summaryMainPanel.setVisible(false);
        appointmentsMainPanel.setVisible(false);
        recordsMainPanel.setVisible(true);
        
    }//GEN-LAST:event_recordsMenuBtnActionPerformed

    private void hivCheckBox_MotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hivCheckBox_MotherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hivCheckBox_MotherActionPerformed

    private void asthmaCheckBox_MotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asthmaCheckBox_MotherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asthmaCheckBox_MotherActionPerformed

    private void saveEditBtn_MotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditBtn_MotherActionPerformed
        // TODO add your handling code here:
        /*if (saveEditBtn_Mother.getText().equalsIgnoreCase("Edit")){
            saveEditBtn_Mother.setText("Save");
            firstNameText_Mother.setEditable(true);
            surnameText_Mother.setEditable(true);
            dayText_Mother.setEditable(true);
            monthText_Mother.setEditable(true);
            yearText_Mother.setEditable(true);

            emailText_Mother.setEditable(true);
            hospitalText_Mother.setEditable(true);
            doctorText_Mother.setEditable(true); 
            conceptionDateChooser_Mother.setEnabled(true);
        }
        
        else if (saveEditBtn_Mother.getText().equalsIgnoreCase("Save")) {
            saveEditBtn_Mother.setText("Edit");
            firstNameText_Mother.setEditable(false);
            surnameText_Mother.setEditable(false);
            dayText_Mother.setEditable(false);
            monthText_Mother.setEditable(false);
            yearText_Mother.setEditable(false);
            emailText_Mother.setEditable(false);
            hospitalText_Mother.setEditable(false);
            doctorText_Mother.setEditable(false);
            conceptionDateChooser_Mother.setEnabled(false);
        } */
    }//GEN-LAST:event_saveEditBtn_MotherActionPerformed

    private void heightText_DiaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightText_DiaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heightText_DiaryActionPerformed

    private void weightText_DiaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightText_DiaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightText_DiaryActionPerformed

    private void saveBtn_DiaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn_DiaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtn_DiaryActionPerformed

    private void hospitalText_AppointmentsDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hospitalText_AppointmentsDialogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hospitalText_AppointmentsDialogActionPerformed

    private void searchAppointmentText_AppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAppointmentText_AppointmentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchAppointmentText_AppointmentsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
        
        
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
           // for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               // if ("Nimbus".equals(info.getName())) {
                    //cross platform: Metal
                    //javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
                    //System L&F
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

                 //   break;
                //}
          //  }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /**
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ExportMenu;
    private javax.swing.JPanel ProfileCoverPanel;
    private javax.swing.JButton addBtn_AppointmentsDialog;
    private javax.swing.JPanel appointmentDetails;
    private javax.swing.JToggleButton appointmentDetailsMenuBtn;
    private javax.swing.JLabel appointmentsLabel_Appointments;
    private javax.swing.JPanel appointmentsMainPanel;
    private javax.swing.JTable appointmentsTable_Appointments;
    private javax.swing.JCheckBox asthmaCheckBox_Mother;
    private javax.swing.JComboBox bloodGroupComboBox_Mother;
    private javax.swing.JLabel bloodGroupLabel_Mother;
    private javax.swing.JLabel bloodPressureLabel_Diary;
    private javax.swing.JTextField bloodPressureText_Diary;
    private javax.swing.JLabel bumpLabel_Diary;
    private javax.swing.JTextField bumpText_Diary;
    private com.toedter.calendar.JDateChooser conceptionDateChooser_Mother;
    private javax.swing.JLabel conceptionDateLabel_Mother;
    private javax.swing.JLabel coverIcon_Cover;
    private com.toedter.calendar.JDateChooser dateDate_AppointmentsDialog;
    private javax.swing.JLabel dateLabel_AppointmentsDialog;
    private javax.swing.JLabel dateLabel_Cover;
    private javax.swing.JLabel dateLabel_Diary;
    private javax.swing.JButton deleteAppointmentBtn_Appointments;
    private javax.swing.JPanel diaryMainPanel;
    private javax.swing.JToggleButton diaryMenuBtn;
    private javax.swing.JPanel diaryPanel;
    private com.toedter.calendar.JDateChooser dobDateChooser_Mother;
    private javax.swing.JLabel dobLabel_Mother;
    private javax.swing.JLabel doctorLabel_AppointmentsDialog;
    private javax.swing.JLabel doctorLabel_Mother;
    private javax.swing.JTextField doctorText_AppointmentsDialog;
    private javax.swing.JTextField doctorText_Mother;
    private javax.swing.JLabel emailLabel_Mother;
    private javax.swing.JTextField emailText_Mother;
    private javax.swing.JDialog error;
    private javax.swing.JButton errorOkayBtn;
    private javax.swing.JLabel feelingLabel_Diary;
    private javax.swing.JScrollPane feelingScrollPane_Diary;
    private javax.swing.JTextArea feelingText_Diary;
    private javax.swing.JLabel firstNameLabel_Mother;
    private javax.swing.JTextField firstNameText_Mother;
    private javax.swing.JLabel healthStatsLabel_Diary;
    private javax.swing.JLabel heightLabel_Diary;
    private javax.swing.JTextField heightText_Diary;
    private javax.swing.JCheckBox hivCheckBox_Mother;
    private javax.swing.JLabel hospitalLabel_AppointmentsDialog;
    private javax.swing.JLabel hospitalLabel_Mother;
    private javax.swing.JTextField hospitalText_AppointmentsDialog;
    private javax.swing.JTextField hospitalText_Mother;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel medicalLabel_Mother;
    private javax.swing.JSeparator midSeparator_Diary;
    private javax.swing.JLabel monthlyAppointmentLabel_Appointments;
    private javax.swing.JList monthlyAppointmentList_Appointments;
    private javax.swing.JPanel motherMainPanel;
    private javax.swing.JToggleButton motherMenuBtn;
    private javax.swing.JLabel motherNameLabel_Cover;
    private javax.swing.JPanel motherPanel;
    private javax.swing.JButton newAppointmentBtn_Appointments;
    private javax.swing.JDialog newAppointmentDialog_Appointments;
    private javax.swing.JPanel pagePanel;
    private javax.swing.JLabel personalLabel_Mother;
    private javax.swing.JLabel purposeLabel_AppointmentsDialog;
    private javax.swing.JTextField purposeText_AppointmentsDialog;
    private com.toedter.calendar.JDateChooser recordDateChooser_Diary;
    private javax.swing.JPanel recordsMainPanel;
    private javax.swing.JToggleButton recordsMenuBtn;
    private javax.swing.JPanel recordsPanel;
    private javax.swing.JButton saveBtn_Diary;
    private javax.swing.JButton saveEditBtn_Mother;
    private javax.swing.JToggleButton searchAppointmentBtn_Appointments;
    private javax.swing.JTextField searchAppointmentText_Appointments;
    private javax.swing.JTextArea selectedAppointmentText_Appointments;
    private javax.swing.ButtonGroup sidebarBtnGrp;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel summaryMainPanel;
    private javax.swing.JToggleButton summaryMenuBtn;
    private javax.swing.JPanel summaryPanel;
    private javax.swing.JTextArea summaryTextArea;
    private javax.swing.JLabel surnameLabel_Mother;
    private javax.swing.JTextField surnameText_Mother;
    private javax.swing.JComboBox timeCombo_AppointmentsDialog;
    private javax.swing.JLabel timeLabel_AppointmentsDialog;
    private javax.swing.JLabel weeksLeftLabel_Cover;
    private javax.swing.JLabel weightLabel_Diary;
    private javax.swing.JTextField weightText_Diary;
    // End of variables declaration//GEN-END:variables
}
