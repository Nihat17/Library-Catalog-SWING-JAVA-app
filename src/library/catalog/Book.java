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
        
   public String getISBN() {
       return ISBN;
   }

   public Enum getStatus() {
       return status;
   }

   public String getDueDate() {
       return dueDate;
   }
  
   
   
}
