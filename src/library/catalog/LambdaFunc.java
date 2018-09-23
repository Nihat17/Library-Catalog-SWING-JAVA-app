/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.catalog;

import java.util.function.Function;
import java.util.function.Predicate;

//CFT stands for CHECK FOR TYPO
public interface LambdaFunc {
   String REGEX_FOR_DATE = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
    
   static Function<StringBuilder, Boolean> CHECK_LENGTH = (str) -> str.length() == 0;
   
   static Predicate<String> CFT_STR = (str) ->  str.matches("^[^0-9]+$") && !str.isEmpty();
      
   static Predicate<String> CFT_INT = (number) -> number.matches("\\d+") && !number.isEmpty();
   
   static Predicate<String> CFT_DATE = (date) -> date.matches(REGEX_FOR_DATE) && !date.isEmpty();
}
