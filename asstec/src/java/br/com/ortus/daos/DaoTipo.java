/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daos;

import br.com.ortus.beans.Tipo;
import org.hibernate.Query;

/**
 *
 * @author a1028367
 */
public class DaoTipo extends DaoGenerics<Tipo> {
    public DaoTipo() {
        super.alvo = Tipo.class;
    }

    public Tipo obterPorNome(String tipo) {
        Tipo tipoRetorno = null;
        if (tipo != null) {
            Query select = session.createQuery("From " + alvo.getSimpleName() + " where tipo = '" + tipo + "'");
            tipoRetorno = (Tipo) select.uniqueResult();
        }
        return tipoRetorno;
    }
}
