package controller;

import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import connection.Connection;
import java.util.Timer;
import java.util.TimerTask;
import model.ModelProcesso;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerProcesso {

    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());

    ModelProcesso modelProcesso = new ModelProcesso();

    ProcessosGroup processos = new ProcessosGroup();

    Timer timer = new Timer();
    Integer delay = 5000;
    Integer interval = 10000;

    public void insertProcesso() {

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                for (int i = 0; i < processos.getProcessos().size(); i++) {

                    connect.update("INSERT INTO Processo"
                            + "(nomeProcesso, usoCpu, usoMemoria, usoGpu,"
                            + "fkComputador, dataCaptura)"
                            + "VALUES (?, ?, ?, ?, ?, ?)",
                            processos.getProcessos().get(i).getNome(),
                            processos.getProcessos().get(i).getUsoCpu(),
                            processos.getProcessos().get(i).getUsoMemoria(),
                            processos.getProcessos().get(i).getMemoriaVirtualUtilizada(),
                            modelProcesso.getFkComputador(),
                            modelProcesso.getDataHoraCaptura());
                }

            }
        }, delay, interval);
    }
}
