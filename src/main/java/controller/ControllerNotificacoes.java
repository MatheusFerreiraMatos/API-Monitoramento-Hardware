package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Slack;
import org.json.JSONObject;

/**
 *
 * @author mathe
 */
public class ControllerNotificacoes {

    JSONObject json = new JSONObject();

    public void enviarNotificacao() {
        String user = System.getProperty("user.name");
        json.put("text", String.format("Usuário %s acessou a aplicação OnHome", user));

        try {
            Slack.sendMessage(json);
        } catch (IOException ex) {
            Logger.getLogger(ControllerNotificacoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControllerNotificacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
