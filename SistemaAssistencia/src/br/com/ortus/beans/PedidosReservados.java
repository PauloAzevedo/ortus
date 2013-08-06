package br.com.ortus.beans;


import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author Paulo Azevedo
 * paulovulture@hotmail.com
 */
@Entity
public class PedidosReservados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dataEmissaoPedido;
    private Integer numeroPedido;
    private String nomeCliente;
    private String representante;
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
    
    
    private String dataPrevistaProducao;
    private String obs;
    private String status;
    
    private String dataPANoEstoque;
    
    private String dataEnvioPA;
    private String formaEnvio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
    

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
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

    

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

   
    
    
    public String pegarMetodo(int valor){
        String[] get = {"getBiojato()","getBioscalerCB()","getBioscalerSB()","getDetonix()","getLedLuxComFonte()","getOrtusonicCristofoli()","getOrtusonicOrtus()","getSoniII()"}; 
        return get[valor];
    }

    public String getFormaEnvio() {
        return formaEnvio;
    }

    public void setFormaEnvio(String formaEnvio) {
        this.formaEnvio = formaEnvio;
    }

    public String getDataEmissaoPedido() {
        return dataEmissaoPedido;
    }

    public void setDataEmissaoPedido(String dataEmissaoPedido) {
        this.dataEmissaoPedido = dataEmissaoPedido;
    }

    public String getDataPrevistaProducao() {
        return dataPrevistaProducao;
    }

    public void setDataPrevistaProducao(String dataPrevistaProducao) {
        this.dataPrevistaProducao = dataPrevistaProducao;
    }

    public String getDataPANoEstoque() {
        return dataPANoEstoque;
    }

    public void setDataPANoEstoque(String dataPANoEstoque) {
        this.dataPANoEstoque = dataPANoEstoque;
    }

    public String getDataEnvioPA() {
        return dataEnvioPA;
    }

    public void setDataEnvioPA(String dataEnvioPA) {
        this.dataEnvioPA = dataEnvioPA;
    }
    
    
    
}
