/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregnancydiary.models;

import java.sql.Date;

/**
 *
 * @author michaelannor
 */

public class Appointment {
    private Mother mother;
    private Date date;
    private String purpose;
    private String hospital;
    private String doctor;
    private String time;
    private int month;
    private int id;
    
    public static final String MORNING_TIME_STRING = "Morning";
    public static final String AFTERNOON_TIME_STRING = "Afternoon";
    public static final String EVENING_TIME_STRING = "Evening";
    
    
    /**
     * A constructor method for the Appointment class
     * @param mother Mother object who the appointment will be assigned to
     * @param date The date for the appointment
     * @param purpose A description of the purpose of the appointment
     * @param hospital The hospital location of the appointment
     * @param doctor The doctor who the appointment is with
     * @param time The time of the appointment
     * @param month The month of the appointment
     * @param id The appointment id
     */
    public Appointment(Mother mother, Date date, String purpose, String hospital, String doctor, String time, int month, int id){
        this.mother = mother;
        this.date = date;
        this.purpose = purpose;
        this.hospital = hospital;
        this.doctor = doctor;
        this.time = time;
        this.month = month;
        this.id = id;
    }
    
    /**
     * A constructor method for the Appointment class
     * @param mother Mother object who the appointment will be assigned to
     * @param date The date for the appointment
     * @param purpose A description of the purpose of the appointment
     * @param hospital The hospital location of the appointment
     * @param doctor The doctor who the appointment is with
     * @param time The time of the appointment
     */
     public Appointment(Mother mother, Date date, String purpose, String hospital, String doctor, String time){
        this.mother = mother;
        this.date = date;
        this.purpose = purpose;
        this.hospital = hospital;
        this.doctor = doctor;
        this.time = time;
    }
    
    //accessors: getters:
     
     /**
      * An accessor method for the Appointment class
      * @return The date of the appointment
      */
    public Date getDate(){
        return date;
    }
    
    /**
     * An accessor method for the Appointment class
     * @return The month of the appointment
     */
    public int getMonth(){
        return month;
    }
    /**
     * An accessor method for the Appointment class
     * @return The id of the appointment
     */
    public int getID(){
        return id;
    }
    
    /**
     * An accessor method for the Appointment class
     * @return Mother object who the appointment will be assigned to
     */
    public Mother getMother(){
        return mother;
    }
    
    /**
     * An accessor method for the Appointment class
     * @return The purpose of the appointment
     */
    public String getPurpose(){
        return purpose;
    }
    
    /**
     * An accessor method for the Appointment class
     * @return The hospital of the appointment
     */
    public String getHospital(){
        return hospital;
    }
    /**
     * An accessor method for the Appointment class
     * @return The doctor the appointment is with
     */
    public String getDoctor(){
        return doctor;
    }
    /**
     * An accessor method for the Appointment class
     * @return The time of the appointment
     */
    public String getTime(){
        return time;
    }
    
    //mutators: setters
    
    /**
     * A mutator method for the Appointment class
     * @param date The date of the appointment
     */
    public void setDate(Date date){
        this.date = date;
    }
    
    /**
     * A mutator method for the Appointment class
     * @param mother The mother object who the appointment will be assigned to
     */
    public void setMother(Mother mother){
        this.mother = mother;
    }
    
    /**
     * A mutator method for the Appointment class
     * @param month The month of the appointment
     */
    public void setMonth(int month){
        this.month = month;
    }
    
    /**
     * A mutator method for the Appointment class
     * @param id The id of the appointment
     */
    public void setID(int id){
        this.id = id;
    }
    
    /**
     * A mutator method for the Appointment class
     * @param purpose The purpose of the appointment
     */
    public void setPurpose(String purpose){
        this.purpose = purpose;
    }
    
    /**
     * A mutator method for the Appointment class
     * @param hospital The hospital of the appointment
     */
    public void setHospital(String hospital){
        this.hospital = hospital;
    }
    
    /**
     * A mutator method for the Appointment class
     * @param doctor The doctor the appointment is with
     */
    public void setDoctor(String doctor){
        this.doctor = doctor;
    }
    
    /**
     * A mutator method for the Appointment class
     * @param time The time of the appointment
     */
    public void setTime(String time){
        this.time = time;
    }
    
}
