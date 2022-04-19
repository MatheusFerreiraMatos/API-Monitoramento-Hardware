package controller;

import connection.Connection;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import model.Contador;
import model.Cpu;
import model.Disco;
import model.InfoMaquina;
import model.Ram;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerMonitoramento {

    //Instanciando conexão com o banco de dados e jdbc;
    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());

    //Instanciando class;
    InfoMaquina infoMaquina = new InfoMaquina();
    Cpu infoCpu = new Cpu();
    Disco infoDisco = new Disco();
    Ram infoRam = new Ram();
    Contador contador = new Contador();

    //Instanciando elementos para loop e formatação
    DecimalFormat formatarNumber = new DecimalFormat("#.00");
    Timer timer = new Timer();
    Integer delay = 10000;
    Integer interval = 2000;

    public void inserirDadosMonitoramento() {

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                //Criando variaveis para inserção no BD;
                //Dados Processador;
                Integer cpuLogica = infoCpu.getProcessadoresLogicos();
                Integer cpuFisica = infoCpu.getProcessadoresFisicos();
                Double usoProcessador = infoCpu.getUsabilidade();
                //Dados Disco;
                Double totalDisco = infoDisco.getTotalDisco();
                Double disponivelDisco = infoDisco.getDiscoDisponivel();
                Double usadoDisco = infoDisco.getUsabilidade();
                //Dados Memoria Ram;
                Double totalRam = infoRam.getTotalMemoria();
                Double livreRam = infoRam.getMemoriaLivre();
                Double usoRam = infoRam.getUsabilidade();
                //Dados tempo de atividade;
                String tempoUsoFormatado = infoMaquina.getTempoAtividade();

                String insertMonitoramento = "INSERT INTO Monitoramento "
                        + "(processadorLogico, processadorFisico, usandoCpu, "
                        + "usandoDisco, usandoRam, dataHoraCaptura, "
                        + "tempoLigada, fkComputador) VALUES "
                        + "(?, ?, ?, ?, ?, now(), ?, ?)";

                connect.update(insertMonitoramento, cpuLogica, cpuFisica,
                        usoProcessador, usadoDisco, usoRam, tempoUsoFormatado, 1);

                contador.setInsertMonitoramento(+1);
            }
        }, delay, interval);

    }
}
