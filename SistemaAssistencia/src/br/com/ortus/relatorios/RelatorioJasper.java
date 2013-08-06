package br.com.ortus.relatorios;


import br.com.ortus.configuracaoPersistencia.DBConnection;
import br.com.ortus.configuracaoPersistencia.HibernateConfiguracao;
import java.awt.Color;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ehrickwilliam
 */
public class RelatorioJasper {

    private final float CM_PIXEL_FACTOR = new Float(28.345);
    
    private Integer integer = 0;

    private int toPixels(float cmm) {
        return Math.round(cmm * CM_PIXEL_FACTOR);
    }

    private static JRDataSource getJRDataSource(List hql) {
        JRBeanArrayDataSource result = new JRBeanArrayDataSource(hql.toArray());
        return result;
    }

    public void relatorioDeConsultaHQL(String hql) throws SQLException, JRException {

        List<Object> resultado = HibernateConfiguracao.runHQLQuery(hql);

        for (Object object : resultado) {
            System.out.println(object);
        }

        if (!resultado.isEmpty() && resultado != null) {
            Field[] fields = resultado.get(0).getClass().getDeclaredFields();
            /* DESIGN DO RELATORIO */
            JasperDesign jasperDesign = new JasperDesign();
            jasperDesign.setName("Relatorios Compre Aqui");
            jasperDesign.setPageHeight(toPixels(21));
            jasperDesign.setPageWidth(toPixels(27.9f));

            /* TITLE BAND */
            JRDesignBand titleBand = new JRDesignBand();
            titleBand.setHeight(toPixels(1.5f));
            jasperDesign.setTitle(titleBand);


            /* TITLE TEXT */
            JRDesignStaticText titleText = new JRDesignStaticText();
            titleText.setHeight(toPixels(1.4f));
            titleText.setWidth(toPixels(20));
            titleText.setX(toPixels(9));
            titleText.setText(" || Compre Aqui - Relatorio de " + resultado.get(0).getClass().getSimpleName() + " ||");
            titleText.setBold(Boolean.TRUE);
            titleText.setForecolor(Color.BLUE);
            titleText.setFontSize(11);
            titleBand.addElement(titleText);

            /* HEADER BAND */
            JRDesignBand headerBand = new JRDesignBand();
            headerBand.setHeight(toPixels(1.5f));
            jasperDesign.setPageHeader(headerBand);

            /* HEADER FIELDS TEXT */
            int espacoTitlesColunas = 0;
            for (Field field : fields) {
                /* PREPARA O TEXTO DO CAMPO */
                JRDesignStaticText headerText = new JRDesignStaticText();
                headerText.setHeight(toPixels(1.4f));
                System.out.println(field.getType().getSimpleName().toString());
                if (field.getType().getSimpleName().toString().equals("Integer")){
                    headerText.setWidth(toPixels(1));
                } else {
                    headerText.setWidth(toPixels(2.7f));
                }
                headerText.setX(espacoTitlesColunas);
                headerText.setText(field.getName().toUpperCase());
                headerBand.addElement(headerText);

                /* Incrementa a posiÃ§Ã£o x para a prÃ³xima coluna 
                para 5cm*/
                espacoTitlesColunas += toPixels(2.7f);

                // DISPONIBILIZA A PROPRIEDADE ATUAL DA CLASSE 
                JRDesignField fieldJasper = new JRDesignField();
                fieldJasper.setName(field.getName());
                fieldJasper.setValueClass(field.getType());
                jasperDesign.addField(fieldJasper);
            }

            /* DETAIL BAND - NA VERSÃ‚O 4.x do JASPER nÃ£o tem mais setDetail(JRBHand) */
            JRDesignBand detailBand = new JRDesignBand();
            detailBand.setHeight(toPixels(1.5f));

            ((JRDesignSection) jasperDesign.getDetailSection()).addBand(detailBand);

            /* DETAIL FIELDS DATA */
            espacoTitlesColunas = 0;
            for (Field field : fields) {
                JRDesignTextField detailFieldText = new JRDesignTextField();
                detailFieldText.setHeight(toPixels(1.4f));
                detailFieldText.setWidth(toPixels(2.7f));
                detailFieldText.setX(espacoTitlesColunas);
                detailFieldText.setExpression(new JRDesignExpression("$F{" + field.getName() + "}"));
                detailBand.addElement(detailFieldText);
                /* Incrementa a posiÃ§Ã£o x para a prÃ³xima coluna 
                para 5cm*/
                espacoTitlesColunas += toPixels(2.7f);
            }

            /* COMPILA */
            JasperReport jasperCompilado = JasperCompileManager.compileReport(jasperDesign);
            /* PREENCHE O RELATÃ“RIO COM OS DADOS */
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperCompilado, null, getJRDataSource(resultado));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            /* VISUALIZA COM DADOS */
            jasperViewer.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "nÃ£o Ã© possivel montar relatorios que nÃ£o possuem paginas");
        }
    }

    public void relatorioPronto(String relatorio) throws JRException, SQLException {
        // obtem o arquivo de relatorio compilado
        URL arquivo = getClass().getResource("br.com.ortus.relatoriosbr.com.ortus.relatorios/" + relatorio + ".jasper");
        // carrega o relatorio
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);
        // preenche o relatorio com os dados do BD
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), DBConnection.getConnection());
        // cria visualizador de relatorio
        JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
        // mostra o visualizador
        jrviewer.setVisible(true);
    }
}
