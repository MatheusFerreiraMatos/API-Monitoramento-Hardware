package connection;

import java.util.List;
import model.ModelUsuario;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author Matheus Mattos
 */
public class Connection {
    //Classe responsável por conectar com o Banco de Dados(Azure or MySQL);

    private BasicDataSource dataSource;
    

    public Connection() {
        dataSource  = new BasicDataSource();
        //Banco na Azure - Descomente para utilizá-lo
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://onhomesolutions.database.windows.net:1433;database=onHome;user=AdminOnHome@onhomesolutions;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource.setUsername("AdminOnHome");
        dataSource.setPassword("2ads@grupo10");
    }

    public Connection(Boolean valida) {
        dataSource  = new BasicDataSource();
        //Banco Local - Descomente para utilizá-lo
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/onhome?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("2ads@grupo10");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

    public List<ModelUsuario> query(String select__from_Usuario, BeanPropertyRowMapper beanPropertyRowMapper) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<ModelUsuario> query(String select__from_Usuario, BeanPropertyRowMapper beanPropertyRowMapper, String email, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
