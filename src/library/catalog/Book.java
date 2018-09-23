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

   public Book(int bookID, String title, String author, int pageCount, 
           String publicationDate, int numberOfBooks, Enum bookGenre) {
       
      super(bookID, title, author, pageCount, publicationDate, numberOfBooks, bookGenre);
   }
       
   public Book(){
       
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
    public StringBuilder checkForTypo(String id, String title, String author, String pageCount, String publicationDate, String numberOfBooks,Enum genre) {
        StringBuilder warnings = new StringBuilder();
        if(!LambdaFunc.CFT_INT.test(id))
            warnings.append("Please use just digits for ID.\n");            
        
        if(!LambdaFunc.CFT_STR.test(title))
            warnings.append("Please use letters for title.\n");
        
        if(!LambdaFunc.CFT_STR.test(author))
            warnings.append("Please use letters for author.\n");
        
        if(!LambdaFunc.CFT_INT.test(pageCount))
            warnings.append("Please use letters for page count.\n");
        
        if(!LambdaFunc.CFT_DATE.test(publicationDate))
            warnings.append("Please use dd-MM-yyyy format for publication date.\n");
        
        if(!LambdaFunc.CFT_INT.test(numberOfBooks))
            warnings.append("Please use numbers for number of books field. \n");
        if(!checkIfGenreMatches(genre))        
            warnings.append("Please use one of following genres: Fiction,\n" +
                "Drama,\n" + "Romance,\n" + "Adventure,\n" + "Satire,\n" + "Horror\n" + "Undefined");
        
        return warnings;
    }   

    @Override
    public boolean checkIfGenreMatches(Enum type){
      boolean check = false;
      for(BookGenre genre : BookGenre.values()) {           
          if(genre.equals(type)){
              check = true;
              break;
          }
      }
      return check;
    }
  
   
   
}
