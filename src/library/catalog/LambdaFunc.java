/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.catalog;

import java.util.function.Function;


public interface LambdaFunc {
   static Function<StringBuilder, Boolean> checkLength = (str) -> str.length() == 0;
}
