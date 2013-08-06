/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialogPesquisaComponente.java
 *
 * Created on 27/12/2011, 01:37:44
 */
package br.com.ortus.gui;

import br.com.ortus.beans.Componente;
import br.com.ortus.configuracaoPersistencia.TransactionManager;
import br.com.ortus.daosSistema.ComponenteDao;
import br.com.ortus.utilidades.HashSistema;
import br.com.ortus.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paulo Azevedo
 * email: paulovulture@hotmail.com
 * 12/2011 - 01/2012
 */
public class JDialogPesquisaComponente extends javax.swing.JDialog {
    
    List<Componente> componentes;
    String filtro = "";
    /** Creates new form JDialogPesquisaComponente */
    public JDialogPesquisaComponente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        popularTabela();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableComponentes = new javax.swing.JTable();
        jComboBoxFiltros = new javax.swing.JComboBox();
        jTextFieldFiltro = new javax.swing.JTextField();
        jButtonFiltrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldResultado = new javax.swing.JTextField();
        jButtonAlterar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Assistência Técnica Ortus - Pesquisa de Componente");

        jTableComponentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableComponentes);

        jComboBoxFiltros.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Nome", "U.M.", "Valor >=", "Valor <=", "Quantidade" }));

        jButtonFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ortus/icones/pesquisarpequeno.png"))); // NOI18N
        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 11));
        jLabel2.setText("resultado(s)");

        jTextFieldResultado.setEditable(false);

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ortus/icones/alterar.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ortus/icones/close.png"))); // NOI18N
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                        .addComponent(jButtonAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFechar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jButtonFiltrar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFiltrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonAlterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisa de Componente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(189, 189, 189))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        // TODO add your handling code here:
        filtrarPesquisa();
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        int linha = jTableComponentes.getSelectedRow();
        if(linha != -1){
            Componente c = componentes.get(linha);
            HashSistema.hash.put("componente", c);
            //TransactionManager.commit();
            componentes = new ArrayList<Componente>();
            //TransactionManager.commit();
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha para editar o componente.");
            return;
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogPesquisaComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogPesquisaComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogPesquisaComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogPesquisaComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JDialogPesquisaComponente dialog = new JDialogPesquisaComponente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JComboBox jComboBoxFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableComponentes;
    private javax.swing.JTextField jTextFieldFiltro;
    private javax.swing.JTextField jTextFieldResultado;
    // End of variables declaration//GEN-END:variables

    

    private void popularTabela() {
        ComponenteDao cDao = new ComponenteDao();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
                    "ID", "Componente","U.M.", "Valor R$", "ICMS 7%", "ICMS 12%", "Estoque Assistência" });
        componentes = cDao.obterLista(filtro);
        
        if (componentes != null) {
            for (Componente comp : componentes) {
                model.addRow(new Object[]{comp.getId(), comp.getNome(), comp.getUnidadeMedida(), new Utilidades().formatarValorDoubleParaString(comp.getValor()), calcularDescontoICMS(7.0, comp.getValor()), calcularDescontoICMS(12.0, comp.getValor()), new Utilidades().formatarValorDoubleParaString(comp.getQtde()) });
            }
            jTableComponentes.setModel(model);            
        }
        jTextFieldResultado.setText(String.valueOf(componentes.size()));
    }

    private void filtrarPesquisa() {
        if(jTextFieldFiltro.getText().isEmpty()){
            filtro = "";
            popularTabela();
        }else{
            if(jComboBoxFiltros.getSelectedIndex() == 0){
                pesquisarPorID();
                filtro = "";
            }else if(jComboBoxFiltros.getSelectedIndex() == 1){
                pesquisarPorNome();
                filtro = "";
            }else if(jComboBoxFiltros.getSelectedIndex() == 2){
                pesquisarPorUM();
                filtro = "";
            }else if (jComboBoxFiltros.getSelectedIndex() == 3){
                pesquisarPorValorMaiorIgual();
                filtro = "";
            }else if (jComboBoxFiltros.getSelectedIndex() == 4){
                pesquisarPorValorMenorIgual();
                filtro = "";
            }else{
                pesquisarPorQuantideEmEstoque();
                filtro = "";
            }
        }
    }

    private void pesquisarPorID() {
        if(verificarSeEntradaENumero()){
            filtro = "id='"+jTextFieldFiltro.getText()+"'";
            popularTabela();
        }else{
            return;
        }
    }

    private void pesquisarPorNome() {
        filtro = "nome LIKE '%"+jTextFieldFiltro.getText()+ "%'";
        popularTabela();
    }

    private void pesquisarPorUM() {
        filtro = "unidadeMedida LIKE '%"+jTextFieldFiltro.getText()+"%'";
        popularTabela();
    }

    private void pesquisarPorValorMaiorIgual() {
        if(verificarSeEntradaENumero()){
            filtro = "valor >= '"+jTextFieldFiltro.getText()+ "'";
            popularTabela();
        }
    }

    private boolean verificarSeEntradaENumero() {
        return new Utilidades().verificarSeEntradaENumeroInteger(jTextFieldFiltro.getText());           
    }

    private void pesquisarPorValorMenorIgual() {
        if(verificarSeEntradaENumero()){
            filtro = "valor <= '"+jTextFieldFiltro.getText()+ "'";
            popularTabela();
        }
    }

    private Object calcularDescontoICMS(Double perc, Double valor) {
        Double resultado = new Utilidades().calcularDescontoICMS(perc, valor);
        return new Utilidades().formatarValorDoubleParaString(resultado);
    }

    private void pesquisarPorQuantideEmEstoque() {
        if(verificarSeEntradaENumero()){
            filtro = "qtde >= '"+jTextFieldFiltro.getText()+ "'";
            popularTabela();
        }
    }
}
