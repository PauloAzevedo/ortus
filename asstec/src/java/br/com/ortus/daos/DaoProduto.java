/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daos;

import br.com.ortus.beans.Produto;

/**
 *
 * @author Paulo Azevedo
 */
public class DaoProduto extends DaoGenerics<Produto>{
    public DaoProduto() {
        super.alvo = Produto.class;
    }
}
