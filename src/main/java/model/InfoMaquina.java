package model;

import com.github.britooo.looca.api.group.sistema.Sistema;

/**
 *
 * @author mathe
 */
public class InfoMaquina {

    private String usuario;
    private String sisOperacional;
    private String arquitetura;
    private String tesmpoAtividade;

    Sistema sistema = new Sistema();

    public String getUsuario() {
        return System.getProperty("user.name");
    }

    public String getSisOperacional() {
        return sistema.getSistemaOperacional();
    }

    public String getArquitetura() {
        return sistema.getArquitetura() + " bits";
    }

    public String getTempoAtividade() {
        Long tempo = sistema.getTempoDeAtividade();

        Long segundos = tempo;
        int horas = (int) (segundos / 3600);
        segundos %= 3600;
        int minutos = (int) (segundos / 60);
        segundos %= 60;

        return horas + ":" + minutos + ":" + segundos;
    }

}
