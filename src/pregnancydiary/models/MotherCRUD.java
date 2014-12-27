/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregnancydiary.models;

import java.sql.PreparedStatement;
import java.sql.*;
import pregnancydiary.controllers.Controller;
/**
 *
 * @author michaelannor
 */
public class MotherCRUD {
    
    //java.sql.Connection conn = null;
/**
 * Method to issue a query to the database to get all the mothers
 */
    public void listAll(){
 try {
  java.sql.Statement s = Controller.conn.createStatement();
  java.sql.ResultSet r = s.executeQuery("SELECT * FROM Mothers");
  while(r.next()) {
   System.out.println (   
    //r.getInt("mother_id") + " \t" +
    r.getString("firstname") + " \t" +
    r.getDate("lastname") + " \t" +
    r.getString("dateOfBirth") + " \t" +
    r.getString("username") + " \t" +
    r.getString("hospital" ) + " \t" +
    r.getString("doctor" ) + " \t" +
    r.getDate("conception_date" ) + " \t" +
    r.getBoolean("asthma" ) + " \t" +
    r.getBoolean("hiv" ) + " \t" +
    r.getString("bloodgroup")
   );
  }
 }
 catch (Exception e) {
  System.out.println("Error" + e.toString());
  //System.exit(0);
 }
}
    
    /**
     * Method to issue a query to the database to verify login details
     * @param user The username
     * @param pass The password
     * @return Return a mother object if successful or null if otherwise
     */
   public Mother confirmLogin(String user, String pass){
       Mother mum = null;
         try {
             PreparedStatement p= Controller.conn.prepareStatement("SELECT * FROM Mothers WHERE username =? AND password=?");

  
    p.setString(1, user);
    p.setString(2, pass);
    
    java.sql.ResultSet r = p.executeQuery();
  while(r.next()) {
      System.out.println("hello Obed");
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
    * Method to add a mother record to the database
    * @param mother Mother object
    */
public void addMother(Mother mother){
        //int id, string fn, string ln, int age, int telno
 try{
    PreparedStatement p= Controller.conn.prepareStatement("Insert Into Mothers set password=?, "
            + "firstName=?, surname=? ,dateOfbirth =?, username =?, gender =?, hospital =?,"
            + " doctor =?, conceptionDate =?, hasAsthma =?, hasHiv =?, bloodgroup =?");
    p.setString(1, mother.getPassword());
    p.setString(2, mother.getFirstName());
    p.setString(3, mother.getSurname());
    p.setDate(4, mother.getDateOfBirth());
    p.setString(5, mother.getMotherUsername() );
    p.setString(6, (mother.getGender() + "") );
    p.setString(7, mother.getMedicalInfo().getHospital() );
    p.setString(8, mother.getMedicalInfo().getDoctor() );
    p.setDate(9, mother.getMedicalInfo().getConceptionDate() );
    p.setBoolean(10, mother.getMedicalInfo().getAsthma() );
    p.setBoolean(11, mother.getMedicalInfo().getHiv() );
    p.setString(12, mother.getMedicalInfo().getBloodGroup() );
p.execute();  //use execute if no results expected back
    }catch(Exception e){
        System.out.println("Error"+e.toString());
        //dialog
        return;        
    }
}

/**
 * Method to update a mother's details in the database
 * @param mother Mother object
 */
public void updateMother(Mother mother){
    String oldKey = mother.getMotherUsername();
      
    try{
    PreparedStatement p= Controller.conn.prepareStatement("Update Mothers set firstName=?, "
            + "surname=? ,dateOfbirth =?, username =?, gender =?, hospital =?,"
            + " doctor =?, conceptionDate =?, hasAsthma =?, hasHiv =?, bloodgroup =? Where username=?");
    p.setString(1, mother.getFirstName());
    p.setString(2, mother.getSurname());
    p.setDate(3, mother.getDateOfBirth());
    p.setString(4, mother.getMotherUsername() );
    p.setString(5, (mother.getGender() + "") );
    p.setString(6, mother.getMedicalInfo().getHospital() );
    p.setString(7, mother.getMedicalInfo().getDoctor() );
    p.setDate(8, mother.getMedicalInfo().getConceptionDate() );
    p.setBoolean(9, mother.getMedicalInfo().getAsthma() );
    p.setBoolean(10, mother.getMedicalInfo().getHiv() );
    p.setString(11, mother.getMedicalInfo().getBloodGroup() );

    //figure out how to do where:
    p.setString(12, oldKey);
    p.execute();  //use execute if no results expected back
    }catch(Exception e){
        System.out.println("Error"+e.toString());
        //dialog
        return;        
    }
    
}
/**
 * Method to get a mother's conception date from the database
 * @param mother Mother object
 * @return The conception date
 */
public Date getConceptionDate(Mother mother){
    try{
        
         PreparedStatement p= Controller.conn.prepareStatement("SELECT * FROM Mothers WHERE username =?");

  
    p.setString(1, mother.getMotherUsername());
    
    java.sql.ResultSet r = p.executeQuery();
  while(r.next()) {
           return r.getDate("conceptionDate"); 
  }
  
    }
    catch (Exception e){
        System.out.println("Exception: " + e);
    }
    
    return null;
}


/**
 * A method to delete a mother from the database
 * @param mother Mother object
 */
public void deleteMother(Mother mother){
    
 try{
    PreparedStatement p= Controller.conn.prepareStatement("Delete from Mothers Where username=?");
    p.setString(1, mother.getMotherUsername());
    p.execute();  //use execute if no results expected back
    
    
    }catch(Exception e){
        System.out.println("Error"+e.toString());
        //dialog
        return;        
    }
}


    
}
