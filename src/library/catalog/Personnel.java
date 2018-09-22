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
        if(LambdaFunc.CFT_INT.test(id)) 
           ID = Integer.parseInt(id);
        else 
            ID = 0;
            
        return ID;
    }
    
    public String setFirstName(String firstName){
        if(LambdaFunc.CFT_STR.test(firstName)){
           this.firstName = firstName; 
        }
        else 
            firstName = "";
        
        return firstName;
    }
    
    public String setLastName(String lastName){
        if(LambdaFunc.CFT_STR.test(lastName)){
            this.lastName = lastName;
        }
        else 
            lastName = "";
        
        return lastName;
    }
    
    public String setPhoneNumber(String phoneNumber){
        if(LambdaFunc.CFT_INT.test(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }
        else 
            phoneNumber = "";
        
        return phoneNumber;
    }
    public abstract Return checkforTypo(String ID, String firstName, String lastName, String number,boolean checkNumber);
   
}
