package controller;

import model.Usuario;
import connection.Connection;
import java.util.List;
import model.Contador;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerLogin {

    public Boolean logar(String email, String senha) {

        Connection config = new Connection();
        JdbcTemplate connect = new JdbcTemplate(config.getDataSource());
        Contador contador = new Contador();

        Boolean valida = false;

        List<Usuario> user;
        user = connect.query("SELECT * FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
                new BeanPropertyRowMapper<>(Usuario.class), email, senha);

        if (!user.isEmpty()) {
            valida = true;
            contador.setTotalSelect(+1);
        }

        return valida;
    }
}
