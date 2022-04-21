package model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author Matheus Mattos
 */
public class ModelSlack {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String URL = "https://hooks.slack.com/services/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";

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("-------------------------------[ Slack ]--------------------------------");
        System.out.println("Enviando mensagem de usuário logando...");
        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
        if (response.statusCode() == 200) {
            System.out.println("Mensagem enviada com sucesso!");
        } else {
            System.out.println("Mensagem não enviada! (X_X)");
        }
    }
}
