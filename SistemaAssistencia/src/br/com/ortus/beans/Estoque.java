/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ortus.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Paulo
 */
@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer biojato;
    private Integer bioscalerCB;
    private Integer bioscalerSB;
    private Integer soniI;
    private Integer soniII;
    private Integer ledLuxI;
    private Integer ledLuxII;
    private Integer kitLedLux;
    private Integer kitOrtusonic;
    private Integer kitJato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBiojato() {
        return biojato;
    }

    public void setBiojato(Integer biojato) {
        this.biojato = biojato;
    }

    public Integer getBioscalerCB() {
        return bioscalerCB;
    }

    public void setBioscalerCB(Integer bioscalerCB) {
        this.bioscalerCB = bioscalerCB;
    }

    public Integer getBioscalerSB() {
        return bioscalerSB;
    }

    public void setBioscalerSB(Integer bioscalerSB) {
        this.bioscalerSB = bioscalerSB;
    }

    public Integer getSoniI() {
        return soniI;
    }

    public void setSoniI(Integer soniI) {
        this.soniI = soniI;
    }

    public Integer getSoniII() {
        return soniII;
    }

    public void setSoniII(Integer soniII) {
        this.soniII = soniII;
    }

    public Integer getLedLuxI() {
        return ledLuxI;
    }

    public void setLedLuxI(Integer ledLuxI) {
        this.ledLuxI = ledLuxI;
    }

    public Integer getLedLuxII() {
        return ledLuxII;
    }

    public void setLedLuxII(Integer ledLuxII) {
        this.ledLuxII = ledLuxII;
    }

    public Integer getKitLedLux() {
        return kitLedLux;
    }

    public void setKitLedLux(Integer kitLedLux) {
        this.kitLedLux = kitLedLux;
    }

    public Integer getKitOrtusonic() {
        return kitOrtusonic;
    }

    public void setKitOrtusonic(Integer kitOrtusonic) {
        this.kitOrtusonic = kitOrtusonic;
    }

    public Integer getKitJato() {
        return kitJato;
    }

    public void setKitJato(Integer kitJato) {
        this.kitJato = kitJato;
    }
    
    
    
}
