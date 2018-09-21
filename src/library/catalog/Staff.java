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
public class Staff extends Personnel {
   /* int stuffID;
    String firstName, lastName, phoneNumber; */
    
    @Override
    public Return checkforTypo(String ID, String firstName, String lastName, String number,boolean checkNumber){
        StringBuilder warnings = new StringBuilder();       
        
        if(setStaffID(ID) == 0){
            warnings.append("Please use just digits for ID.\n");
        }
        
        if("".equals(setFirstName(firstName))){
            warnings.append("Please use letters for first name.\n");
        }
        
        if("".equals(setLastName(lastName))){
            warnings.append("Please use letters for last name.\n");
        }
                               
        if(checkNumber == true){
           if("".equals(setPhoneNumber(number))){
                warnings.append("Phone number must be a number.\n");
           }
        }
         
        Return object = new Return(this, warnings);
        return object;
    } 
  
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public int getStaffID() {
        return ID;
    }  

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
   
     public int setStaffID(String id){
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
}
