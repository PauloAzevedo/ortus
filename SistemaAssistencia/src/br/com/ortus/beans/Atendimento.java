/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Usuario
 */
@Entity
public class Atendimento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer numeroRA;
    @Column(length=500)
    private String reclamacao;
    private Boolean resolvidoPorTelefone;
    @Column(length=500)
    private String acaoImediata;
    
    private Boolean finalizado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroRA() {
        return numeroRA;
    }

    public void setNumeroRA(Integer numeroRA) {
        this.numeroRA = numeroRA;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }    
    
    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public Boolean getResolvidoPorTelefone() {
        return resolvidoPorTelefone;
    }

    public void setResolvidoPorTelefone(Boolean resolvidoPorTelefone) {
        this.resolvidoPorTelefone = resolvidoPorTelefone;
    }

    public String getAcaoImediata() {
        return acaoImediata;
    }

    public void setAcaoImediata(String acaoImediata) {
        this.acaoImediata = acaoImediata;
    }
}
