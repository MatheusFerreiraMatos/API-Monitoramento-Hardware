package controller;

import connection.Connection;
import java.net.UnknownHostException;
import java.util.List;
import model.ModelComputadores;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerComputadores {

    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());
    
    ModelComputadores modelComputadores = new ModelComputadores();
    
    List<ModelComputadores> computador;
    
    public void insertComputador() throws UnknownHostException{
        
        System.out.println("-----------------------------[ Computador ]-----------------------------");
        System.out.println("Validando computador...");
                
        computador = connect.query("SELECT * FROM Computadores WHERE "
                + "idComputador = ? AND hostName = ?", 
                new BeanPropertyRowMapper<>(ModelComputadores.class),
                modelComputadores.getIdComputador(),
                modelComputadores.getHostName());
        
        if (computador.isEmpty()) {
            
            System.out.println("Computador não existente na base de dados.\ninserindo...\n");
            
            connect.update("INSERT INTO Computadores"
                    + "(idComputador, hostName, sistemaOperacional, modeloProcessador,"
                    + "idProcessador, tamanhoDisco, tamanhoDiscoSecundario,"
                    + "tamanhoRam, fkUsuario) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", 
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
        } else {
            System.out.println("\nComputador já existente na base de dados.\n\nBem-vindo de volta! \\(^-^)/");
        }
    }
    
    
}
