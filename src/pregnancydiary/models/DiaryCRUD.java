package pregnancydiary.models;


import java.sql.PreparedStatement;
import pregnancydiary.controllers.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author michaelannor
 */
public class DiaryCRUD {
    
    /**
     * A method to issue a query to add a diary record to the Diary table in the database
     * @param diary The diary object containing the items in the daily log
     */
    public void addDiary(PregnancyRecords diary){
        //int id, string fn, string ln, int age, int telno
 try{
    PreparedStatement p= Controller.conn.prepareStatement("Insert Into Diary set date=?, "
            + "weight=?, height=? ,bmi =?, bmIExplanation =?, babyBump =?, bloodPressure =?, "
            + "generalFeeling =?, mother =?");
    p.setDate(1, diary.getDateRecord());
    p.setDouble(2, diary.getStatsRecord().getWeight());
    p.setDouble(3, diary.getStatsRecord().getHeight());
    p.setDouble(4, diary.getStatsRecord().getBodyMassIndex());
    p.setString(5, diary.getStatsRecord().getBmiExplanation() );
    p.setDouble(6, diary.getStatsRecord().getBumpSize());
    p.setString(7, diary.getStatsRecord().getBloodPressure() + "");
    p.setString(8, diary.getStatsRecord().getGeneralFeel());
    p.setString(9, diary.getMother().getMotherUsername());
    
    p.execute();  //use execute if no results expected back
    }catch(Exception e){
        System.out.println("Error"+e.toString());
        System.out.println("You already have an entry for this day");
        //dialog
        return;        
    }
}
    
}
