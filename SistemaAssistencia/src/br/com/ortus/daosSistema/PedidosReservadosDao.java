/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daosSistema;

import br.com.ortus.beans.PedidosReservados;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class PedidosReservadosDao extends BaseDao<PedidosReservados> {
    
    public PedidosReservadosDao(){
        super(PedidosReservados.class);
    }
    
    public List<PedidosReservados> obterTrocas(String filtro){
        return obterListaFiltroCompleto("FROM PedidosReservados as t WHERE t.status='"+filtro+"'"); 
    }
    
}
