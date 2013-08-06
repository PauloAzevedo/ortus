/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author a1028367
 */
@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCidade;
    private String cidade;   
    
    @OneToOne
    private Estado estado;
//    @OneToMany
//    private List<Endereco> enderecoList;

    public Cidade() {
    }

    public Cidade(Integer id) {
        this.idCidade = id;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setId(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setNome(String nome) {
        this.cidade = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }  

   

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.idCidade == null && other.idCidade != null) || (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cidade + " - " + estado.getSigla();
    }
    
    
    
}
