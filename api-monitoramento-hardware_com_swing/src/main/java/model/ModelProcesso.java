package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Matheus Mattos
 */
public class ModelProcesso {

    private String nomeProcesso;
    private Double usoCPU;
    private Double usoRam;
    private Double usoGpu;
    private String dataHoraCaptura;
    private Integer fkComputador;

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    
    public Integer getFkComputador() {
        return fkComputador = 1;
    }

    public String getDataHoraCaptura() {
        Date date = new Date();
        return dateFormat.format(date);
    }

}
