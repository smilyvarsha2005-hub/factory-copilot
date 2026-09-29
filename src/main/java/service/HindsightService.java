package com.factory.copilot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class HindsightService {

    @Value("${hindsight.base-url}")
    private String baseUrl;

    @Value("${hindsight.api-key}")
    private String apiKey;

    @Value("${hindsight.bank-id}")
    private String bankId;

    private final RestClient restClient;

    public HindsightService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    // Store machine/maintenance knowledge in Hindsight
    public String retainMemory(String content) {

        Map<String, Object> request = Map.of(
                "items", new Object[]{
                        Map.of(
                                "content", content
                        )
                }
        );

        return restClient.post()
                .uri(baseUrl + "/v1/default/banks/" + bankId + "/memories")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(request)
                .retrieve()
                .body(String.class);
    }

    // Search historical knowledge from Hindsight
    public String recallMemory(String query) {

        Map<String, Object> request = Map.of(
                "query", query
        );

        return restClient.post()
                .uri(baseUrl + "/v1/default/banks/" + bankId + "/memories/recall")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(request)
                .retrieve()
                .body(String.class);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getBankId() {
        return bankId;
    }
}