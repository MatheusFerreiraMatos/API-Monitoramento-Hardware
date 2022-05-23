package services;

import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import config.Connection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class Computador {

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

    List<Computador> computador;

    public void insertComputador(String email, String senha) throws UnknownHostException {

        System.out.println("-----------------------------[ Computador ]-----------------------------");
        System.out.println("Validando computador...");

        String sqlSelect = ("SELECT * FROM Computadores WHERE ipComputador = ? AND hostName = ?");

        computador = connect.query(sqlSelect,
                new BeanPropertyRowMapper<>(Computador.class),
                getIpComputador(),
                getHostName());

        if (computador.isEmpty()) {
            try {
                System.out.println("Computador não existente na base de dados.\ninserindo...\n");

                Integer idUsuario = 0;

                List<Usuario> listUser = connect.query("SELECT * FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
                        new BeanPropertyRowMapper(Usuario.class), email, senha);
                for (Usuario user : listUser) {
                    idUsuario = user.getIdUsuario();
                }

                String sqlInsert = "INSERT INTO Computadores"
                        + "(ipComputador, hostName, sistemaOperacional, modeloProcessador,"
                        + "idProcessador, tamanhoDisco, tamanhoDiscoSecundario,"
                        + "tamanhoRam, fkUsuario) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                connect.update(sqlInsert,
                        getIpComputador(),
                        getHostName(),
                        getSistemaOperacional(),
                        getModeloProcessador(),
                        getIdProcessador(),
                        getTamanhoDisco(),
                        getTamanhoDiscoSecundario(),
                        getTamanhoRam(),
                        idUsuario);

                System.out.println("Computador cadastrado com sucesso!!!");
            } catch (UnknownHostException ex) {
                Logger.getLogger(Computador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("\nComputador já existente na base de dados.\n\nBem-vindo de volta! \\(^-^)/");
        }
    }

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
