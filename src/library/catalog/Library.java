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
   private int numberOfBooks;
   private Enum bookGenre;
     
   public Library(int bookID, String title, String author, int pageCount, 
           String publicationDate, int numberOfBooks, Enum bookGenre){
       
       this.bookID = bookID;
       this.author = author;
       this.title = title;
       this.pageCount = pageCount;
       this.publicationDate = publicationDate;
       this.numberOfBooks = numberOfBooks;
       this.bookGenre = bookGenre;
    } 
   public Library(){
      
   } 
   
    public String getBookGenre() {
        String genre = bookGenre.name();
        return genre;
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

    public int getNumberOfBooks() {
        return numberOfBooks;
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
           String pageCount, String publicationDate, String numberOfBooks, Enum genre);
   
   public abstract boolean checkIfGenreMatches(Enum type);
         
}
