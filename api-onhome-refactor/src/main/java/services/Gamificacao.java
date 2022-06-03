package services;

import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import config.Connection;
import java.io.IOException;
import config.Slack;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.Log;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Mattos
 */
public class Gamificacao {

    private Integer idGamificacao;
    private Integer qtdPontos;
    private Integer fkUsuario;

    JSONObject json = new JSONObject();
    Usuario usuario = new Usuario();

    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());
    ProcessosGroup processos = new ProcessosGroup();

    Integer idUsuario = 0;
    String nomeUser = "não identificado";

    Log log = new Log();

    public void enviarNotificacao(String email, String senha) {
        System.setOut(log);
        System.setErr(log);
        List<Usuario> listUser = connect.query("SELECT * FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
                new BeanPropertyRowMapper(Usuario.class), email, senha);
        for (Usuario user : listUser) {
            nomeUser = user.getNomeUsuario();
            idUsuario = user.getIdUsuario();
        }
        
        int sort = new Random().nextInt(10) + 1;
        
        List<Frases> listFrases = connect.query("SELECT * FROM Frases WHERE idFrase = ?", new BeanPropertyRowMapper(Frases.class), sort);
        
        String fraseDaVez = "";
        String autorDaVez = "";
        
        for (Frases listFrase : listFrases) {
            fraseDaVez = listFrase.getFrase();
            autorDaVez = listFrase.getAutor();
        }

        json.put("text", String.format("_Olá_ :raising_hand:\n"
                + "\n\n"
                + "\"_%s_\"\n"
                + "- %s\n"
                + "\n"
                + "\n\n"
                + "Mais um dia normal de um desenvolvedor!\n"
                + "\n\n"
                + "Desejamos um ótimo dia para você, deixamos logo a seguir sua pontuação acumulada até agora:\n\n"
                + "\n"
                + "*Nome do Usuário:* %s\n"
                + "*Total de pontos:* %d\n"
                + "\n"
                + "\n"
                + "A OnHome agradece a atenção.:house:\n"
                + "Até mais! :simple_smile:", fraseDaVez, autorDaVez, nomeUser, pegarPontos()));

        try {
            Slack.sendMessage(json);
        } catch (IOException ex) {
            Logger.getLogger(Gamificacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Gamificacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Integer pegarPontos() {
        Integer pontuacaoBanco = 0;

        List<Gamificacao> listgame = connect.query("SELECT sum(qtdPontos) as qtdPontos FROM Gamificacao WHERE fkUsuario = ?",
                new BeanPropertyRowMapper(Gamificacao.class), idUsuario);

        for (Gamificacao game : listgame) {
            pontuacaoBanco = game.getQtdPontos();
        }
        return pontuacaoBanco;
    }

    public List<String> pegarIdes() {
        System.setOut(log);
        System.setErr(log);
        List<String> listaIdes = new ArrayList<>();
        List<Ides> Ides = connect.query("SELECT * FROM Ides", new BeanPropertyRowMapper(Ides.class));

        for (Ides ide : Ides) {
            listaIdes.add(ide.getNome());
        }

        return listaIdes;
    }

    public void atualizandoPontuacao() {
        System.setOut(log);
        System.setErr(log);

        Timer timer = new Timer();
        Integer delay = 2000; // 2 Minutos
        Integer interval = 300000; // 5 Minutos

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println("Coletando dados para gerar pontuação");
                if (pegarPontos() >= 100) {
                    System.out.println("Seu limite de pontos para a semana já foi atingido, "
                            + "Parabéns meta da semana concluida! \\(^-^)/");
                } else {
                    for (String idesBanco : pegarIdes()) {
                        for (int i = 0; i < processos.getProcessos().size(); i++) {
                            if (idesBanco.equalsIgnoreCase(processos.getProcessos().get(i).getNome())) {
                                connect.update("INSERT INTO Gamificacao(qtdPontos, dataHoraCaptura, fkUsuario) VALUES (?, '2022-05-25', ?)", 2, idUsuario);
                                System.out.println("***[Slack] - Insert realizado na tabela Gamificação");
                            }
                        }
                    }
                }
            }
        }, delay, interval);
    }

    public Integer getIdGamificacao() {
        return idGamificacao;
    }

    public void setIdGamificacao(Integer idGamificacao) {
        this.idGamificacao = idGamificacao;
    }

    public Integer getQtdPontos() {
        return qtdPontos;
    }

    public void setQtdPontos(Integer qtdPontos) {
        this.qtdPontos = qtdPontos;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public String toString() {
        return "Gamificacao{" + "idGamificacao=" + idGamificacao + ", qtdPontos=" + qtdPontos + ", fkUsuario=" + fkUsuario + '}';
    }

}
