/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Calendar;

/**
 *
 * @author andre.ayamamoto
 */
public class ValidadorVenda {
    
    public void validarData(Calendar de, Calendar ate) {
        
        if(de.compareTo(ate) > -31 || de.compareTo(ate) < 31) {
            
        }
        
    }
    
}
