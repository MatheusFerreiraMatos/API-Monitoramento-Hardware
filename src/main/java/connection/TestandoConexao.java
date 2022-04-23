package connection;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class TestandoConexao {

    public static void main(String[] args) {
        Connection connect = new Connection();
        JdbcTemplate template = new JdbcTemplate(connect.getDataSource());

        System.out.println("----------------------[ Testando Banco de Dados ]-----------------------");

        System.out.println("Criando tabela onHome...\n");

        template.update("CREATE TABLE onHome ("
                + "idUsuario INT PRIMARY KEY AUTO_INCREMENT,"
                + "emailUser VARCHAR(45),"
                + "senhaUser VARCHAR(50))");

        System.out.println("Tabela onHome criada com sucesso!");

        System.out.println("-".repeat(72));

        System.out.println("Inserindo dados na tabela onHome...\n");

        template.update("INSERT INTO onHome VALUES "
                + "(null, 'teste@teste.com', 'teste123')");

        System.out.println("Dados inseridos na tabela onHome com sucesso!");

        System.out.println("-".repeat(72));

        System.out.println("Listando dados da tabela onHome...\n");

        List dadosTeste = template.queryForList("SELECT * FROM onHome");

        System.out.println("Dados da tabela onHome (comando SELECT): \n\n"
                + dadosTeste + "\n\nTudo ok!?\n");

        System.out.println("-".repeat(72));

        System.out.println("Deletando tabela onHome...");

        template.update("DROP TABLE onHome");

        System.out.println("Tabela excluida com sucesso!!! BANCO DE DADOS OK!");

        System.out.println("-".repeat(72));

        System.out.println("Application pronta para ser usada! OnHome");
    }
}
