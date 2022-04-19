package model;

/**
 *
 * @author Matheus Mattos
 */
public class Computadores {

    private Integer idEquipamento;
    private String marca;
    private String sistemaOperacional;
    private String arquitetura;
    private String modeloProcessador;
    private Double qtdMemoriaRam;
    private Double qtdDiscoRigido;

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }

    public String getModeloProcessador() {
        return modeloProcessador;
    }

    public void setModeloProcessador(String modeloProcessador) {
        this.modeloProcessador = modeloProcessador;
    }

    public Double getQtdMemoriaRam() {
        return qtdMemoriaRam;
    }

    public void setQtdMemoriaRam(Double qtdMemoriaRam) {
        this.qtdMemoriaRam = qtdMemoriaRam;
    }

    public Double getQtdDiscoRigido() {
        return qtdDiscoRigido;
    }

    public void setQtdDiscoRigido(Double qtdDiscoRigido) {
        this.qtdDiscoRigido = qtdDiscoRigido;
    }

}
