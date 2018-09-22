/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.catalog;


public class Book extends Library{
   private String ISBN;   
   private Enum status;
   private String dueDate;

   public Book(int bookID, String title, String author, int pageCount, String publicationDate, int numberOfBooks) {
       super(bookID, title, author, pageCount, publicationDate, numberOfBooks);
   }
        
   public String getISBN() {
       return ISBN;
   }

   public Enum getStatus() {
       return status;
   }

   public String getDueDate() {
       return dueDate;
   }

    @Override
    public StringBuilder checkForType(String id, String title, String author, String pageCount, String publicationDate, String numberOfBooks) {
        
    }
  
   
   
}
