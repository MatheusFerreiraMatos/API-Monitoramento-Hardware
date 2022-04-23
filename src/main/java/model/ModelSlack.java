package model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Matheus Mattos
 */
public class ModelSlack {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final List<String> URL = new ArrayList<>();

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {

        URL.add("https://hooks.slack.com/services/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");
        //URL.add("https://hooks.slack.com/services/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");
        //URL.add("https://hooks.slack.com/services/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");

        System.out.println("-------------------------------[ Slack ]--------------------------------");
        System.out.println("\nEnviando mensagem de usuário logando...\n");

        for (int i = 0; i < URL.size(); i++) {

            HttpRequest request = HttpRequest.newBuilder(
                    URI.create(URL.get(i)))
                    .header("accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(String.format("Status: %s", response.statusCode()));
            System.out.println(String.format("Response: %s", response.body()));
            if (response.statusCode() == 200) {
                System.out.println("Mensagem enviada com sucesso!\n");
            } else {
                System.out.println("Mensagem não enviada! (X_X)\n");
            }
        }

    }
}
