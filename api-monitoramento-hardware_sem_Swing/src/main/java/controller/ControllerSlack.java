package controller;

import connection.Connection;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.Log;
import model.ModelSlack;
import model.ModelUsuario;
import org.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerSlack {

    Log log = new Log();

    JSONObject json = new JSONObject();
    ModelUsuario usuario = new ModelUsuario();
    Connection configAzure = new Connection();
    JdbcTemplate connectAzure = new JdbcTemplate(configAzure.getDataSource());
    //Connection configMysql = new Connection(true);
    //JdbcTemplate connectMysql = new JdbcTemplate(configMysql.getDataSource());

    public void enviarNotificacao(String email, String senha) {

        String nomeUser = "";
/*
        List<ModelUsuario> listUser = connectMysql.query("SELECT * FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
               new BeanPropertyRowMapper(ModelUsuario.class), email, senha);
        
        for (ModelUsuario user : listUser) {
            nomeUser = user.getNomeUsuario();
        }
*/
        json.put("text", String.format("Usuário %s acessou a aplicação OnHome", nomeUser));

        try {
            ModelSlack.sendMessage(json);
        } catch (IOException ex) {
            Logger.getLogger(ControllerSlack.class.getName()).log(Level.SEVERE, null, ex);
            log.append(ex.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(ControllerSlack.class.getName()).log(Level.SEVERE, null, ex);
            log.append(ex.getMessage());
        }
    }
}
