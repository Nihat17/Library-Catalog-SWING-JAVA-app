package library.catalog;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marshall
 */
public abstract class Library {
    
   private int bookID;
   private String title;
   private String author;
   private int pageCount;
   private String publicationDate;  
   private Enum bookGenre;
   private int edition;
   private int numberOfBooks;
   
   public Library(int bookID, String title, String author, int pageCount, 
           String publicationDate, Enum bookGenre, int edition){
       
       this.bookID = bookID;
       this.author = author;
       this.title = title;
       this.pageCount = pageCount;
       this.publicationDate = publicationDate;     
       this.bookGenre = bookGenre;
       this.edition = edition;
    } 
    public Library(){
      
    }    
   
    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks + 1;
    }
    
    public int getNumberOfBooks(){
        return numberOfBooks;
    }
    
    public String getBookGenre() {
        String genre = bookGenre.name();
        return genre;
    }

    public int getEdition() {
        return edition;
    }
    
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }   

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getPublicationDate() {
        return publicationDate;
    }        
       
   public static boolean checkForLength(StringBuilder warnings){      
       boolean output = true;
              
       if(!LambdaFunc.CHECK_LENGTH.apply(warnings)){
           JOptionPane.showMessageDialog(null, warnings.toString(), 
                    "Input warnings",JOptionPane.WARNING_MESSAGE);
           output = false;
       }
       
      return output;
   }
   
   public abstract StringBuilder checkForTypo(String id, String title, String author,
           String pageCount, String publicationDate, String genre, String edition);
   
   public abstract boolean checkIfGenreMatches(String type);
         
}
