/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.utilidades;

import br.com.ortus.beans.Usuario;
import br.com.ortus.daosSistema.UsuarioDao;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo Azevedo email: paulovulture@hotmail.com 12/2011 - 01/2012
 */
public class Utilidades {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat dateFormatCompleto = new SimpleDateFormat("dd/MM/yyyy -- HH:mm:ss");

    public boolean verificarSeEntradaENumeroInteger(String entrada) {
        try {
            Integer.parseInt(entrada);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Nessa pesquisa informe um número.");
            return false;
        }
    }

    public boolean verificarSeEntradaENumeroDouble(String entrada) {
        try {
            Double.parseDouble(entrada);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Informe um número para preço.");
            return false;
        }
    }

    public String formatarValorDoubleParaString(Double valor) {
        String valorFinal = "";
        DecimalFormat nf = new DecimalFormat("0.00");
        valorFinal = nf.format(valor);
        return valorFinal;
    }

    public String dateParaDataEHora(Date cal) {
        //System.out.println(cal.getTime());
        return dateFormatCompleto.format(cal.getTime());
    }

    public Double formatarValorStringParaDouble(String valor) {
        String valorFinal = valor.replace(",", ".");

        return Double.parseDouble(valorFinal);
    }

    public String tirarAVirgulaDoValor(String valor) {
        String valorFinal = valor.replace(",", ".");

        return valorFinal;
    }

    public Double calcularDescontoICMS(Double porc, Double valor) {
        Double resultado = 0.0;
        resultado = valor - (valor * (porc / 100));
        return resultado;
    }

    public Calendar stringToCalendar(String data) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(data));
            return c;
        } catch (ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String calendarToString(Calendar cal) {
        return dateFormat.format(cal.getTime());
    }

    public String pegarSenha(char[] pass) {
        String senha = "";
        for (int i = 0; i < pass.length; i++) {
            senha += pass[i];
        }
        return senha;
    }

    public static void abrirDialogCentralizado(JDialog dialog) {
        dialog.setLocation((dialog.getParent().getWidth() - dialog.getWidth()) / 2,
                (dialog.getParent().getHeight() - dialog.getHeight()) / 2);
        dialog.setVisible(true);
    }

    public boolean verificarSeUsuarioEOAdmin(Integer id) {
        Usuario user = new UsuarioDao().obterPorId(id);
        if (user.getLogin().equals("admin")) {
            return true;
        }
        return false;
    }

    public static String retData() {
        return new SimpleDateFormat("dd/MM/yyyy -- hh:mm:ss").format(new Date()).toString();
    }
}
