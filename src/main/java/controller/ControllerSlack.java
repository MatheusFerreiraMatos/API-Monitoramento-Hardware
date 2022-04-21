package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelSlack;
import org.json.JSONObject;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerSlack {

    JSONObject json = new JSONObject();
    ControllerUsuario usuario = new ControllerUsuario();
    public void enviarNotificacao() {
        
        json.put("text", String.format("Usuário %s acessou a aplicação OnHome", usuario.getNomeUsuario()));

        try {
            ModelSlack.sendMessage(json);
        } catch (IOException ex) {
            Logger.getLogger(ControllerSlack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControllerSlack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
