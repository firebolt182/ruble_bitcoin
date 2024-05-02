package org.javaacademy.rubl_bitcoin.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "integration.freecurrency")
@Configuration
@Getter
@Setter
public class FreeCurrencyProperties {
    private String url;
    private String token;
    private String headerTokenName;
}
