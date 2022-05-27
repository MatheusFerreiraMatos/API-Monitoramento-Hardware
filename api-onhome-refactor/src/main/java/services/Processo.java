package services;

import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import config.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.Log;

/**
 *
 * @author mathe
 */
public class Processo {

    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());
    ProcessosGroup processos = new ProcessosGroup();

    Computador comp = new Computador();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    Timer timer = new Timer();
    Integer delay = 30000;
    Integer interval = 5000;

    public void insertProcesso() {
        Log log = new Log();
        System.setOut(log);
        System.setErr(log);

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                try {

                    Integer idComputador = 0;

                    List<Computador> Listcomputador = connect.query("SELECT * FROM Computadores WHERE ipComputador = ? AND hostName = ?",
                            new BeanPropertyRowMapper(Computador.class), comp.getIpComputador(), comp.getHostName());
                    for (Computador comp : Listcomputador) {
                        idComputador = comp.getIdComputador();
                    }

                    if (!Listcomputador.isEmpty()) {
                        for (int i = 0; i < processos.getProcessos().size(); i++) {

                            System.out.println("Realizando insert na tabela Processo...");

                            String sqlInsert = "INSERT INTO Processo"
                                    + "(nomeProcesso, usoCpu, usoMemoria, usoGpu,"
                                    + "fkComputador, dataCaptura)"
                                    + "VALUES (?, ?, ?, ?, ?, ?)";

                            connect.update(sqlInsert,
                                    processos.getProcessos().get(i).getNome(),
                                    processos.getProcessos().get(i).getUsoCpu(),
                                    processos.getProcessos().get(i).getUsoMemoria(),
                                    processos.getProcessos().get(i).getMemoriaVirtualUtilizada(),
                                    idComputador,
                                    getDataHoraCaptura());

                            System.out.println("Insert realizado na tabela Processo!");
                        }
                    } else {
                        System.out.println("fkComputador Inválida!!!");
                        System.out.println("Insert Não Realizado!");
                    }

                } catch (Exception e) {
                    Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, e);
                }

            }
        }, delay, interval);
    }

    public String getDataHoraCaptura() {
        Date date = new Date();
        return dateFormat.format(date);
    }
}
