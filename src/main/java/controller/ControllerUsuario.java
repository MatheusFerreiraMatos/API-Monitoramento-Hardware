package controller;

import connection.Connection;
import java.util.List;
import model.ModelUsuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerUsuario {

    private String nomeUsuario;

    public Boolean logar(String email, String senha) {

        Connection config = new Connection();
        JdbcTemplate connect = new JdbcTemplate(config.getDataSource());

        Boolean valida = false;

        List<ModelUsuario> user;
        user = connect.query("SELECT * FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
                new BeanPropertyRowMapper<>(ModelUsuario.class), email, senha);

        if (!user.isEmpty()) {
            valida = true;
        }

        return valida;
    }

    public String getNomeUsuario() {
        return nomeUsuario = "admin";
    }

}
