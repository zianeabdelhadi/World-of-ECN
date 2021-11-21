/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @ Ziane & Saoud
 */

class Autre_NumberFormatException extends Exception {
    
    void test(String var) throws Autre_NumberFormatException {
        
        //int z = Integer.parseInt(var);
    
    if (var.equals("Autre_NumberFormatException")) {
        throw new Autre_NumberFormatException();
       
        }
    
        //return(z);
    }
    }

public class Test_exception {
    
    
    public static void main(String[] args) throws Autre_NumberFormatException {
        
       Autre_NumberFormatException autre = new Autre_NumberFormatException();
       autre.test("10a");
       //System.out.println(z);
       
    }
}
