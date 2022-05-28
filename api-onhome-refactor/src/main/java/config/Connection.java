package config;

import java.util.List;
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
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://onhomesolutions.database.windows.net:1433;database=onHome;user=AdminOnHome@onhomesolutions;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource.setUsername("AdminOnHome");
        dataSource.setPassword("2ads@grupo10");
    }

    public Connection(Boolean valida) {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/onhome?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("2ads@grupo10");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
