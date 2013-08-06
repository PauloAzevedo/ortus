/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.testes;

import br.com.ortus.utilidades.Utilidades;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class testeFeel extends JFrame{
    public static void main(String[] args) {
        Double valor = new Utilidades().formatarValorStringParaDouble("127,23");
        System.out.println(valor);
    }
    
}
