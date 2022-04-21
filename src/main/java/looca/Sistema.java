package looca;

/**
 *
 * @author Matheus Mattos
 */
public class Sistema {

    private Integer idEquipamento;
    private String marca;
    private String sistemaOperacional;
    private Integer arquitetura;
    private String modeloProcessador;
    private Double qtdMemoriaRam;
    private Double qtdDiscoRigido;
    private String usuario;
    private String tesmpoAtividade;

    com.github.britooo.looca.api.group.sistema.Sistema sistema = new com.github.britooo.looca.api.group.sistema.Sistema();

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
        sistemaOperacional = sistema.getSistemaOperacional();
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getArquitetura() {
        arquitetura = sistema.getArquitetura();
        return arquitetura;
    }

    public void setArquitetura(Integer arquitetura) {
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

    public String getUsuario() {
        return System.getProperty("user.name");
    }

    public String getTempoAtividade() {
        Long tempo = sistema.getTempoDeAtividade();

        Long segundos = tempo;
        int horas = (int) (segundos / 3600);
        segundos %= 3600;
        int minutos = (int) (segundos / 60);
        segundos %= 60;

        return horas + ":" + minutos + ":" + segundos;
    }
}
