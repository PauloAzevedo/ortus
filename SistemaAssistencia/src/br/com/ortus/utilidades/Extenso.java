/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.utilidades;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ehrickwilliam
 */
public class Extenso {

    private ArrayList nro;
    private BigInteger num;
    private String Qualificadores[][] = {{"centavo", "centavos"},
        {"", ""}, {"mil", "mil"}, {"milhão", "milhões"},
        {"bilhão", "bilhões"}, {"trilhão", "trilhões"},
        {"quatrilhão", "quatrilhões"}, {"quintilhão", "quintilhões"},
        {"sextilhão", "sextilhões"}, {"septilhão", "septilhões"}};
    private String Numeros[][] = {
        {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete",
            "oito", "nove", "dez", "onze", "doze", "treze", "quatorze",
            "quinze", "desesseis", "desessete", "dezoito", "desenove"},
        {"vinte", "trinta", "quarenta", "cinquenta", "sessenta",
            "setenta", "oitenta", "noventa"},
        {"cem", "cento", "duzentos", "trezentos", "quatrocentos",
            "quinhentos", "seiscentos", "setecentos", "oitocentos",
            "novecentos"}};

    public Extenso() {
        nro = new ArrayList();
    }

    public Extenso(BigDecimal dec) {
        this();
        setNumber(dec);
    }

    public Extenso(double dec) {
        this();
        setNumber(dec);
    }

    public void setNumber(BigDecimal dec) {
        // Converte para inteiro arredondando os centavos  
        num = dec.setScale(2, BigDecimal.ROUND_HALF_UP).multiply(
                BigDecimal.valueOf(100)).toBigInteger();

        // Adiciona valores  
        nro.clear();
        if (num.equals(BigInteger.ZERO)) {
            // Centavos  
            nro.add(new Integer(0));
            // Valor  
            nro.add(new Integer(0));
        } else {
            // Adiciona centavos  
            addRemainder(100);

            // Adiciona grupos de 1000  
            while (!num.equals(BigInteger.ZERO)) {
                addRemainder(1000);
            }
        }
    }

    public void setNumber(double dec) {
        setNumber(new BigDecimal(dec));
    }

    public void show() {
        Iterator valores = nro.iterator();

        while (valores.hasNext()) {
            System.out.println(((Integer) valores.next()).intValue());
        }
        System.out.println(toString());
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();

        int numero = ((Integer) nro.get(0)).intValue();
        int ct;

        for (ct = nro.size() - 1; ct > 0; ct--) {
            // Se ja existe texto e o atual não é zero  
            if (buf.length() > 0 && !ehGrupoZero(ct)) {
                buf.append(" e ");
            }
            buf.append(numToString(((Integer) nro.get(ct)).intValue(), ct));
        }
        if (buf.length() > 0) {
            if (ehUnicoGrupo()) {
                buf.append(" de ");
            }
            while (buf.toString().endsWith(" ")) {
                buf.setLength(buf.length() - 1);
            }
            if (ehPrimeiroGrupoUm()) {
                buf.insert(0, "h");
            }
            if (nro.size() == 2 && ((Integer) nro.get(1)).intValue() == 1) {
                buf.append(" real");
            } else {
                buf.append(" reais");
            }
            if (((Integer) nro.get(0)).intValue() != 0) {
                buf.append(" e ");
            }
        }
        if (((Integer) nro.get(0)).intValue() != 0) {
            buf.append(numToString(((Integer) nro.get(0)).intValue(), 0));
        }
        return buf.toString();
    }

    private boolean ehPrimeiroGrupoUm() {
        if (((Integer) nro.get(nro.size() - 1)).intValue() == 1) {
            return true;
        }
        return false;
    }

    private void addRemainder(int divisor) {
        BigInteger[] newNum = num.divideAndRemainder(BigInteger
                .valueOf(divisor));
        nro.add(new Integer(newNum[1].intValue()));
        num = newNum[0];
    }

    private boolean temMaisGrupos(int ps) {
        for (; ps > 0; ps--) {
            if (((Integer) nro.get(ps)).intValue() != 0) {
                return true;
            }
        }

        return false;
    }

    private boolean ehUltimoGrupo(int ps) {
        return (ps > 0) && ((Integer) nro.get(ps)).intValue() != 0
                && !temMaisGrupos(ps - 1);
    }

    private boolean ehUnicoGrupo() {
        if (nro.size() <= 3) {
            return false;
        }
        if (!ehGrupoZero(1) && !ehGrupoZero(2)) {
            return false;
        }
        boolean hasOne = false;
        for (int i = 3; i < nro.size(); i++) {
            if (((Integer) nro.get(i)).intValue() != 0) {
                if (hasOne) {
                    return false;
                }
                hasOne = true;
            }
        }
        return true;
    }

    boolean ehGrupoZero(int ps) {
        if (ps <= 0 || ps >= nro.size()) {
            return true;
        }
        return ((Integer) nro.get(ps)).intValue() == 0;
    }

    private String numToString(int numero, int escala) {
        int unidade = (numero % 10);
        int dezena = (numero % 100);
        int centena = (numero / 100);
        StringBuffer buf = new StringBuffer();

        if (numero != 0) {
            if (centena != 0) {
                if (dezena == 0 && centena == 1) {
                    buf.append(Numeros[2][0]);
                } else {
                    buf.append(Numeros[2][centena]);
                }
            }

            if ((buf.length() > 0) && (dezena != 0)) {
                buf.append(" e ");
            }
            if (dezena > 19) {
                dezena /= 10;
                buf.append(Numeros[1][dezena - 2]);
                if (unidade != 0) {
                    buf.append(" e ");
                    buf.append(Numeros[0][unidade]);
                }
            } else if (centena == 0 || dezena != 0) {
                buf.append(Numeros[0][dezena]);
            }

            buf.append(" ");
            if (numero == 1) {
                buf.append(Qualificadores[escala][0]);
            } else {
                buf.append(Qualificadores[escala][1]);
            }
        }

        return buf.toString();
    }

    public static void main(String[] args) {

        Extenso teste = new Extenso(new BigDecimal(18453532.89));
        System.out.println("Numero  : "
                + (new DecimalFormat().format(Double.valueOf(18453532.89))));
        System.out.println("Extenso : " + teste.toString());
    }
}
