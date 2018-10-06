/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.catalog;

import java.sql.SQLException;
import java.util.List;


public class Return {
    User user = new User();
    StringBuilder warnings = new StringBuilder();
    DBService database = new DBService();
    Staff staff = new Staff();
    Return(User user, StringBuilder warnings){
        this.user = user;
        this.warnings = warnings;
    }
    Return(){
        
    }
    Return(Staff staff, StringBuilder warnings){
        this.staff = staff;
        this.warnings = warnings;
    }
    
    public User getUser() {
        return user;
    }

    public Staff getStaff() {
        return staff;
    }

    public StringBuilder getWarnings() {
        return warnings;
    }
    
    public boolean addUser(User user) throws ClassNotFoundException{
       return (database.addUser(user) > 0);
    }
    
    public boolean searchUser(User user) throws ClassNotFoundException{
       return(database.searchUser(user));
    }
    public boolean addStaff(Staff staff){
        return(database.addStuff(staff));
    }
    public boolean searchStaff(Staff staff){
        return(database.searchStaff(staff));
    }
    
    public boolean addBook(Book book, String ISBN){
        return(database.addBook(book, ISBN));
    }
    
    public int checkIfBookExist(String title, String author, String id){
        return(database.checkIfBookExist(author, title, id));
    }
    public int updateBook(int numberOfBooks, String title){
        return(database.updateBook(numberOfBooks, title));
    }
    
    public int insertIntoBooks(Book book) throws SQLException{
        return(database.insertIntoBooks(book));
    }
    
    public List searchBook(String title, String author){
        return (database.searchBook(title, author));
    }
    public List selectBooks() throws ClassNotFoundException{
        return(database.selectBooks());
    }
    
}
