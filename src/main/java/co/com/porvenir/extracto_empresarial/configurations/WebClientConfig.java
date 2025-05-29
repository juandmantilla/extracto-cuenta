package co.com.porvenir.extracto_empresarial.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private static final String XML_BASE = "http://localhost:8080/xmlConsumer";

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(XML_BASE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
