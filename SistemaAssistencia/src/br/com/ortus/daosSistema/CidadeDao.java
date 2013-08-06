/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daosSistema;


import br.com.ortus.beans.Cidade;
import java.util.List;

/**
 *
 * @author a1028367
 */
public class CidadeDao extends BaseDao<Cidade>{

    public CidadeDao() {
        super(Cidade.class);
    }
    
    
    
    public List<Cidade> listarCidadesPorEstado(String estado){        
        return super.obterLista("estado_idEstado='"+estado+"'");
    }    
    
}
