package library.catalog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class User extends Personnel{
      
    @Override
    public Return checkforTypo(String ID, String firstName, String lastName, String number,boolean checkNumber){
        StringBuilder warnings = new StringBuilder();       
        
        if(setID(ID) == 0){
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
}
