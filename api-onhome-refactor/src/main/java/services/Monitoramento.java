package services;

import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import config.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author mathe
 */
public class Monitoramento {

    private Integer processadorLogico;
    private Integer processadorFisico;
    private Double usoCpu;
    private Double usoDisco;
    private Double usoRam;
    private String dataHoraCaptura;
    private String tempoLigada;
    private Integer fkComputador;

    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());
    Processador processador = new Processador();
    DiscosGroup disco = new DiscosGroup();
    Memoria memoria = new Memoria();
    Sistema sistema = new Sistema();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Computador comp = new Computador();

    Timer timer = new Timer();
    Integer delay = 5000;
    Integer interval = 10000;

    public void insertMonitoramento() {

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    System.out.println("Realizando insert na tabela Monitoramento...");

                    Integer idComputador = 0;

                    List<Computador> Listcomputador = connect.query("SELECT * FROM Computadores WHERE ipComputador = ? AND hostName = ?",
                            new BeanPropertyRowMapper(Computador.class), comp.getIpComputador(), comp.getHostName());
                    for (Computador comp : Listcomputador) {
                        idComputador = comp.getIdComputador();
                    }

                    if (!Listcomputador.isEmpty()) {
                        String sqlInsert = "INSERT INTO Monitoramento"
                                + "(processadorLogico, processadorFisico, usandoCpu, "
                                + "usandoDisco, usandoRam, dataHoraCaptura, "
                                + "tempoLigada, fkComputador) VALUES "
                                + "(?, ?, ?, ?, ?, ?, ?, ?)";

                        connect.update(sqlInsert,
                                getProcessadorLogico(),
                                getProcessadorFisico(),
                                getUsoCpu(),
                                getUsoDisco(),
                                getUsoRam(),
                                getDataHoraCaptura(),
                                getTempoLigada(),
                                idComputador);

                        System.out.println("Insert realizado na tabela Monitoramento!");
                    } else {
                        System.out.println("fkComputador Inválida!!!");
                        System.out.println("Insert Não Realizado!");
                    }

                } catch (Exception e) {
                    Logger.getLogger(Monitoramento.class.getName()).log(Level.SEVERE, null, e);
                }

            }
        }, delay, interval);
    }

    public Integer getProcessadorLogico() {
        return processador.getNumeroCpusLogicas();
    }

    public Integer getProcessadorFisico() {
        return processador.getNumeroCpusFisicas();
    }

    public Double getUsoCpu() {
        return processador.getUso();
    }

    public Double getUsoDisco() {
        Double tamanhoDisco = Double.valueOf(disco.getTamanhoTotal());
        Double disponivelDisco = Double.valueOf(disco.getVolumes().get(0).getDisponivel());
        usoDisco = tamanhoDisco - disponivelDisco;
        usoDisco /= 1000000000;
        return usoDisco;
    }

    public Double getUsoRam() {
        Double tamanhoRam = Double.valueOf(memoria.getTotal());
        Double disponivelRam = Double.valueOf(memoria.getDisponivel());
        usoRam = tamanhoRam - disponivelRam;
        usoRam /= 1000000000;
        return usoRam;
    }

    public String getDataHoraCaptura() {
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getTempoLigada() {
        Long tempo = sistema.getTempoDeAtividade();
        Long segundos = tempo;
        int horas = (int) (segundos / 3600);
        segundos %= 3600;
        int minutos = (int) (segundos / 60);
        segundos %= 60;
        tempoLigada = horas + ":" + minutos + ":" + segundos;
        return tempoLigada;
    }

    public Integer getFkComputador() {
        return fkComputador = 1;
    }
}
