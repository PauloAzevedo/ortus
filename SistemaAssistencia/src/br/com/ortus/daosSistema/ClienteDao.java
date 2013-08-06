/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daosSistema;

import br.com.ortus.beans.Cliente;

/**
 *
 * @author Usuario
 */
public class ClienteDao extends BaseDao<Cliente> {
    
    public ClienteDao(){
        super(Cliente.class);
    }
}
