/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.gui;

import java.awt.Dialog;

/**
 *
 * @author Usuario
 */
public class Start {
    public static void main(String[] args) {
        JDialogLogin dialog = new JDialogLogin(null, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }    
}
