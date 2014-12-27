/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregnancydiary.models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;
import pregnancydiary.controllers.Controller;

/**
 *
 * @author michaelannor
 */
public class AppointmentCRUD {
    
    /**
     * A method to issue a query to get all the items from the Appointments table in the database
     */
    public void listAll(){
 try {
  java.sql.Statement s = Controller.conn.createStatement();
  java.sql.ResultSet r = s.executeQuery("SELECT * FROM Appointments");
  while(r.next()) {
   System.out.println (   
    //r.getInt("mother_id") + " \t" +
    r.getString("appointmentId") + " \t" +
    r.getDate("date") + " \t" +
    r.getString("purpose") + " \t" +
    r.getString("hospital") + " \t" +
    r.getString("doctor" ) + " \t" +
    r.getString("time" )
   );
  }
 }
 catch (Exception e) {
  System.out.println("Error" + e.toString());
  //System.exit(0);
 }
}
    /**
     * A method to issue a query to get all the items from the Appointments table in the database for a specific appointment
     * @param id The id to identify the Appointment to return from the database
     * @return A mother object created from the data retrieved from the database
     */
   public Mother findSpecific(String id){
       Mother mum = null;
         try {
             PreparedStatement p= Controller.conn.prepareStatement("SELECT * FROM Appointments WHERE id");

  
    p.setString(1, id);
    
    java.sql.ResultSet r = p.executeQuery();
  while(r.next()) {
      System.out.println("hello Obedience");
           mum = new Mother(r.getString("username"), r.getString("firstname"), r.getString("surname"),
           r.getDate("dateOfBirth"), r.getString("password"), (new Medical(r.getString("hospital"), 
                   r.getString("doctor"), r.getDate("conceptionDate"), r.getBoolean("hasAsthma"), 
                   r.getBoolean("hasHiv"), r.getString("bloodGroup"))));
           
  }
  
 }
 catch (Exception e) {
  System.out.println("Error" + e.toString());
  System.out.println("Wrong Details");
  //System.exit(0);

 }
                     System.out.println("Mum: " + mum);

           return mum;
    }

   /**
    * A method to issue a query to add an Appointment to the database
    * @param appointment The appointment object containing the details to add to the database
    */
public void addAppointment(Appointment appointment){
        //int id, string fn, string ln, int age, int telno
 try{
    PreparedStatement p= Controller.conn.prepareStatement("Insert Into Appointments set date=?, "
            + "purpose=?, hospital=? ,doctor =?, time =?, mother =?, month =?");
    p.setDate(1, appointment.getDate());
    p.setString(2, appointment.getPurpose());
    p.setString(3, appointment.getHospital());
    p.setString(4, appointment.getDoctor());
    p.setString(5, appointment.getTime() );
    p.setString(6, appointment.getMother().getMotherUsername());
    
    Calendar cal = Calendar.getInstance();
    cal.setTime(appointment.getDate());
    int month = cal.get(Calendar.MONTH) +1;
    
    p.setInt(7, month);
    
    p.execute();  //use execute if no results expected back
    }catch(Exception e){
        System.out.println("Error"+e.toString());
        //dialog
        return;        
    }
}

/**
 * A method to issue a query to get all the months of the year with appointments in the database
 * @param mother The mother whose appointments to retrieve
 * @return A HashMap containing the months with appointments in the database
 */
public HashMap<Integer, Integer> getMonths(Mother mother){
    
    HashMap<Integer, Integer> monthMap = new HashMap<Integer, Integer>();
    //Put "all" first
    int all = 0;
    monthMap.put(all, all);
    
    try {
             PreparedStatement p= Controller.conn.prepareStatement("SELECT month FROM Appointments WHERE mother =?");

  
    p.setString(1, mother.toString());
    
    java.sql.ResultSet r = p.executeQuery();

  
  while(r.next()) {
      System.out.println("Fetching months from Database");
      monthMap.put(r.getInt("month"), r.getInt("month"));
  }
 }
 catch (Exception e) {
  System.out.println("Error" + e.toString());
  //System.exit(0);
 }
  return monthMap;  
}

/**
 * A method to issue a query to get all the items from the Appointments table in the database in a given month
 * @param month The month to use to retrieve appointments from the database
 * @param mother The mother whose appointments to retrieve
 * @return A vector containing appointments from the query
 */
public Vector<Appointment> getAppointments(String month, Mother mother){
    int monthNum = 0;
    Vector<Appointment> appointmentVector = new Vector();
    boolean all = false;
   if (month == "All"){
       monthNum = 0;
       all = true;
   }
   else if (month == "January"){
       monthNum = 1;
   }
   else if (month == "February"){
       monthNum = 2;
   }
   else if (month == "March"){
       monthNum = 3;
   }
   else if (month == "April"){
       monthNum = 4;
   }
   else if (month == "May"){
       monthNum = 5;
   }
   else if (month == "June"){
       monthNum = 6;
   }
   else if (month == "July"){
       monthNum = 7;
   }
   else if (month == "August"){
       monthNum = 8;
   }
   else if (month == "September"){
       monthNum = 9;
   }
   else if (month == "October"){
       monthNum = 10;
   }
   else if (month == "November"){
       monthNum = 11;
   }
   else if (month == "December"){
       monthNum = 12;
   }
    
   PreparedStatement p;
    
    try {
        if (all == true){
             p= Controller.conn.prepareStatement(
                     "SELECT * FROM Appointments WHERE mother =?");
             p.setString(1, mother.toString());
        }
        
        else{
  p= Controller.conn.prepareStatement(
                     "SELECT * FROM Appointments WHERE mother =? AND month =?");
        
    p.setString(1, mother.toString());
    p.setInt(2, monthNum);
        }
        
    java.sql.ResultSet r = p.executeQuery();

  
  while(r.next()) {
      System.out.println("Fetching appts. from Database");
            
      Appointment apt = new Appointment(mother, r.getDate("date"), r.getString("purpose"),
      r.getString("hospital"),r.getString("doctor"),r.getString("time"),r.getInt("month"), r.getInt("appointmentID"));
      
      appointmentVector.add(apt);
  }
 }
 catch (Exception e) {
  System.out.println("Error" + e.toString());
  //System.exit(0);
 }
    
    return appointmentVector;
}

/**
 * A method to issue a query to delete an appointment record in the database
 * @param id The Appointment id to identify the record to delete from the database
 */
public void deleteAppointment(int id){
    
 try{
    PreparedStatement p= Controller.conn.prepareStatement("Delete from Appointments Where appointmentID=?");
    p.setInt(1, id);
    p.execute();  //use execute if no results expected back
    
    
    }catch(Exception e){
        System.out.println("Error"+e.toString());
        //dialog
        return;        
    }
}





    
}
