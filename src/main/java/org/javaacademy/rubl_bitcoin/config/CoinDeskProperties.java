package org.javaacademy.rubl_bitcoin.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "integration.coindesk")
@Configuration
@Getter
@Setter
public class CoinDeskProperties {
    private String url;
    private String currency;
    private String value;
}
