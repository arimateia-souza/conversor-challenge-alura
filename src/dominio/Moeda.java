package dominio;

import java.util.Map;

public record Moeda(String result, String base_code, Map<String, Double> conversion_rates) {
}
