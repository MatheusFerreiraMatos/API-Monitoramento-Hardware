package utils;

import com.github.britooo.looca.api.group.processador.Processador;

/**
 *
 * @author Matheus Mattos
 */
public class Cpu {

    private String idProcessador;
    private String nome;
    private Integer processadoresFisicos;
    private Integer processadoresLogicos;
    private Double usabilidade;

    Processador processador = new Processador();

    public String getIdProcessador() {
        idProcessador = processador.getId();
        return idProcessador;
    }

    public String getNome() {
        nome = processador.getNome();
        return nome;
    }

    public Integer getProcessadoresFisicos() {
        processadoresFisicos = processador.getNumeroCpusFisicas();
        return processadoresFisicos;
    }

    public Integer getProcessadoresLogicos() {
        processadoresLogicos = processador.getNumeroCpusLogicas();
        return processadoresLogicos;
    }

    public Double getUsabilidade() {
        usabilidade = processador.getUso();
        return usabilidade;
    }

}
