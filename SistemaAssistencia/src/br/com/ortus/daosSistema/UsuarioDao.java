/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daosSistema;

import br.com.ortus.beans.Usuario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioDao extends BaseDao<Usuario> {

    public UsuarioDao() {
        super(Usuario.class);
    }

    public Usuario obterPorLogin(String login) {
        List<Usuario> lista = super.obterLista("login='" + login + "'");
        Usuario user = null;
        if (!lista.isEmpty()) {
            user = lista.get(0);
        }
        return user;
    }
}
