/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.testes;

import br.com.ortus.utilidades.LineSelectionTableCellRenderer;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Paulo Azevedo
 */
public class TestetabelaColorida {
    public static void main(String[] args) {  
        Object[] columns = new Object[] {"Num", "BR", "EN"};  
        JTable tbl = new JTable(  
            new Object[][] {  
                {5, "Cinco", "Five"},  
                {7, "Sete", "Seven"},  
                {2, "Dois", "Two"},  
                {0, "Zero", "Zero"},  
            },  
            columns  
        );  
        TableCellRenderer renderer = new LineSelectionTableCellRenderer();  
        for (int c = 0; c < tbl.getColumnCount(); c++) {  
            tbl.setDefaultRenderer(tbl.getColumnClass(c), renderer);  
        }  
          
        JFrame dlg = new JFrame("Teste");  
        Container c = dlg.getContentPane();  
        c.add(tbl, BorderLayout.CENTER);  
        dlg.setSize(300, 300);  
        dlg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        dlg.setVisible(true);  
    }  
}
