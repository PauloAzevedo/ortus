/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daosSistema;

import br.com.ortus.beans.Assistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AssistenciaDao extends BaseDao<Assistencia> {
    
    public AssistenciaDao(){
        super(Assistencia.class);
    }
    
    public List<Assistencia> obterPorNomeDeUsuario(String filtro){
        List<Assistencia> lista = new ArrayList<Assistencia>();
        //lista = this.obterListaFiltroCompleto("FROM Assistencia as a INNER JOIN Cliente as c ON a.cliente_id=c.id WHERE c.nome LIKE '%"+filtro+"%'");
        lista = this.obterListaFiltroCompleto("FROM Assistencia as a, Cliente as c  WHERE c.nome LIKE '%"+filtro+"%'");
        return lista;
    }
}
