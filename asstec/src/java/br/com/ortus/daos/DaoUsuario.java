/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.daos;

import br.com.ortus.beans.Usuario;
import org.hibernate.Query;

/**
 *
 * @author Paulo Azevedo
 */
public class DaoUsuario extends DaoGenerics<Usuario>{
    public DaoUsuario() {
        super.alvo = Usuario.class;
    }
    
    public Usuario obterPorLogin(String usuario) {
        Usuario usuarioRetorno = null;
        if (usuario != null) {
            Query select = session.createQuery("From " + alvo.getSimpleName() + " where login = '" + usuario + "'");
            usuarioRetorno = (Usuario) select.uniqueResult();
        }
        return usuarioRetorno;
    }
}
