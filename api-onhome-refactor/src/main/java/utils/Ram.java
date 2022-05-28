package utils;

import com.github.britooo.looca.api.group.memoria.Memoria;

/**
 *
 * @author Matheus Mattos
 */
public class Ram {

    private Double totalMemoria;
    private Double memoriaLivre;
    private Double usabilidade;

    Memoria memoria = new Memoria();

    public Double getTotalMemoria() {
        totalMemoria = Double.valueOf(memoria.getTotal());
        totalMemoria /= 1000000000;
        return totalMemoria;
    }

    public Double getMemoriaLivre() {
        memoriaLivre = Double.valueOf(memoria.getDisponivel());
        memoriaLivre /= 1000000000;
        return memoriaLivre;
    }

    public Double getUsabilidade() {
        Double usoMemoria = getTotalMemoria() - getMemoriaLivre();
        usabilidade = (usoMemoria / totalMemoria) * 100;
        return usabilidade;
    }

}
