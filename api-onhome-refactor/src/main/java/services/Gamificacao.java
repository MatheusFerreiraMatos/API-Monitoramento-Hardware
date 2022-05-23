package services;

import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import config.Connection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import config.Slack;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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

    public void enviarNotificacao(String email, String senha) {

        List<Usuario> listUser = connect.query("SELECT * FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
                new BeanPropertyRowMapper(Usuario.class), email, senha);
        for (Usuario user : listUser) {
            nomeUser = user.getNomeUsuario();
            idUsuario = user.getIdUsuario();
        }

        json.put("text", String.format("Relátório da Gamificação: \n"
                + "Nome do Usuário: %s\n"
                + "Total de pontos: %d", nomeUser, pegarPontos()));

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

        List<Gamificacao> listgame = connect.query("SELECT * FROM Gamificacao WHERE fkUsuario = ?",
                new BeanPropertyRowMapper(Gamificacao.class), idUsuario);

        for (Gamificacao game : listgame) {
            pontuacaoBanco = game.getQtdPontos();
        }
        return pontuacaoBanco;
    }

    public void atualizandoPontuacao() {

        Timer timer = new Timer();
        Integer delay = 30000;
        Integer interval = 5000;

        System.out.println("Coletando dados para gerar pontuação");

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                for (int i = 0; i < processos.getProcessos().size(); i++) {
                    //Fazer validação de total de quantidade de pontos!!!
                    if (processos.getProcessos().get(i).getNome().equals("netbeans64")) {
                        connect.update("UPDATE Gamificacao SET qtdPontos = ? WHERE fkUsuario = ?", pegarPontos() + 5, idUsuario);
                        System.out.println("Update realizado na tabela Gamificação");
                    }

                    if (processos.getProcessos().get(i).getNome().equals("Code")) {
                        connect.update("UPDATE Gamificacao SET qtdPontos = ? WHERE fkUsuario = ?", pegarPontos() + 5, idUsuario);
                        System.out.println("Update realizado na tabela Gamificação");
                    }

                    if (processos.getProcessos().get(i).getNome().equals("postgres")) {
                        connect.update("UPDATE Gamificacao SET qtdPontos = ? WHERE fkUsuario = ?", pegarPontos() + 5, idUsuario);
                        System.out.println("Update realizado na tabela Gamificação");
                    }

                    if (processos.getProcessos().get(i).getNome().equals("java")) {
                        connect.update("UPDATE Gamificacao SET qtdPontos = ? WHERE fkUsuario = ?", pegarPontos() + 5, idUsuario);
                        System.out.println("Update realizado na tabela Gamificação");
                    }

                    if (processos.getProcessos().get(i).getNome().equals("mysqld")) {
                        connect.update("UPDATE Gamificacao SET qtdPontos = ? WHERE fkUsuario = ?", pegarPontos() + 5, idUsuario);
                        System.out.println("Update realizado na tabela Gamificação");
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
