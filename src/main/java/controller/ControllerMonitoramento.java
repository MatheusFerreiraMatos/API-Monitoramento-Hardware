package controller;

import connection.Connection;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.Log;
import model.ModelMonitoramento;
import org.springframework.jdbc.core.JdbcTemplate;
import view.TelaLogin;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerMonitoramento {

    Log log = new Log();
    Connection configAzure = new Connection();
    JdbcTemplate connectAzure = new JdbcTemplate(configAzure.getDataSource());
    Connection configMysql = new Connection(true);
    JdbcTemplate connectMysql = new JdbcTemplate(configMysql.getDataSource());

    ModelMonitoramento modelMonitoramento = new ModelMonitoramento();

    Timer timer = new Timer();
    Integer delay = 5000;
    Integer interval = 10000;

    public void insertMonitoramento() {

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    System.out.println("Realizando insert na tabela Monitoramento...");
                    log.append("Realizando insert na tabela Monitoramento...");

                    String sqlInsert = "INSERT INTO Monitoramento"
                            + "(processadorLogico, processadorFisico, usandoCpu, "
                            + "usandoDisco, usandoRam, dataHoraCaptura, "
                            + "tempoLigada, fkComputador) VALUES "
                            + "(?, ?, ?, ?, ?, ?, ?, ?)";

                    connectAzure.update(sqlInsert,
                            modelMonitoramento.getProcessadorLogico(),
                            modelMonitoramento.getProcessadorFisico(),
                            modelMonitoramento.getUsoCpu(),
                            modelMonitoramento.getUsoDisco(),
                            modelMonitoramento.getUsoRam(),
                            modelMonitoramento.getDataHoraCaptura(),
                            modelMonitoramento.getTempoLigada(),
                            modelMonitoramento.getFkComputador());

                    connectMysql.update(sqlInsert,
                            modelMonitoramento.getProcessadorLogico(),
                            modelMonitoramento.getProcessadorFisico(),
                            modelMonitoramento.getUsoCpu(),
                            modelMonitoramento.getUsoDisco(),
                            modelMonitoramento.getUsoRam(),
                            modelMonitoramento.getDataHoraCaptura(),
                            modelMonitoramento.getTempoLigada(),
                            modelMonitoramento.getFkComputador());
                    
                    System.out.println("Insert realizado na tabela Monitoramento!");
                    log.append("Insert realizado na tabela Monitoramento!");

                } catch (Exception e) {
                    Logger.getLogger(ControllerMonitoramento.class.getName()).log(Level.SEVERE, null, e);
                    log.append(e.getMessage());
                }

            }
        }, delay, interval);
    }
}
