/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daosSistema;

import br.com.ortus.beans.ControleAcesso;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class ControleAcessoDao extends BaseDao<ControleAcesso> {

    public ControleAcessoDao() {
        super(ControleAcesso.class);
    }
    
    public ControleAcesso obterPorIDUsuario(String filtro){
        ControleAcesso controle = new ControleAcesso();
        //lista = this.obterListaFiltroCompleto("FROM Assistencia as a INNER JOIN Cliente as c ON a.cliente_id=c.id WHERE c.nome LIKE '%"+filtro+"%'");
        List<ControleAcesso> lista = this.obterListaFiltroCompleto("FROM ControleAcesso WHERE usuario_id='"+filtro+"'");
        if(!lista.isEmpty()){
            controle = lista.get(0);
        }
        return controle;
    }
}
