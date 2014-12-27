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
public class Medical {
    private String hospital;
    private String doctor;
    private Date conceptionDate;
    private boolean asthma;
    private boolean hiv;
	//private LinkedList allergy; //how to collect info?
    //private BloodGrouping bloodgroup;
    private String bloodgroupString;
    
    /**
     * A constructor to create a medical object which contains the mother's medical details
     * @param hospital The mother's hospital
     * @param doctor The mother's doctor
     * @param conceptionDate The date the baby was conceived
     * @param asthma The mother's asthma status
     * @param hiv
     * @param bloodGroupString 
     */
    public Medical(String hospital, String doctor, Date conceptionDate, boolean asthma, boolean hiv, String bloodGroupString){
        this.hospital = hospital;
        this.doctor = doctor;
        this.conceptionDate = conceptionDate;
        this.asthma = asthma;
        this.hiv = hiv;
        this.bloodgroupString = bloodGroupString;
    }
    /**
     * A constructor to create a medical object that takes in a hospital
     * @param hospital 
     */
    public Medical(String hospital){
        this.hospital = hospital;

    }

	//accessors: getters
/**
 * Accessor method to return the mother's hospital
 * @return The mother's hospital
 */
	public String getHospital(){
		return hospital;
	}

        /**
         * Accessor method to return the mother's doctor
         * @return The mother's doctor
         */
	public String getDoctor(){
		return doctor;
	}

        /**
         * Accessor method to return the day the baby was concieved
         * @return The conception date
         */
	public Date getConceptionDate(){
		return conceptionDate;
	}

        /**
         * Accessor method to return the mother's asthma status
         * @return The mother's asthma status
         */
	public boolean getAsthma(){
		return asthma;
	}

        /**
         * Accessor method to return the mother's HIV status
         * @return The mother's HIV status
         */
	public boolean getHiv(){
		return hiv;
	}

        /**
         * Accessor method to return the mother's blood group
         * @return The mother's blood group
         */
	public String getBloodGroup(){
		return bloodgroupString;
	}

	//mutator: setters

        /**
         * Mutator method to set the mother's hospital
         * @param hospital The mother's hospital
         */
	public void setHospital(String hospital){
		this.hospital = hospital;
	}

        /**
         * Mutator method to set the mother's doctor
         * @param doc The mother's doctor
         */
	public void setDoctor(String doc){
		doctor = doc;
	}

        /**
         * Mutator method to set the conception date
         * @param date The mother's conception date
         */
        public void setConceptionDate(Date date){
            conceptionDate = date;
        }
        
	/**
         * Mutator method to set the mother's asthma status
         * @param asth The mother's asthma status
         */
	public void setAsthma(boolean asth){
		asthma = asth;
	}

        /**
         * Mutator method to set the mother's HIV status
         * @param hivirus The mother's HIV status
         */
	public void setHiv(boolean hivirus){
		hiv = hivirus;
	}
        
        /**
         * Mutator method to set the mother's blood group
         * @param blood The mother's blood group
         */
        public void setBloodGroup(String blood){
            bloodgroupString = blood;
        }

        /**
         * Mutator method to set the mother's blood group
         * @param blood The mother's blood group
         */
	public void setBloodGroup(int blood){
 		switch (blood){
      
      		case 1: bloodgroupString = BloodGrouping.AA.toString(); break;
      		case 2: bloodgroupString = BloodGrouping.BB.toString(); break;
      		case 3: bloodgroupString = BloodGrouping.AB.toString(); break;
     		case 4: bloodgroupString = BloodGrouping.OO.toString(); break;

      		default: bloodgroupString = "N/A";
    }
	}

	}
        
	enum BloodGrouping{AA, BB, AB, OO}
