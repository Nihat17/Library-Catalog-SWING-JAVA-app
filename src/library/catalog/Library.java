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
   
   public Library(int bookID, String title, String author, int pageCount, String publicationDate, int numberOfBooks){
       this.bookID = bookID;
       this.author = author;
       this.title = title;
       this.pageCount = pageCount;
       this.publicationDate = publicationDate;
       this.numberOfBooks = numberOfBooks;
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
              
       if(!LambdaFunc.checkLength.apply(warnings)){
           JOptionPane.showMessageDialog(null, warnings.toString(), 
                    "Input warnings",JOptionPane.WARNING_MESSAGE);
           output = false;
       }
       
      return output;
   }
   
}
