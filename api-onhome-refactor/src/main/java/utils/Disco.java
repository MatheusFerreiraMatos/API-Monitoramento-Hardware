package utils;

import com.github.britooo.looca.api.group.discos.DiscosGroup;

/**
 *
 * @author Matheus Mattos
 */
public class Disco {

    private Double totalDisco;
    private Double discoDisponivel;
    private Double usabilidade;

    DiscosGroup disco = new DiscosGroup();

    public Double getTotalDisco() {
        totalDisco = Double.valueOf(disco.getVolumes().get(0).getTotal());
        totalDisco /= 1000000000;
        return totalDisco;
    }

    public Double getDiscoDisponivel() {
        discoDisponivel = Double.valueOf(disco.getVolumes().get(0).getDisponivel());
        discoDisponivel /= 1000000000;
        return discoDisponivel;
    }

    public Double getUsabilidade() {
        Double usoDisco = Double.valueOf(totalDisco - discoDisponivel);
        usabilidade = (usoDisco / totalDisco) * 100;
        return usabilidade;
    }

}
