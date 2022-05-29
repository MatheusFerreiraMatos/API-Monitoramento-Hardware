package utils;

import config.Slack;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import services.Gamificacao;
import services.Usuario;

/**
 *
 * @author Matheus Mattos
 */
public class SituacaoComputador {

    JSONObject json = new JSONObject();
    Usuario usuario = new Usuario();

    Cpu cpu = new Cpu();
    Disco disco = new Disco();
    Ram ram = new Ram();

    Timer timer = new Timer();
    Integer delay = 9000;
    Integer interval = 10000;

    public void enviarSituacao() {

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                //variaveis de usabilidade
                Double usaCpu = cpu.getUsabilidade();
                Double usaDisco = disco.getUsabilidade();
                Double usaRam = ram.getUsabilidade();

                if (usaCpu >= 80.0) {
                    json.put("text", String.format("Olá :raising_hand:️\n"
                            + "\n"
                            + "Identificamos algumas inconsistências com o hardware do seu computador, segue abaixo os problemas encontrados:  \n"
                            + "\n\n"
                            + ":clipboard: Relatório de usabilidade de hardware:\n"
                            + "\n\n"
                            + "Status da máquina: :warning: Atenção!\n"
                            + "\n\n"
                            + "Usabilidade do Processador: %.2f%% :bangbang: \n"
                            + "Usabilidade do Disco: %.2f%% \n"
                            + "Usabilidade da Memória Ram: %.2f%%  \n"
                            + "\n\n"
                            + "Recomendações:\n"
                            + "\n\n"
                            + ":pushpin: 1º - Verifique os programas em execução da sua máquina;\n"
                            + ":pushpin: 2º - Verifique quais desses programas não estão sendo úteis para o desenvolvimento do seu trabalho;\n"
                            + ":pushpin: 3º - Feche-os para melhor desempenho da sua máquina. \n"
                            + "\n\n"
                            + "Para mais informações ou suporte necessário entre em contato conosco pelos meios a seguir:\n\n\n"
                            + ":iphone: (11) 95402-3369\n\n"
                            + ":telephone_receiver: (11) 2731-5569\n\n"
                            + ":computer: www.onhome.com.br\n\n"
                            + ":email: onhome.tech@gmail.com\n\n"
                            + "\n\n\n"
                            + "A OnHome agradece a atenção.:house:\n"
                            + "Até mais! :simple_smile:", usaCpu, usaDisco, usaRam));
                    try {
                        Slack.sendMessage(json);
                    } catch (IOException ex) {
                        Logger.getLogger(Gamificacao.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gamificacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (usaDisco >= 80.0) {
                    json.put("text", String.format("Olá :raising_hand:️\n"
                            + "\n"
                            + "Identificamos algumas inconsistências com o hardware do seu computador, segue abaixo os problemas encontrados:  \n"
                            + "\n\n"
                            + ":clipboard: Relatório de usabilidade de hardware:\n"
                            + "\n\n"
                            + "Status da máquina: :warning: Atenção!\n"
                            + "\n\n"
                            + "Usabilidade do Processador: %.2f%% \n"
                            + "Usabilidade do Disco: %.2f%% :bangbang: \n"
                            + "Usabilidade da Memória Ram: %.2f%%  \n"
                            + "\n\n"
                            + "Recomendações:\n"
                            + "\n\n"
                            + ":pushpin: 1º - Verifique os programas em execução da sua máquina;\n"
                            + ":pushpin: 2º - Verifique quais desses programas não estão sendo úteis para o desenvolvimento do seu trabalho;\n"
                            + ":pushpin: 3º - Feche-os para melhor desempenho da sua máquina. \n"
                            + "\n\n"
                            + "Para mais informações ou suporte necessário entre em contato conosco pelos meios a seguir:\n\n\n"
                            + ":iphone: (11) 95402-3369\n\n"
                            + ":telephone_receiver: (11) 2731-5569\n\n"
                            + ":computer: www.onhome.com.br\n\n"
                            + ":email: onhome.tech@gmail.com\n\n"
                            + "\n\n\n"
                            + "A OnHome agradece a atenção.:house:\n"
                            + "Até mais! :simple_smile:", usaCpu, usaDisco, usaRam));
                    try {
                        Slack.sendMessage(json);
                    } catch (IOException ex) {
                        Logger.getLogger(Gamificacao.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gamificacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (usaRam >= 80.0) {
                    json.put("text", String.format("Olá :raising_hand:️\n"
                            + "\n"
                            + "Identificamos algumas inconsistências com o hardware do seu computador, segue abaixo os problemas encontrados:  \n"
                            + "\n\n"
                            + ":clipboard: Relatório de usabilidade de hardware:\n"
                            + "\n\n"
                            + "Status da máquina: :warning: Atenção!\n"
                            + "\n\n"
                            + "Usabilidade do Processador: %.2f%% \n"
                            + "Usabilidade do Disco: %.2f%% \n"
                            + "Usabilidade da Memória Ram: %.2f%% :bangbang: \n"
                            + "\n\n"
                            + "Recomendações:\n"
                            + "\n\n"
                            + ":pushpin: 1º - Verifique os programas em execução da sua máquina;\n"
                            + ":pushpin: 2º - Verifique quais desses programas não estão sendo úteis para o desenvolvimento do seu trabalho;\n"
                            + ":pushpin: 3º - Feche-os para melhor desempenho da sua máquina. \n"
                            + "\n\n"
                            + "Para mais informações ou suporte necessário entre em contato conosco pelos meios a seguir:\n\n\n"
                            + ":iphone: (11) 95402-3369\n\n"
                            + ":telephone_receiver: (11) 2731-5569\n\n"
                            + ":computer: www.onhome.com.br\n\n"
                            + ":email: onhome.tech@gmail.com\n\n"
                            + "\n\n\n"
                            + "A OnHome agradece a atenção.:house:\n"
                            + "Até mais! :simple_smile:", usaCpu, usaDisco, usaRam));
                    try {
                        Slack.sendMessage(json);
                    } catch (IOException ex) {
                        Logger.getLogger(Gamificacao.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gamificacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }, delay, interval);

    }
}
