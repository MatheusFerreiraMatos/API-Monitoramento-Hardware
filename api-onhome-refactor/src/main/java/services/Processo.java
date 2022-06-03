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
 * @author Matheus Mattos
 */
public class Processo {

    Connection configAzure = new Connection();
    JdbcTemplate connectAzure = new JdbcTemplate(configAzure.getDataSource());
    Connection configMysql = new Connection(true);
    JdbcTemplate connectMysql = new JdbcTemplate(configMysql.getDataSource());

    ProcessosGroup processos = new ProcessosGroup();

    Computador comp = new Computador();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    Timer timer = new Timer();
    Integer delay = 2000; // 2 Minutos
    Integer interval = 300000; // 5 Minutos

    public void insertProcesso() {
        Log log = new Log();
        System.setOut(log);
        System.setErr(log);

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                try {

                    Integer idComputadorAzure = 0;

                    List<Computador> ListcomputadorAzure = connectAzure.query("SELECT * FROM Computadores WHERE ipComputador = ? AND hostName = ?",
                            new BeanPropertyRowMapper(Computador.class), comp.getIpComputador(), comp.getHostName());
                    for (Computador comp : ListcomputadorAzure) {
                        idComputadorAzure = comp.getIdComputador();
                    }

                    Integer idComputadorMysql = 0;

                    List<Computador> ListcomputadorMysql = connectAzure.query("SELECT * FROM Computadores WHERE ipComputador = ? AND hostName = ?",
                            new BeanPropertyRowMapper(Computador.class), comp.getIpComputador(), comp.getHostName());
                    for (Computador comp : ListcomputadorAzure) {
                        idComputadorMysql = comp.getIdComputador();
                    }

                    if (!ListcomputadorAzure.isEmpty() || !ListcomputadorMysql.isEmpty()) {
                        for (int i = 0; i < processos.getProcessos().size(); i++) {

                            System.out.println("Realizando insert na tabela Processo...");

                            String sqlInsertAzure = "INSERT INTO Processo"
                                    + "(nomeProcesso, usoCpu, usoMemoria, usoGpu,"
                                    + "fkComputador, dataCaptura)"
                                    + "VALUES (?, ?, ?, ?, ?, GETDATE())";

                            connectAzure.update(sqlInsertAzure,
                                    processos.getProcessos().get(i).getNome(),
                                    processos.getProcessos().get(i).getUsoCpu(),
                                    processos.getProcessos().get(i).getUsoMemoria(),
                                    processos.getProcessos().get(i).getMemoriaVirtualUtilizada(),
                                    idComputadorAzure);

                            System.out.println("[Azure] - Insert realizado na tabela Processo!");

                            String sqlInsertMysql = "INSERT INTO Processo"
                                    + "(nomeProcesso, usoCpu, usoMemoria, usoGpu,"
                                    + "dataCaptura, fkComputador)"
                                    + "VALUES (?, ?, ?, ?, now(), ?)";

                            connectMysql.update(sqlInsertMysql,
                                    processos.getProcessos().get(i).getNome(),
                                    processos.getProcessos().get(i).getUsoCpu(),
                                    processos.getProcessos().get(i).getUsoMemoria(),
                                    processos.getProcessos().get(i).getMemoriaVirtualUtilizada(),
                                    idComputadorMysql);

                            System.out.println("[Mysql] - Insert realizado na tabela Processo!");
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
