/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregnancydiary.models;

/**
 *
 * @author michaelannor
 */
public class HealthStats {
	
	//private int numUrine; //might take out urine
	private double weight;
	private int bloodPressure;
	private double height;
	private double bumpSize;
	private String generalFeel;
	private double bodyMassIndex;
	private String bmiExplanation;

	private static final double UNDERWEIGHT_THRESHOLD = 18.5;
	private static final double NORMAL_THRESHOLD = 25;
	private static final double OBESE_THRESHOLD = 30;

	private static final String UNDERWEIGHT_STRING = "Underweight";
	private static final String NORMAL_STRING = "Normal";
	private static final String OVERWEIGHT_STRING = "Overweight";
	private static final String OBESE_STRING = "Obese";
	
        /**
         * A constructor to create a Health Stats object with the health details of the mother
         * @param weight The mother's weight
         * @param bloodPressure The mother's blood pressure
         * @param height The mother's height
         * @param bumpSize The size of the mother's stomach
         * @param generalFeel A summary of how the mother felt during the day
         */
        public HealthStats(double weight, int bloodPressure, double height, double bumpSize, String generalFeel){
            this.weight = weight;
            this.bloodPressure = bloodPressure;
            this.height = height;
            this.bumpSize = bumpSize;
            this.generalFeel = generalFeel;
            calculateBodyMassIndex();
            findBmiExplanation();
        }
	

	//accessors: getters

        /**
         * An accessor method to return the mother's weight
         * @return The mother's weight
         */
	public double getWeight(){
		return weight;
	}
        /**
         * An accessor method to return the mother's blood pressure
         * @return The mother's blood pressure
         */
	public int	getBloodPressure(){
		return bloodPressure;
	}

        /**
         * An accessor method to return the mother's height
         * @return The mother's height
         */
	public double getHeight(){
		return height;
	}

        /**
         * An accessor method to return the mother's stomach size
         * @return The size of the mother's stomach
         */
	public double getBumpSize(){
		return bumpSize;
	}

        /**
         * An accessor method to return a summary of how the mother felt during the day
         * @return A summary of how the mother felt during the day
         */
	public String getGeneralFeel(){
		return generalFeel;
	}

        /**
         * A method to compute the mother's body mass index using the weight and height
         */
        public void calculateBodyMassIndex(){
            	bodyMassIndex = (weight / (height * height));

        }
        
        /**
         * An accessor to return the mother's body mass index
         * @return The mother's body mass index
         */
	public double getBodyMassIndex(){
		return bodyMassIndex;
	}
        
        /**
         * A method to generate an explantion of the mother's health status given her Body Mass Index.
         */
        public void findBmiExplanation(){
            //insert conditions to get explanations
		if (bodyMassIndex < UNDERWEIGHT_THRESHOLD){
			bmiExplanation = UNDERWEIGHT_STRING;
		}
		else if ((bodyMassIndex >= UNDERWEIGHT_THRESHOLD) && (bodyMassIndex <= NORMAL_THRESHOLD)){
			bmiExplanation = NORMAL_STRING;	
		}
		else if ((bodyMassIndex > NORMAL_THRESHOLD) && (bodyMassIndex <= OBESE_THRESHOLD)){
			bmiExplanation = OVERWEIGHT_STRING;	
		}
		else if (bodyMassIndex > OBESE_THRESHOLD){
			bmiExplanation = OBESE_STRING;
		}
        }
        
        /**
         * A method to return an the implications of the mother's body mass index
         * @return A statements indicating whether the mother is underweight, overwieght, obese or normal
         */
	public String getBmiExplanation(){
		return bmiExplanation;
	}

	}