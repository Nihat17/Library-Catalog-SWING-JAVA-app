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
   static Function<StringBuilder, Boolean> CHECK_LENGTH = (str) -> str.length() == 0;
   
   static Predicate<String> CFT_NAME = (firstName) -> firstName.chars()
           .allMatch(Character::isLetter) && !firstName.isEmpty();
   
   static Predicate<String> CFT_INT = (number) -> number.matches("\\d+") && !number.isEmpty();
}
