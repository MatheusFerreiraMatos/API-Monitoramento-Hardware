package controller;

import connection.Connection;
import java.util.Timer;
import java.util.TimerTask;
import model.ModelMonitoramento;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerMonitoramento {

    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());

    ModelMonitoramento modelMonitoramento = new ModelMonitoramento();

    Timer timer = new Timer();
    Integer delay = 5000;
    Integer interval = 10000;

    public void insertMonitoramento() {

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("Insert realizando na tabela Monitoramento...");
                System.out.println("Insert realizando na tabela Processo...");

                connect.update("INSERT INTO Monitoramento"
                        + "(processadorLogico, processadorFisico, usandoCpu, "
                        + "usandoDisco, usandoRam, dataHoraCaptura, "
                        + "tempoLigada, fkComputador) VALUES "
                        + "(?, ?, ?, ?, ?, ?, ?, ?)",
                        modelMonitoramento.getProcessadorLogico(),
                        modelMonitoramento.getProcessadorFisico(),
                        modelMonitoramento.getUsoCpu(),
                        modelMonitoramento.getUsoDisco(),
                        modelMonitoramento.getUsoRam(),
                        modelMonitoramento.getDataHoraCaptura(),
                        modelMonitoramento.getTempoLigada(),
                        modelMonitoramento.getFkComputador());

                System.out.println("Insert realizado na tabela Monitoramento!");
                System.out.println("Insert realizado na tabela Processo!");
            }
        }, delay, interval);
    }
}
