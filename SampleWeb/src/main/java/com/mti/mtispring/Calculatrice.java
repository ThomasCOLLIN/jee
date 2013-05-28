/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import javax.jws.WebService;

/**
 *
 * @author boulie_r <remi.boulier@epita.fr>
 */
@WebService(endpointInterface = "com.mti.mtispring.CalculService")
public class Calculatrice implements CalculService{
    public String plus(String valeur1, String valeur2)
    {
        Integer num1;
        Integer num2;
        
        try
        {
         num1 = Integer.parseInt(valeur1);
         num2 = Integer.parseInt(valeur2);
        }
        catch(NumberFormatException ex)
        {
            return ("Invalid parameters.");
        }
        
        return "Le résultat est : " + (num1 + num2);
    }
    
    public String moins(String valeur1, String valeur2)
    {
        Integer num1;
        Integer num2;
        
        try
        {
         num1 = Integer.parseInt(valeur1);
         num2 = Integer.parseInt(valeur2);
        }
        catch(NumberFormatException ex)
        {
            return ("Invalid parameters.");
        }
        
        return "Le résultat est : " + (num1 - num2);
    }
        
    public String fois(String valeur1, String valeur2)
    {
        Integer num1;
        Integer num2;
        
        try
        {
         num1 = Integer.parseInt(valeur1);
         num2 = Integer.parseInt(valeur2);
        }
        catch(NumberFormatException ex)
        {
            return ("Invalid parameters.");
        }
        
        return "Le résultat est : " + (num1 * num2);
    }
            
    public String divise(String valeur1, String valeur2)
    {
        Integer num1;
        Integer num2;
        
        try
        {
         num1 = Integer.parseInt(valeur1);
         num2 = Integer.parseInt(valeur2);
        }
        catch(NumberFormatException ex)
        {
            return ("Invalid parameters.");
        }
        
        if (num2 == 0)
            return ("Impossible de diviser par 0");
        
        return "Le résultat est : " + (num1 / num2);
    }
}
