package org.javaacademy.rubl_bitcoin.service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.javaacademy.rubl_bitcoin.config.CoinDeskProperties;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CoinDeskIntegrationService {
    private static final String BPI = "bpi";
    private final CoinDeskProperties properties;

    public BigDecimal getBitcoinDollarAmount() {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> request = RequestEntity
                .get(properties.getUrl())
                .build();
        ResponseEntity<Map> response = restTemplate.exchange(request, Map.class);
        Map<String, LinkedHashMap<String, String>> bpi =
                (Map<String, LinkedHashMap<String, String>>) response.getBody().get(BPI);
        Map<String, String> usd = bpi.get(properties.getCurrency());
        return new BigDecimal(String.valueOf(usd.get(properties.getValue())));
    }
}
