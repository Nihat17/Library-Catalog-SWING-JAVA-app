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
    public abstract Return checkforTypo(String ID, String firstName, String lastName, String number,boolean checkNumber);
   
}
