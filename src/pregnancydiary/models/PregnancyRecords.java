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
public class PregnancyRecords {
    
        
	
	private Date dateRecord;
	//private DailyLog diaryRecord;
	private HealthStats statsRecord;
	//private Diet foodRecord; //might take out diet
	private Mother mother;

	//constructor
	public PregnancyRecords(Mother mum, Date date, HealthStats stats){
		mother = mum;
                
		dateRecord = date;
		//diaryRecord = diary;
		statsRecord = stats;
		//foodRecord = food;
		//get date: day month year: check API
	}

	//accesors: getters
	public Date getDateRecord(){
		return dateRecord;
	}

	public Mother getMother(){
		return mother;
	}

	/* 
	public DailyLog getDiaryRecord(){
		return getDiaryRecord;
	}
	*/

	public HealthStats getStatsRecord(){
		return statsRecord;
	}

	/*
	public Diet getFoodRecord(){
		return foodRecord;
	}
	*/

	//mutators: setters
	public void setDateRecord(Date date){
		dateRecord = date;
	}

	public void setMother(Mother mum){
		mother = mum;
	}

	/*
	public void setDiaryRecord(DailyLog diary){
		diaryRecord = diary;
	}
	*/

	public void setStatsRecord(HealthStats stats){
		statsRecord = stats;
	}

	/*
	public void setFoodRecord(Diet food){
		foodRecord = food;
	}
	*/

	}