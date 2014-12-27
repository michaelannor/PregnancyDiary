/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregnancydiary.models;
import java.util.Calendar;
import java.sql.Date;


/**
 *
 * @author michaelannor
 */
public class Mother {
    
    
    private String username;
    private String firstName;
    private String surname;
    private Date dateOfBirth;
    private String password;
    private final char GENDER = 'F';
    private Medical medicalInfo;

    /**
     * A default constructor to create a mother object
     */
    public Mother(){
        
    }
    
    /**
     * A constructor to create a mother object
     * @param user The mother's username
     * @param fname The mother's first name
     * @param sname The mother's surname
     * @param date The mother's date of birth
     * @param pass The mother's password
     * @param med The mother's medical conditions
     */
public Mother(String user, String fname, String sname, Date date , String pass, Medical med){
        username = user;
        firstName = fname;
        surname = sname;
        dateOfBirth = date;
        password = pass;
        medicalInfo = med;
    }

/**
 * A to string method to return the mother's username
 * @return The mother's username
 */
public String toString(){
    return username;
}

//accessors: getters
/**
 * An accessor method to return the username
 * @return The mother's username
 */
public String getMotherUsername(){
	return username;
}

/**
 * An accessor method to return the mother's first name
 * @return The mother's first name
 */
public String getFirstName(){
	return firstName;
}

/**
 * An accessor method to return the mother's surname
 * @return The mother's surname
 */
public String getSurname(){
	return surname;
}

/**
 * An accessor method to return the date of birth
 * @return The mother's date of birth
 */
public Date getDateOfBirth(){
	return dateOfBirth;
}

/**
 * An accessor method to get the mother's password
 * @return The mother's password
 */
public String getPassword(){
	return password;
}

/**
 * An accessor method to return the mother's medical info
 * @return The mother's medical info
 */
public Medical getMedicalInfo(){
	return medicalInfo;
}

/**
 * An accessor method to return the mother's gender
 * @return The mother's gender
 */
public char getGender(){
    return GENDER;
}

//mutators: setters
/**
 * Mutator method to set the mother's username
 * @param id The mother's username
 */
public void setMotherUsername(String id){
	username = id;
}

/**
 * Mutator method to set the mother's first name
 * @param fname The mother's first name
 */
public void setFirstName(String fname){
	firstName = fname;
}

/**
 * Mutator method to set the mother's surname
 * @param sname The mother's surname
 */
public void setSurname(String sname){
	surname = sname;
}

/**
 * Mutator method to set the mother's date of birth
 * @param date The mother's date of birth
 */
public void setDateOfBirth(Date date){
	dateOfBirth = date;
}

/**
 * Mutator method to set the mother's password
 * @param pass The mother's password
 */
public void setPassword(String pass){
	password = pass;
}

/**
 * Mutator method to set the mother's medical info
 * @param med The mother's medical info
 */
public void setMedicalInfo(Medical med){
	medicalInfo = med;
}
    
}
