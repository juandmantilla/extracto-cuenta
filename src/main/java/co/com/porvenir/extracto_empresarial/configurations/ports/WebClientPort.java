package co.com.porvenir.extracto_empresarial.configurations.ports;

import org.springframework.web.reactive.function.client.WebClient;

public interface WebClientPort {
    WebClient webClient(WebClient.Builder builder);
}
