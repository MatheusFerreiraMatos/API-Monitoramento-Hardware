package controller;

import connection.Connection;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.Log;
import model.ModelComputadores;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import view.TelaLogin;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerComputadores {

    Log log = new Log();

    Connection configAzure = new Connection();
    JdbcTemplate connectAzure = new JdbcTemplate(configAzure.getDataSource());
    Connection configMysql = new Connection(true);
    JdbcTemplate connectMysql = new JdbcTemplate(configMysql.getDataSource());

    ModelComputadores modelComputadores = new ModelComputadores();

    List<ModelComputadores> computador;

    public void insertComputador() throws UnknownHostException {

        System.out.println("-----------------------------[ Computador ]-----------------------------");
        log.append("-----------------------------[ Computador ]-----------------------------");
        System.out.println("Validando computador...");
        log.append("Validando computador...");

        String sqlSelect = ("SELECT * FROM Computadores WHERE idComputador = ? AND hostName = ?");

        computador = connectAzure.query(sqlSelect,
                new BeanPropertyRowMapper<>(ModelComputadores.class),
                modelComputadores.getIdComputador(),
                modelComputadores.getHostName());

        computador = connectMysql.query(sqlSelect,
                new BeanPropertyRowMapper<>(ModelComputadores.class),
                modelComputadores.getIdComputador(),
                modelComputadores.getHostName());

        if (computador.isEmpty()) {

            try {
                System.out.println("Computador não existente na base de dados.\ninserindo...\n");
                log.append("Computador não existente na base de dados.\ninserindo...\n");

                String sqlInsert = "INSERT INTO Computadores"
                        + "(idComputador, hostName, sistemaOperacional, modeloProcessador,"
                        + "idProcessador, tamanhoDisco, tamanhoDiscoSecundario,"
                        + "tamanhoRam, fkUsuario) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                connectAzure.update(sqlInsert,
                        modelComputadores.getIdComputador(),
                        modelComputadores.getHostName(),
                        modelComputadores.getSistemaOperacional(),
                        modelComputadores.getModeloProcessador(),
                        modelComputadores.getIdProcessador(),
                        modelComputadores.getTamanhoDisco(),
                        modelComputadores.getTamanhoDiscoSecundario(),
                        modelComputadores.getTamanhoRam(),
                        modelComputadores.getFkUsuario());

                connectMysql.update(sqlInsert,
                        modelComputadores.getIdComputador(),
                        modelComputadores.getHostName(),
                        modelComputadores.getSistemaOperacional(),
                        modelComputadores.getModeloProcessador(),
                        modelComputadores.getIdProcessador(),
                        modelComputadores.getTamanhoDisco(),
                        modelComputadores.getTamanhoDiscoSecundario(),
                        modelComputadores.getTamanhoRam(),
                        modelComputadores.getFkUsuario());

                System.out.println("Computador cadastrado com sucesso!!!");
                log.append("Computador cadastrado com sucesso!!!");
            } catch (UnknownHostException ex) {
                Logger.getLogger(ControllerComputadores.class.getName()).log(Level.SEVERE, null, ex);
                log.append(ex.getMessage());
            }

        } else {
            System.out.println("\nComputador já existente na base de dados.\n\nBem-vindo de volta! \\(^-^)/");
            log.append("\nComputador já existente na base de dados.\n\nBem-vindo de volta! \\(^-^)/");
        }
    }

}
