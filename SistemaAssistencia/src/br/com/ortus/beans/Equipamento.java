/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Paulo Azevedo
 */
@Entity
public class Equipamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String numeroSerie;
    private String modelo;
    private Boolean garantia;
    private String[] acessorios;
    @ManyToOne
    private Usuario usuario;
    private String problemaConstatado;
    private String servicoETestes;    
    private String dataFabricacao; 
    
    @OneToMany
    private List<MoldeComponente> moldeComponentes;

    public List<MoldeComponente> getMoldeComponentes() {
        return moldeComponentes;
    }

    public void setMoldeComponentes(List<MoldeComponente> moldeComponentes) {
        this.moldeComponentes = moldeComponentes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String[] getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(String[] acessorios) {
        this.acessorios = acessorios;
    }

    public Boolean getGarantia() {
        return garantia;
    }

    public void setGarantia(Boolean garantia) {
        this.garantia = garantia;
    }

    public String getProblemaConstatado() {
        return problemaConstatado;
    }

    public void setProblemaConstatado(String problemaConstatado) {
        this.problemaConstatado = problemaConstatado;
    }

    public String getServicoETestes() {
        return servicoETestes;
    }

    public void setServicoETestes(String servicoETestes) {
        this.servicoETestes = servicoETestes;
    }

    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
}
