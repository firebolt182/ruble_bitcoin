package org.javaacademy.rubl_bitcoin.service;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.javaacademy.rubl_bitcoin.config.FreeCurrencyProperties;
import org.javaacademy.rubl_bitcoin.dto.FreeCurrencyDtoRs;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class FreeCurrencyIntegrationService {
    private static final String CURRENCY_NAME = "RUB";
    private final static String POSTFIX_URL_GET_RUB_TEMPLATE = "/latest?currencies=%s";
    private final FreeCurrencyProperties properties;

    public BigDecimal getRubAmount() {
        String postFixUrl = POSTFIX_URL_GET_RUB_TEMPLATE.formatted(CURRENCY_NAME);
        RestTemplate restTemplate = new RestTemplate();
        String token = properties.getToken();
        RequestEntity<Void> request = RequestEntity
                .get(properties.getUrl() + postFixUrl)
                .header(properties.getHeaderTokenName(), token)
                .build();
        ResponseEntity<FreeCurrencyDtoRs> response = restTemplate.exchange(request, FreeCurrencyDtoRs.class);
        FreeCurrencyDtoRs freeCurrencyDtoRs = response.getBody();
        return freeCurrencyDtoRs.getData().get(CURRENCY_NAME);
    }
}
