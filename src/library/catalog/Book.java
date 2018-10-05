/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.catalog;

import java.util.ArrayList;
import java.util.Random;


public class Book extends Library{
   private String ISBN;   
   private Enum status;
   private String dueDate;

   public Book(int bookID, String title, String author, int pageCount, 
           String publicationDate, Enum bookGenre, int edition) {
       
      super(bookID, title, author, pageCount, publicationDate, bookGenre, edition);
   }
       
   public Book(){
       
   }
   
   public String getISBN() {
      String ISBN = "9788395055";               
      Random rn = new Random();
      int [] randomAdd = new int[3];
      ISBN = "9788395055"; 
      for(int i = 0; i < 3; i++){
          randomAdd[i] = rn.nextInt(9) + 1;
          ISBN += String.valueOf(randomAdd[i]);
        }
                  
       return ISBN;
    
   }

    public void setStatus(Enum status) {
        this.status = status;
    }

   public Enum getStatus() {
       return status;
   }

   public String getDueDate() {
       return dueDate;
   }

    @Override
    public StringBuilder checkForTypo(String id, String title, String author,
            String pageCount, String publicationDate, String genre, String edition) {
        
        StringBuilder warnings = new StringBuilder();
        if(!LambdaFunc.CFT_INT.test(id))
            warnings.append("Please use just digits for ID.\n");            
        
        if(!LambdaFunc.CFT_STR.test(title))
            warnings.append("Please use letters for title.\n");
        
        if(!LambdaFunc.CFT_STR.test(author))
            warnings.append("Please use letters for author.\n");
        
        if(!LambdaFunc.CFT_INT.test(pageCount))
            warnings.append("Please use letters for page count.\n");
        
        if(!LambdaFunc.CFT_INT.test(publicationDate))
            warnings.append("Please use yyyy format for publication date.\n");                
        
        if(!checkIfGenreMatches(genre))        
            warnings.append("Please use one of following genres: Fiction,\n" +
                "Drama,\n" + "Romance,\n" + "Adventure,\n" + "Satire,\n" + "Horror\n" + "Undefined");
        
        if(!LambdaFunc.CFT_INT.test(edition))
            warnings.append("Please use number for edition.");
            
        return warnings;
    }   

    @Override
    public boolean checkIfGenreMatches(String type){
      boolean check = false;
      ArrayList<String> listOfGenres = new ArrayList<String>();
      listOfGenres.add("Undefined");
      listOfGenres.add("Fiction");
      listOfGenres.add("Drama");
      listOfGenres.add("Adventure");
      listOfGenres.add("Satire");
      listOfGenres.add("Horror");
      for(int i = 0; i < listOfGenres.size(); i++) {           
          if(listOfGenres.get(i).equals(type)){
              check = true;
              break;
          }
      }
      return check;
    }
  
    public String setISBN(){
        
        String ISBN = "9788395055";                 
            Random rn = new Random();
            int [] randomAdd = new int[3];
            ISBN = "9788395055"; 
            for(int i = 0; i < 3; i++){
              randomAdd[i] = rn.nextInt(9) + 1;
              ISBN += String.valueOf(randomAdd[i]);
            }                   
        return ISBN;
    }
}
