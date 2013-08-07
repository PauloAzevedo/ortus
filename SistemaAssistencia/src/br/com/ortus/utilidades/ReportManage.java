/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.utilidades;


import br.com.ortus.configuracaoPersistencia.Conexao;
import br.com.ortus.configuracaoPersistencia.HibernateConfiguracao;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ehrickwilliam
 */
public class ReportManage {

    private final float CM_PIXEL_FACTOR = new Float(28.345);

    private int toPixels(float cmm) {
        return Math.round(cmm * CM_PIXEL_FACTOR);
    }

    private static JRDataSource getJRDataSource(List hql) {
        JRBeanArrayDataSource result = new JRBeanArrayDataSource(hql.toArray());
        return result;
    }

    public void relatorioDeConsultaHQL(String hql) throws SQLException, JRException {

        List<Object> resultado = HibernateConfiguracao.runHQLQuery(hql);

        if (!resultado.isEmpty() && resultado != null) {
            Field[] fields = resultado.get(0).getClass().getDeclaredFields();
            /* DESIGN DO RELATÓRIO */
            JasperDesign jasperDesign = new JasperDesign();
            jasperDesign.setName("Relatorios");
            jasperDesign.setPageHeight(toPixels(21));
            jasperDesign.setPageWidth(toPixels(27.9f));
            jasperDesign.setOrientation(OrientationEnum.LANDSCAPE);


            /* TITLE BAND */
            JRDesignBand titleBand = new JRDesignBand();
            titleBand.setHeight(toPixels(1.5f));
            jasperDesign.setTitle(titleBand);


            /* TITLE TEXT */
            JRDesignStaticText titleText = new JRDesignStaticText();
            titleText.setHeight(toPixels(1.4f));
            titleText.setWidth(toPixels(5));
            titleText.setX(toPixels(11.8f));
            titleText.setText("" + resultado.get(0).getClass().getSimpleName());
            titleText.setBold(Boolean.TRUE);
            titleText.setFontSize(15);
            titleText.setForecolor(Color.BLUE);
            titleBand.addElement(titleText);

            /* HEADER BAND */
            JRDesignBand headerBand = new JRDesignBand();
            headerBand.setHeight(toPixels(1.5f));
            jasperDesign.setPageHeader(headerBand);

            /* HEADER FIELDS TEXT */
            int espacoTitlesColunas = 0;
            for (Field field : fields) {
                if (field.getType() != List.class) {
                    /* PREPARA O TEXTO DO CAMPO */
                    JRDesignStaticText headerText = new JRDesignStaticText();
                    headerText.setHeight(toPixels(1.4f));
                    headerText.setWidth(toPixels(4));
                    headerText.setX(espacoTitlesColunas);
                    headerText.setText(field.getName().toUpperCase());
                    headerBand.addElement(headerText);

                    /* Incrementa a posição x para a próxima coluna 
                     para 5cm*/
                    espacoTitlesColunas += toPixels(3);

                    // DISPONIBILIZA A PROPRIEDADE ATUAL DA CLASSE 
                    JRDesignField fieldJasper = new JRDesignField();
                    fieldJasper.setName(field.getName());
                    fieldJasper.setValueClass(field.getType());
                    jasperDesign.addField(fieldJasper);
                }
            }

            /* DETAIL BAND - NA VERSÂO 4.x do JASPER não tem mais setDetail(JRBHand) */
            JRDesignBand detailBand = new JRDesignBand();
            detailBand.setHeight(toPixels(1.0f));
            ((JRDesignSection) jasperDesign.getDetailSection()).addBand(detailBand);

            /* DETAIL FIELDS DATA */
            espacoTitlesColunas = 0;
            for (Field field : fields) {
                if (field.getType() != List.class) {
                    JRDesignTextField detailFieldText = new JRDesignTextField();
                    detailFieldText.setHeight(toPixels(1.0f));
                    detailFieldText.setWidth(toPixels(4));
                    detailFieldText.setX(espacoTitlesColunas);
                    detailFieldText.setExpression(new JRDesignExpression("$F{" + field.getName() + "}"));
                    detailBand.addElement(detailFieldText);
                    /* Incrementa a posição x para a próxima coluna 
                     para 5cm*/
                    espacoTitlesColunas += toPixels(3);
                }
            }

            /* COMPILA */
            JasperReport jasperCompilado = JasperCompileManager.compileReport(jasperDesign);
            /* PREENCHE O RELATÓRIO COM OS DADOS */
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperCompilado, null, getJRDataSource(resultado));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            /* VISUALIZA COM DADOS */
            jasperViewer.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "não é possivel montar relatorios que não possuem paginas");
        }
    }

    public void relatorioPronto(String relatorio, String titulo) throws JRException, SQLException {
        JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
        URL url = this.getClass().getResource("/br/com/okaynet/andare/icons/faststone.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        viewer.setIconImage(imagemTitulo);
        viewer.setSize(900, 600);
        viewer.setLocationRelativeTo(null);
        // obtem o arquivo de relatorio compilado
        URL arquivo = getClass().getResource("/br/com/okaynet/andare/reports/" + relatorio + ".jasper");
        // carrega o relatorio
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);
        // preenche o relatorio com os dados do BD
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), Conexao.getConnectionJasper());
        // cria visualizador de relatorio
        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
        // mostra o visualizador
        viewer.getContentPane().add(jrviewer.getContentPane());
        viewer.setVisible(true);
    }
}
