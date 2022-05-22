package model;

import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Matheus Mattos
 */
public class ModelMonitoramento {

    private Integer processadorLogico;
    private Integer processadorFisico;
    private Double usoCpu;
    private Double usoDisco;
    private Double usoRam;
    private String dataHoraCaptura;
    private String tempoLigada;
    private Integer fkComputador;

    Processador processador = new Processador();
    DiscosGroup disco = new DiscosGroup();
    Memoria memoria = new Memoria();
    Sistema sistema = new Sistema();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

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
