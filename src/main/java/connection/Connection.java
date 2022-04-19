package connection;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Matheus Mattos
 */
public class Connection {

    //Validar para banco local e na azure;
    private BasicDataSource dataSource;

    public Connection() {
        dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.01:3306/onhome");
        dataSource.setUsername("OnHome");
        dataSource.setPassword("adminonhome@");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
