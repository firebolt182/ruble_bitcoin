package org.javaacademy.rubl_bitcoin.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Value;

@Value
public class BitcoinRubleDto {
    private BigDecimal bitcoinRubleAmount;
    private LocalDateTime localDateTime;
}
