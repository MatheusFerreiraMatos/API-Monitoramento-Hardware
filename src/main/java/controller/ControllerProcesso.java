package controller;

import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import connection.Connection;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.Log;
import model.ModelProcesso;
import org.springframework.jdbc.core.JdbcTemplate;
import view.TelaLogin;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerProcesso {

    Log log = new Log();

    Connection configAzure = new Connection();
    JdbcTemplate connectAzure = new JdbcTemplate(configAzure.getDataSource());
    Connection configMysql = new Connection(true);
    JdbcTemplate connectMysql = new JdbcTemplate(configMysql.getDataSource());

    ModelProcesso modelProcesso = new ModelProcesso();

    ProcessosGroup processos = new ProcessosGroup();

    Timer timer = new Timer();
    Integer delay = 5000;
    Integer interval = 10000;

    public void insertProcesso() {

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                try {
                    for (int i = 0; i < processos.getProcessos().size(); i++) {

                        System.out.println("Realizando insert na tabela Processo...");
                        log.append("Realizando insert na tabela Processo...");

                        String sqlInsert = "INSERT INTO Processo"
                                + "(nomeProcesso, usoCpu, usoMemoria, usoGpu,"
                                + "fkComputador, dataCaptura)"
                                + "VALUES (?, ?, ?, ?, ?, ?)";

                        connectAzure.update(sqlInsert,
                                processos.getProcessos().get(i).getNome(),
                                processos.getProcessos().get(i).getUsoCpu(),
                                processos.getProcessos().get(i).getUsoMemoria(),
                                processos.getProcessos().get(i).getMemoriaVirtualUtilizada(),
                                modelProcesso.getFkComputador(),
                                modelProcesso.getDataHoraCaptura());

                        connectMysql.update(sqlInsert,
                                processos.getProcessos().get(i).getNome(),
                                processos.getProcessos().get(i).getUsoCpu(),
                                processos.getProcessos().get(i).getUsoMemoria(),
                                processos.getProcessos().get(i).getMemoriaVirtualUtilizada(),
                                modelProcesso.getFkComputador(),
                                modelProcesso.getDataHoraCaptura());

                        System.out.println("Insert realizado na tabela Processo!");
                        log.append("Insert realizado na tabela Processo!");
                    }
                } catch (Exception e) {
                    Logger.getLogger(ControllerProcesso.class.getName()).log(Level.SEVERE, null, e);
                    log.append(e.getMessage());
                }

            }
        }, delay, interval);
    }
}
