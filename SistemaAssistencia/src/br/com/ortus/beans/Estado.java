/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {
    @Id
    private Integer idEstado;
    private String sigla;
    private String estado;    
    @OneToOne()    
    private Pais pais;

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais cod_pais) {
        this.pais = cod_pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String nom_estado) {
        this.estado = nom_estado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sgl_estado) {
        this.sigla = sgl_estado;
    }

    @Override
    public String toString() {
        return sigla + " " + estado;
    }
    
    
    
}
