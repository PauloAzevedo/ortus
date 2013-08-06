/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialogMoldeComponente.java
 *
 * Created on 24/01/2012, 23:13:28
 */
package br.com.ortus.gui;

import br.com.ortus.beans.Componente;
import br.com.ortus.beans.MoldeComponente;
import br.com.ortus.configuracaoPersistencia.TransactionManager;
import br.com.ortus.daosSistema.MoldeComponenteDao;
import br.com.ortus.utilidades.HashSistema;
import java.awt.Dialog;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Usuario
 */
public class JDialogCadastroMoldeComponente extends javax.swing.JDialog {

    private Componente componenteAux;

    /** Creates new form JDialogMoldeComponente */
    public JDialogCadastroMoldeComponente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldIDCompAstec = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNomeComponente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNumeroSerie = new javax.swing.JTextField();
        jButtonPesquisarCompAstec = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButton3Remover = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jButtonBuscarComponente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Componente para Assistência ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel2)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("ID");

        jTextFieldIDCompAstec.setEditable(false);

        jLabel3.setText("Componente");

        jLabel4.setText("Número Série/Lote:");

        jButtonPesquisarCompAstec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ortus/icones/pesquisarpequeno.png"))); // NOI18N
        jButtonPesquisarCompAstec.setText("Pesquisar");
        jButtonPesquisarCompAstec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarCompAstecActionPerformed(evt);
            }
        });

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ortus/icones/save2.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButton3Remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ortus/icones/trashcan_delete_17.png"))); // NOI18N
        jButton3Remover.setText("Remover");
        jButton3Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3RemoverActionPerformed(evt);
            }
        });

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ortus/icones/folder_new.png"))); // NOI18N
        jButtonNovo.setText("Limpar");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ortus/icones/close.png"))); // NOI18N
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonBuscarComponente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ortus/icones/mais.png"))); // NOI18N
        jButtonBuscarComponente.setText("Buscar");
        jButtonBuscarComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarComponenteActionPerformed(evt);
            }
        });

        jLabel5.setText("Valor R$:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldValor, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldIDCompAstec, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextFieldNomeComponente, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonBuscarComponente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPesquisarCompAstec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3Remover)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFechar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeComponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarComponente)
                    .addComponent(jTextFieldIDCompAstec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarCompAstec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButton3Remover)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonFechar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
        novo();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonBuscarComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarComponenteActionPerformed
        // TODO add your handling code here:
        buscarComponente();
    }//GEN-LAST:event_jButtonBuscarComponenteActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        salvar();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonPesquisarCompAstecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarCompAstecActionPerformed
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_jButtonPesquisarCompAstecActionPerformed

private void jButton3RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3RemoverActionPerformed
// TODO add your handling code here:
    remover();
}//GEN-LAST:event_jButton3RemoverActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogCadastroMoldeComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogCadastroMoldeComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogCadastroMoldeComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogCadastroMoldeComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JDialogCadastroMoldeComponente dialog = new JDialogCadastroMoldeComponente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3Remover;
    private javax.swing.JButton jButtonBuscarComponente;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisarCompAstec;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldIDCompAstec;
    private javax.swing.JTextField jTextFieldNomeComponente;
    private javax.swing.JTextField jTextFieldNumeroSerie;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables

    private void novo() {
        jTextFieldIDCompAstec.setText(null);
        jTextFieldNomeComponente.setText(null);
        jTextFieldNumeroSerie.setText(null);
        jTextFieldValor.setText(null);
        componenteAux = null;
    }

    private void buscarComponente() {
        Dialog jd = new JDialogPesquisaComponente(null, true);
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
        Componente c = (Componente) HashSistema.hash.get("componente");
        HashSistema.hash.remove("componente");
        if (c != null) {
            preencherOsCamposComOComponente(c);
        } else {
            return;
        }

    }

    private void preencherOsCamposComOComponente(Componente c) {
        componenteAux = c;
        jTextFieldNomeComponente.setText(c.getNome().trim());
        jTextFieldValor.setText(String.valueOf(c.getValor()));
    }

    private void salvar() {
        if (componenteAux != null) {
            if (jTextFieldNumeroSerie.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o número de Série/Lote!");
                return;
            } else {
                int opcao = JOptionPane.showConfirmDialog(rootPane,
                        "Deseja salvar?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (opcao != JOptionPane.YES_OPTION) {
                    return;
                }
                MoldeComponente md = new MoldeComponente();
                if (!jTextFieldIDCompAstec.getText().isEmpty()) {
                    md.setId(Integer.parseInt(jTextFieldIDCompAstec.getText()));
                }
                md.setComponente(componenteAux);
                md.setNumeroIdentificacao(jTextFieldNumeroSerie.getText().toUpperCase());
                md.setValorFinalComponente(Double.parseDouble(jTextFieldValor.getText()));

                TransactionManager.beginTransaction();
                try {
                    MoldeComponenteDao mDao = new MoldeComponenteDao();
                    mDao.persistir(md);
                    TransactionManager.commit();
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso! ");
                    transferirMoldeComponenteParaAstec(md);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar salvar! " + e);
                    TransactionManager.rollback();
                }
            }
        }
    }

    private void transferirMoldeComponenteParaAstec(MoldeComponente md) {
        HashSistema.hash.put("moldeComponente", md);
        novo();
        dispose();
    }

    private void pesquisar() {
        Dialog jd = new JDialogPesquisaMoldeComponente(null, true);
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
        MoldeComponente c = (MoldeComponente) HashSistema.hash.get("moldeComponentePesquisa");
        HashSistema.hash.remove("moldeComponentePesquisa");
        if (c != null) {
            jTextFieldIDCompAstec.setText(String.valueOf(c.getId()));
            jTextFieldNumeroSerie.setText(c.getNumeroIdentificacao());
            componenteAux = c.getComponente();
            jTextFieldNomeComponente.setText(c.getComponente().getNome().trim());
            jTextFieldValor.setText(String.valueOf(c.getValorFinalComponente()));
            //preencherOsCamposComOComponente(c.getComponente());
        } else {
            return;
        }
    }

    private void remover() {
        if (jTextFieldIDCompAstec.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não pode excluir, ID inválido.");
            return;
        } else {
            int opcao = JOptionPane.showConfirmDialog(rootPane,
                    "Deseja remover?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (opcao != JOptionPane.YES_OPTION) {
                return;
            }
            int id = Integer.parseInt(jTextFieldIDCompAstec.getText());
            TransactionManager.beginTransaction();
            try {
                MoldeComponenteDao mDao = new MoldeComponenteDao();
                MoldeComponente molde = mDao.obterPorId(id);

                if (molde != null) {
                    mDao.remover(molde);
                    TransactionManager.commit();
                    JOptionPane.showMessageDialog(null, "Removido com sucesso!");
                    novo();
                } else {
                    return;
                }
            } catch (ConstraintViolationException z) {
                TransactionManager.rollback();
                JOptionPane.showMessageDialog(null, "Você não pode excluir um componente ligado a um equipamento ou assitência. ");
                return;
            } catch (Exception e) {
                TransactionManager.rollback();
                JOptionPane.showMessageDialog(null, "Erro inesperado. " + e);
                return;
            }
        }
    }
}