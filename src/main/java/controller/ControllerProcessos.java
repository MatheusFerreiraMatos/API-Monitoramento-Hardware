package controller;

import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import connection.Connection;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerProcessos {

    //Instanciando conexão com o banco de dados e jdbc;
    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());

    //Instanciando API looca;
    ProcessosGroup processosGroup = new ProcessosGroup();

    //Instanciando elementos para loop e formatação
    DecimalFormat formatarNumber = new DecimalFormat("#.00");
    Timer timer = new Timer();
    Integer delay = 20000;
    Integer interval = 5000;
    //Variavel contador;
    Integer contador = 0;

    public void inserirDadosProcesso() {

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                //Criando variaveis para inserção no BD;
                List<Processo> listarprocessos = processosGroup.getProcessos();

                for (int i = 0; i < listarprocessos.size(); i++) {
                    String nomeProcesso = listarprocessos.get(i).getNome();
                    Double usoCpu = listarprocessos.get(i).getUsoCpu();
                    Double usoMemoria = listarprocessos.get(i).getUsoMemoria();
                    Double usoGpu = Double.valueOf(listarprocessos.get(i).getMemoriaVirtualUtilizada());

                    String insertProcesso = "INSERT INTO Processo"
                            + "(nomeProcesso, usoCpu, usoMemoria, usoGpu,"
                            + "fkComputador, dataCaptura)"
                            + "VALUES (?, ?, ?, ?, ?, NOW())";

                    connect.update(insertProcesso, nomeProcesso, usoCpu,
                            usoMemoria, usoGpu, 1);
                }
                contador++;
                System.out.println("INSERT NA TABELA PROCESSO - OK - Total: " + contador);

            }
        }, delay, interval);
    }
}
