/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daosSistema;

import java.util.List;

/**
 *
 * @author a1028367
 */
public interface Dao<T> {    
    void persistir(T o);

    void remover(T o);

    T obterPorId(int id);

    List<T> obterLista(String filtro);

    List<T> obterLista();    
}
