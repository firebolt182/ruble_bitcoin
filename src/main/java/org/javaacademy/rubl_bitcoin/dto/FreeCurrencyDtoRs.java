package org.javaacademy.rubl_bitcoin.dto;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Data;

@Data
public class FreeCurrencyDtoRs {
    private Map<String, BigDecimal> data;
}
