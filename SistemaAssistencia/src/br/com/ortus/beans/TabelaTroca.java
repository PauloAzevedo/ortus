/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Administrador
 */
@Entity
public class TabelaTroca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cliente;
    private String qtd;
    private String equipamento;
    private String dataPedido;
    private String dataMaxEnvio;
    private String obs;
    private String devolucao;
    private String statusProducao;
    private String dataProducao;
    
   
    @OneToMany
    private List<Log> momentoAuteracao;
    
    //private List<String> momentoAlteracao;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDataMaxEnvio() {
        return dataMaxEnvio;
    }

    public void setDataMaxEnvio(String dataMaxEnvio) {
        this.dataMaxEnvio = dataMaxEnvio;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(String dataProducao) {
        this.dataProducao = dataProducao;
    }    

    public String getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public String getStatusProducao() {
        return statusProducao;
    }

    public void setStatusProducao(String statusProducao) {
        this.statusProducao = statusProducao;
    }

    public List<Log> getMomentoAuteracao() {
        return momentoAuteracao;
    }

    public void setMomentoAuteracao(List<Log> momentoAuteracao) {
        this.momentoAuteracao = momentoAuteracao;
    }

}
