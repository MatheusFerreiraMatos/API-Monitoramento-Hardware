package controller;

import connection.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.Log;
import model.ModelUsuario;
import model.Usuario;
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
    Connection configMysql = new Connection(true);
    JdbcTemplate connectMysql = new JdbcTemplate(configMysql.getDataSource());

    public Boolean logar(String email, String senha) {

        Log log = new Log();

        Boolean valida = false;

        List<ModelUsuario> userAzure;
        List<ModelUsuario> userMysql;
        try {
            userAzure = connectAzure.query("SELECT (nomeUsuario) FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
                    new BeanPropertyRowMapper<>(ModelUsuario.class), email, senha);

            userMysql = connectMysql.query("SELECT (nomeUsuario) FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
                    new BeanPropertyRowMapper<>(ModelUsuario.class), email, senha);

            if (!userAzure.isEmpty() || userMysql.isEmpty()) {
                valida = true;
                log.append("Usuário válido! executando aplicação...");
            }
        } catch (Exception e) {
            Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, e);
            log.append(e.getMessage());
        }

        return valida;
    }

    public void pegaDados(String email, String senha) {
        List<ModelUsuario> listUser = configMysql.query("SELECT * FROM Usuario", new BeanPropertyRowMapper(ModelUsuario.class), email, senha);

        System.out.println("\nEXIBINDO DA MANEIRA MAIS ÚTIL:");
        for (ModelUsuario user : listUser) {
            System.out.println(user.getEmailUser());
        }
    }
    Usuario users = new Usuario();

    public void mostrar(String email, String senha) {

        List<Usuario> listUser = connectAzure.query("SELECT * FROM Usuario WHERE emailUser = ? AND senhaUser = ?", new BeanPropertyRowMapper(Usuario.class), email, senha);

        for (Usuario user : listUser) {
            users.setIdUsuario(user.getIdUsuario());
            users.setNomeUsuario(user.getNomeUsuario());
            users.setEmailUser(user.getEmailUser());
        }
        System.out.println(users.getIdUsuario());
        System.out.println(users.getNomeUsuario());
        System.out.println(users.getEmailUser());
    }

    public String getNomeUsuario() {
        return users.getNomeUsuario();
    }
}
