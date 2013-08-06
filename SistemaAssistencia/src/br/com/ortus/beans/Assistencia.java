/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Paulo Azevedo
 */
@Entity
public class Assistencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Cliente cliente;
    @OneToMany
    private List<Equipamento> equipamentos;
    @OneToMany
    private List<MoldeComponente> moldeComponentes;    
    private Double valor;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataModificacao;
    private String dataInicio;
    private String dataFim;
    private String idCorreioEntrada;
    private String fretePagoEntrada;
    private Double valorFreteEntrada;
    private String dataChegadaFrete;
    private String idCorreioSaida;
    private String fretePagoSaida;
    private Double valorFreteSaida;
    private String dataSaidaFrete;
    
    @OneToOne
    private Atendimento atendimento;
    
    @ManyToOne
    private Usuario usuario;

    public Assistencia() {
        this.moldeComponentes = new ArrayList<MoldeComponente>() {};
        this.equipamentos = new ArrayList<Equipamento>();
    }    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<MoldeComponente> getMoldeComponentes() {
        return moldeComponentes;
    }

    public void setMoldeComponentes(List<MoldeComponente> moldeComponentes) {
        this.moldeComponentes = moldeComponentes;
    }

    

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Calendar dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataChegadaFrete() {
        return dataChegadaFrete;
    }

    public void setDataChegadaFrete(String dataChegadaFrete) {
        this.dataChegadaFrete = dataChegadaFrete;
    }

    public String getDataSaidaFrete() {
        return dataSaidaFrete;
    }

    public void setDataSaidaFrete(String dataSaidaFrete) {
        this.dataSaidaFrete = dataSaidaFrete;
    }

    public String getFretePagoEntrada() {
        return fretePagoEntrada;
    }

    public void setFretePagoEntrada(String fretePagoEntrada) {
        this.fretePagoEntrada = fretePagoEntrada;
    }

    public String getFretePagoSaida() {
        return fretePagoSaida;
    }

    public void setFretePagoSaida(String fretePagoSaida) {
        this.fretePagoSaida = fretePagoSaida;
    }

    public String getIdCorreioEntrada() {
        return idCorreioEntrada;
    }

    public void setIdCorreioEntrada(String idCorreioEntrada) {
        this.idCorreioEntrada = idCorreioEntrada;
    }

    public String getIdCorreioSaida() {
        return idCorreioSaida;
    }

    public void setIdCorreioSaida(String idCorreioSaida) {
        this.idCorreioSaida = idCorreioSaida;
    }

    public Double getValorFreteEntrada() {
        return valorFreteEntrada;
    }

    public void setValorFreteEntrada(Double valorFreteEntrada) {
        this.valorFreteEntrada = valorFreteEntrada;
    }

    public Double getValorFreteSaida() {
        return valorFreteSaida;
    }

    public void setValorFreteSaida(Double valorFreteSaida) {
        this.valorFreteSaida = valorFreteSaida;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
    
}
