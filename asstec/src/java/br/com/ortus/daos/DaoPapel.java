/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daos;

import br.com.ortus.beans.Papel;
import org.hibernate.Query;

/**
 *
 * @author a1028367
 */
public class DaoPapel extends DaoGenerics<Papel> {

    public DaoPapel() {
        super.alvo = Papel.class;
    }

    public Papel obterPorNome(String papel) {
        Papel papelRetorno = null;
        if (papel != null) {
            Query select = session.createQuery("From " + alvo.getSimpleName() + " where nome = '" + papel + "'");
            papelRetorno = (Papel) select.uniqueResult();
        }
        return papelRetorno;
    }
}
