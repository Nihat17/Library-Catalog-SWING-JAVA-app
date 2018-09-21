/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.catalog;

/**
 *
 * @author marshall
 */
public abstract class Personnel {
    protected String firstName;
    protected String lastName;
    protected int ID;
    protected String phoneNumber;   
   
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public int getID() {
        return ID;
    }  

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
     public int setID(String id){
        if(id.matches("\\d+") && !id.isEmpty()) 
           ID = Integer.parseInt(id);
        else 
            ID = 0;
            
        return ID;
    }
    
    public String setFirstName(String firstName){
        if(firstName.chars().allMatch(Character::isLetter) && !firstName.isEmpty()){
           this.firstName = firstName; 
        }
        else 
            firstName = "";
        
        return firstName;
    }
    
    public String setLastName(String lastName){
        if(lastName.chars().allMatch(Character::isLetter) && !lastName.isEmpty()){
            this.lastName = lastName;
        }
        else 
            lastName = "";
        
        return lastName;
    }
    
    public String setPhoneNumber(String phoneNumber){
        if(phoneNumber.matches("\\d+") && !phoneNumber.isEmpty()){
            this.phoneNumber = phoneNumber;
        }
        else 
            phoneNumber = "";
        
        return phoneNumber;
    }
    public abstract Return checkforTypo(String ID, String firstName, String lastName, String number,boolean checkNumber);
   
}
