package controller;

import connection.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.Log;
import model.ModelUsuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerUsuario {

    private String nomeUsuario;
    ModelUsuario usuario = new ModelUsuario();
    Connection configAzure = new Connection();
    JdbcTemplate connectAzure = new JdbcTemplate(configAzure.getDataSource());
    //Connection configMysql = new Connection(true);
    //JdbcTemplate connectMysql = new JdbcTemplate(configMysql.getDataSource());

    public Boolean logar(String email, String senha) {

        Log log = new Log();

        Boolean valida = false;

        List<ModelUsuario> userAzure;
        //List<ModelUsuario> userMysql;
        try {

            //userMysql = connectMysql.query("SELECT (nomeUsuario) FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
                //    new BeanPropertyRowMapper<>(ModelUsuario.class), email, senha);

            userAzure = connectAzure.query("SELECT (nomeUsuario) FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
                    new BeanPropertyRowMapper<>(ModelUsuario.class), email, senha);

            if (userAzure.isEmpty()) {
                valida = true;
                log.append("Usuário válido! executando aplicação...");
            }

        } catch (Exception e) {
            Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, e);
            log.append(e.getMessage());
        }

        return valida;
    }

}
