package model;

import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import connection.Connection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ModelComputadores {

    private Integer idComputador;
    private String ipComputador;
    private String hostName;
    private String sistemaOperacional;
    private String modeloProcessador;
    private String idProcessador;
    private Double tamanhoDisco;
    private Double tamanhoDiscoSecundario;
    private Double tamanhoRam;
    private Integer fkUsuario;
    
    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());
    Sistema sistema = new Sistema();
    Processador processador = new Processador();
    DiscosGroup disco = new DiscosGroup();
    Memoria memoria = new Memoria();

    public Integer getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Integer idComputador) {
        this.idComputador = idComputador;
    }
    
    public String getIpComputador() throws UnknownHostException {
        ipComputador = InetAddress.getLocalHost().getHostAddress();
        return ipComputador;
    }

    public String getHostName() throws UnknownHostException {
        hostName = InetAddress.getLocalHost().getHostName();
        return hostName;
    }
    
    public String getSistemaOperacional() {
        return sistema.getSistemaOperacional();
    }

    public String getModeloProcessador() {
        return processador.getNome();
    }

    public String getIdProcessador() {
        return processador.getId();
    }

    public Double getTamanhoDisco() {
        tamanhoDisco = Double.valueOf(disco.getVolumes().get(0).getTotal());
        tamanhoDisco /= 1000000000;
        return tamanhoDisco;
    }

    public Double getTamanhoDiscoSecundario() {
        for (int i = 0; i < disco.getVolumes().size(); i++) {
            if (i > 0) {
                tamanhoDiscoSecundario = Double.valueOf(disco.getVolumes().get(i).getTotal());
                tamanhoDiscoSecundario /= 1000000000;
            } else { 
                tamanhoDiscoSecundario = null;
            }
        }
        return tamanhoDiscoSecundario;
    }

    public Double getTamanhoRam() {
        tamanhoRam = Double.valueOf(memoria.getTotal());
        tamanhoRam /= 1000000000;
        return tamanhoRam;
    }

    public Integer getFkUsuario() {
        return fkUsuario = 1;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }
    
}
