/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daosSistema;

import br.com.ortus.beans.TabelaTroca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class TabelaTrocaDao extends BaseDao<TabelaTroca> {
    
    public TabelaTrocaDao(){
        super(TabelaTroca.class);
    }
    
    public List<TabelaTroca> obterTrocas(String filtro){
        List<TabelaTroca> trocas = new ArrayList<TabelaTroca>();
        if(filtro.equals("Enviado")){
            trocas = obterListaFiltroCompleto("FROM TabelaTroca as t WHERE t.statusProducao='Enviado'");
        }else if(filtro.equals("Pendente")){
            trocas = obterListaFiltroCompleto("FROM TabelaTroca as t WHERE t.statusProducao='Pendente' OR t.statusProducao='Pronto'");
        }else if(filtro.equals("Estoque")){
            trocas = obterListaFiltroCompleto("FROM TabelaTroca as t WHERE t.statusProducao='Estoque'");
        }
        return trocas;
    }
    
}
