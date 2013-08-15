/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import java.io.File;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Paulo Azevedo
 */
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoOrtus;
    private String nome;
    @Column(name = "descricao", length = 300)
    private String descricao;
    @OneToOne
    private UnidadeMedida unidMedida;
    private Double valor;
    
    private File foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescrição(String descricao) {
        this.descricao = descricao;
    }

    public UnidadeMedida getUnidMedida() {
        return unidMedida;
    }

    public void setUnidMedida(UnidadeMedida unidMedida) {
        this.unidMedida = unidMedida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCodigoOrtus() {
        return codigoOrtus;
    }

    public void setCodigoOrtus(String codigoOrtus) {
        this.codigoOrtus = codigoOrtus;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

   
   
}
