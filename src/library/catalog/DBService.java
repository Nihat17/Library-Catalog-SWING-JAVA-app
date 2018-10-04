package library.catalog;


import library.catalog.User;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marshall
 */
public class DBService {
    String url = "jdbc:mysql://localhost:3306/librarydb";
    String user = "library";
    String password = "securepassword";
    
    private Connection connect() throws ClassNotFoundException{
        Connection connection = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        Properties info = new Properties();
        info.put("user", "library");
        info.put("password", "securepassword");
        info.put("useSSL", "false");
        info.put("autoReconnect", "true");
        try {
            connection = (Connection) DriverManager.getConnection(url, info);
        } catch (SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
    int addUser(User user) throws ClassNotFoundException{
        int successForUsers = -1, successForNumber = -1;
        
        Connection connection = connect();
        try {
            // ADD USER
        //    connection.setAutoCommit(false);
            String addUserSql = "INSERT INTO Users(ID, FirstName, LastName) VALUES(?,?,?)";
            PreparedStatement addUser = connection.
                    prepareStatement(addUserSql, Statement.RETURN_GENERATED_KEYS);
            
            addUser.setInt(1, user.getID());
            addUser.setString(2, user.getFirstName());
            addUser.setString(3, user.getLastName());
            
            successForUsers = addUser.executeUpdate();                       
            
            //ADD PHONENUMBER
            String addPhoneNumberSQL = "INSERT INTO PhoneNumbers(UserID, PhoneNumber) VALUES(?,?)";
            PreparedStatement addPhoneNumber = connection.
                    prepareStatement(addPhoneNumberSQL, Statement.RETURN_GENERATED_KEYS);
            
            addPhoneNumber.setInt(1, user.getID());
            addPhoneNumber.setString(2, user.getPhoneNumber());
            successForNumber = addPhoneNumber.executeUpdate();            
            connection.close();
           
        } catch (SQLException ex) {
            System.err.println("An error has occurred " + ex.getMessage());    
        }   
        
       return (successForUsers > -1 && successForNumber > -1)? 1:0;
        
    }
    
    public boolean addStuff(Staff staff){
       int successOfAddingStaff = -1, successOfAddingNumber = -1;
        try {
            Connection connect = connect();
            //ADD Stuff 
            String addUserSQL = "INSERT INTO Staff(ID, FirstName, LastName) VALUES(?,?,?)";
            PreparedStatement addStaffStatement = connect.prepareStatement(addUserSQL, Statement.RETURN_GENERATED_KEYS);
            addStaffStatement.setInt(1, staff.getID());
            addStaffStatement.setString(2, staff.getFirstName());
            addStaffStatement.setString(3, staff.getLastName());
            
            successOfAddingStaff = addStaffStatement.executeUpdate();
            
            ResultSet addStuffResults = addStaffStatement.getGeneratedKeys();
            if(addStuffResults.next()){
                
            }
            
            //ADD Phone number
            
            String addNumberSQL = "INSERT INTO PhoneNumbers(StaffID, PhoneNumber) VALUES(?,?)";
            PreparedStatement addNumberStatement = connect.prepareStatement
                (addNumberSQL, Statement.RETURN_GENERATED_KEYS);
            addNumberStatement.setInt(1, staff.getID());
            addNumberStatement.setString(2, staff.getPhoneNumber());
            
            successOfAddingNumber = addNumberStatement.executeUpdate();
            connect.close();
           
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (successOfAddingStaff > -1 && successOfAddingNumber > -1);
    }
    
    boolean searchUser(User user) throws ClassNotFoundException{
        Connection connect = connect();        
        String phoneNumber = "";
        
        String searchUserSQL = "Select PhoneNumber FROM PhoneNumbers, Users WHERE "
                + "Users.FirstName = ? AND Users.LastName = ? AND PhoneNumbers.UserID = ?;";
        try {
           PreparedStatement searchUser = connect.
                    prepareStatement(searchUserSQL,Statement.RETURN_GENERATED_KEYS);
           
           searchUser.setString(1, user.getFirstName());
           searchUser.setString(2, user.getLastName());
           searchUser.setInt(3, user.getID());
                               
           ResultSet searchUserResult;
           searchUserResult = searchUser.executeQuery();
                      
           if(searchUserResult.next()){
               phoneNumber = searchUserResult.getString("PhoneNumber");
               user.setPhoneNumber(phoneNumber);
           }
           //If the user exists in database then output will be its ID 
           // Else ouput will stay as -1
           
        } catch (SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(!"".equals(phoneNumber));
    }
    
   boolean searchStaff(Staff staff){
         
        String phoneNumber = "";
        
        String searchStaffSQL = "Select PhoneNumber FROM PhoneNumbers, Staff WHERE "
                + "Staff.FirstName = ? AND Staff.LastName = ? AND PhoneNumbers.StaffID = ?;";
        try {
           Connection connect = connect();       
           PreparedStatement searchUser = connect.
                    prepareStatement(searchStaffSQL,Statement.RETURN_GENERATED_KEYS);
           
           searchUser.setString(1, staff.getFirstName());
           searchUser.setString(2, staff.getLastName());
           searchUser.setInt(3, staff.getID());
                               
           ResultSet searchUserResult;
           searchUserResult = searchUser.executeQuery();
                      
           if(searchUserResult.next()){
               phoneNumber = searchUserResult.getString("PhoneNumber");
               staff.setPhoneNumber(phoneNumber);
           }
           //If the user exists in database then output will be its ID 
           // Else ouput will stay as -1
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(!"".equals(phoneNumber));
   }
   
   int checkIfBookExist(String author, String title, String id){
       int libraryID = Integer.parseInt(id);
       int numberOfBooks = 0;
      
       try {
           Connection connect = connect();
           String checkExistSQL = "Select numberOfBooks FROM Library WHERE ID = ? "
                   + "AND Title = ? AND Author = ?";
           
           PreparedStatement checkExistPS = connect.prepareStatement(checkExistSQL,
                   Statement.RETURN_GENERATED_KEYS);
           checkExistPS.setInt(1, libraryID);
           checkExistPS.setString(2, title);
           checkExistPS.setString(3, author);
           checkExistPS.executeQuery();                      
           
           ResultSet checkExistSet;           
           checkExistSet = checkExistPS.getResultSet();
           
           if(checkExistSet.next()){
              numberOfBooks = checkExistSet.getInt("NumberOfBooks");
           }
           connect.close();
       
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return numberOfBooks;
   }
   
   boolean addBook(Book book, String ISBN){
       int successForAddBook = -1;
       int addISBNSuccess = -1;
       boolean checkSuccessISBN = true;
       try {
            Connection connect = connect();
            String addBookSQL = "INSERT INTO Library(ID, Title, Author, PageCount, "
                    + "PublicationDate, bookGenre, Edition)"
                    + " VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement addBookStatement = connect.prepareStatement(addBookSQL,
                    Statement.RETURN_GENERATED_KEYS);
            addBookStatement.setInt(1, book.getBookID());
            addBookStatement.setString(2, book.getTitle());
            addBookStatement.setString(3, book.getAuthor());
            addBookStatement.setInt(4, book.getPageCount());
            addBookStatement.setString(5, book.getPublicationDate());
            //addBookStatement.setInt(6, book.getNumberOfBooks());
            addBookStatement.setString(6, book.getBookGenre());
            addBookStatement.setInt(7, book.getEdition());
            successForAddBook = addBookStatement.executeUpdate();
            
            
            String addISBNsql = "INSERT INTO Books(ISBN, LibraryID) VALUES(?, ?)";
            PreparedStatement addISBNstatement = connect.prepareStatement
                   (addISBNsql, Statement.RETURN_GENERATED_KEYS);
               addISBNstatement.setString(1, book.getISBN());
               addISBNstatement.setInt(2, book.getBookID());
               addISBNSuccess = addISBNstatement.executeUpdate();
            /*int[] addISBNSuccess = new int[ISBN.length];
            for(int i = 0; i < ISBN.length; i++){
               PreparedStatement addISBNstatement = connect.prepareStatement
                   (addISBNsql, Statement.RETURN_GENERATED_KEYS);
               addISBNstatement.setString(1, ISBN[i]);
               addISBNstatement.setInt(2, book.getBookID());
               addISBNSuccess[i] = addISBNstatement.executeUpdate();
            }
            
           
            for(int i = 0; i < addISBNSuccess.length; i++)
                if(addISBNSuccess[i] == 0){
                    checkSuccessISBN = false;
                    break;
                }
             */   
            connect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return (successForAddBook > -1 && addISBNSuccess > -1);
   } 

    public int updateBook(int numberOfBooks, String title) {
        int updateSuccess = -1;
        numberOfBooks++;
        
        try {
            Connection connect = connect();
            String updateSql = "UPDATE Library SET NumberOfBooks = ? WHERE Title = ?";            
            PreparedStatement updateStatement = connect.prepareStatement(updateSql,
                    Statement.RETURN_GENERATED_KEYS);
            
            updateStatement.setInt(1, numberOfBooks);
            updateStatement.setString(2, title);
            
            //updateStatement.executeUpdate();
            updateSuccess = updateStatement.executeUpdate();
                                                          
            connect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updateSuccess;
    }
}
