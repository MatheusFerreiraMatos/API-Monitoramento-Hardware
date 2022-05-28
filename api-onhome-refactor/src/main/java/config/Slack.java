package config;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import services.Usuario;

/**
 *
 * @author Matheus Mattos
 */
public class Slack {

    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final List<String> URL = new ArrayList<>();

    public void pegarWebhook(String email, String senha) {
        List<Usuario> listUser = connect.query("SELECT * FROM Usuario WHERE emailUser = ? AND senhaUser = ?",
                new BeanPropertyRowMapper(Usuario.class), email, senha);
        for (Usuario user : listUser) {
            URL.add(user.getWebhook());
        }
    }

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {

        //URL.add("https://hooks.slack.com/services/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");
        System.out.println("[Slack] - Enviando mensagem para usuário...");

        for (int i = 0; i < URL.size(); i++) {

            HttpRequest request = HttpRequest.newBuilder(
                    URI.create(URL.get(i)))
                    .header("accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("[Slack] - Mensagem enviada com sucesso!");
            } else {
                System.out.println(String.format("Status: %s", response.statusCode()));
                System.out.println(String.format("Response: %s", response.body()));
                System.out.println("[Slack] - Mensagem não enviada! (X_X)");
            }
        }

    }
}
