/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "pais")
public class Pais implements Serializable {
    @Id
    private Integer idPais; 
    private String sigla;
    private String pais;

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    

    public String getPais() {
        return pais;
    }

    public void setPais(String nom_pais) {
        this.pais = nom_pais;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sgl_pais) {
        this.sigla = sgl_pais;
    }

    @Override
    public String toString() {
        return idPais + " - " + pais + " - " + sigla;
    }
    
    
}
