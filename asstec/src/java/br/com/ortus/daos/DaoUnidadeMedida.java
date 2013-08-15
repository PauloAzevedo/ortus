/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daos;

import br.com.ortus.beans.UnidadeMedida;
import org.hibernate.Query;

/**
 *
 * @author Paulo Azevedo
 */
public class DaoUnidadeMedida extends DaoGenerics<UnidadeMedida>{
    public DaoUnidadeMedida(){
        super.alvo = UnidadeMedida.class;
    }
    
    public UnidadeMedida obterPorNome(String papel) {
        UnidadeMedida unidadeRetorno = null;
        if (papel != null) {
            Query select = session.createQuery("From " + alvo.getSimpleName() + " where nome = '" + papel + "'");
            unidadeRetorno = (UnidadeMedida) select.uniqueResult();
        }
        return unidadeRetorno;
    }
}
