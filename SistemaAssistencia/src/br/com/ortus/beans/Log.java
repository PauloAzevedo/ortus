/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Paulo
 */
@Entity
public class Log {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Usuario usuario;
    private String momentoLog;
    private String modo;
    private String tipo;
    private String ip;
//    @ManyToOne
//    private TabelaTroca tabelaTroca;

    public Log() {
    }

    public Log(Usuario usuario, String momentoLog, String modo, String tipo, String ip) {
        this.usuario = usuario;
        this.momentoLog = momentoLog;
        this.modo = modo;
        this.tipo = tipo;
        this.ip = ip;
        
    }

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getMomentoLog() {
        return momentoLog;
    }

    public void setMomentoLog(String momentoLog) {
        this.momentoLog = momentoLog;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    
    
}
