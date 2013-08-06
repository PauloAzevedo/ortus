/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import javax.persistence.*;

/**
 *
 * @author Paulo
 */
@Entity
public class ControleAcesso {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Usuario usuario;
    private String[] acessoMenuSuperio;
    private String[] acessoMenuPrincipal;

    public ControleAcesso() {
    }

    public String[] getAcessoMenuPrincipal() {
        return acessoMenuPrincipal;
    }

    public void setAcessoMenuPrincipal(String[] acessoMenuPrincipal) {
        this.acessoMenuPrincipal = acessoMenuPrincipal;
    }

    public String[] getAcessoMenuSuperio() {
        return acessoMenuSuperio;
    }

    public void setAcessoMenuSuperior(String[] acessoMenuSuperio) {
        this.acessoMenuSuperio = acessoMenuSuperio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

}
