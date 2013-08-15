/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulo
 */
public class Utilidades {
    
    public  String encripitarSenha(String senha){
        String senhaEncripitada = "";
        for (int i = 0; i < senha.length(); i++) {
            char carac = (char) (senha.charAt(i) * 12);
            senhaEncripitada += carac;
        }
        return senhaEncripitada;
    }
    
    public  String decripitarSenha(String senhaEncripitada){
        String senhaDecripitada = "";
        for (int i = 0; i < senhaEncripitada.length(); i++) {
            char carac = (char) (senhaEncripitada.charAt(i) / 12);
            senhaDecripitada += carac;
        }
        return senhaDecripitada;
    }
    
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public static Calendar stringToCalendar(String data) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(data));
            return c;
        } catch (ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String calendarToString(Calendar cal) {
        return dateFormat.format(cal.getTime());
    }
}
