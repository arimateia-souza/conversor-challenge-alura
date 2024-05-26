package persistencia;

import com.google.gson.Gson;
import dominio.Moeda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambio {

    public double buscar(String moedaOrigem, String moedaDestino, double cambioValor) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/e5332e2dd1822708d52bc757/latest/" + moedaOrigem);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Moeda moeda = new Gson().fromJson(response.body(), Moeda.class);
            Double taxaDeCambio = moeda.conversion_rates().get(moedaDestino);

            return cambioValor * taxaDeCambio;
        } catch (Exception e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
    }
}
