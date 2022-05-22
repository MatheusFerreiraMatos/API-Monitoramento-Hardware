package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.Log;
import model.ModelSlack;
import model.ModelUsuario;
import org.json.JSONObject;
import view.TelaLogin;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerSlack {

    Log log = new Log();

    JSONObject json = new JSONObject();
    ModelUsuario usuario = new ModelUsuario();

    public void enviarNotificacao() {

        json.put("text", String.format("Usuário %s acessou a aplicação OnHome", usuario.getNomeUsuario()));

        try {
            ModelSlack.sendMessage(json);
        } catch (IOException ex) {
            Logger.getLogger(ControllerSlack.class.getName()).log(Level.SEVERE, null, ex);
            log.append(ex.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(ControllerSlack.class.getName()).log(Level.SEVERE, null, ex);
            log.append(ex.getMessage());
        }
    }
}
