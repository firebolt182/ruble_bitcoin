package org.javaacademy.rubl_bitcoin.repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.javaacademy.rubl_bitcoin.dto.BitcoinRubleDto;
import org.springframework.stereotype.Service;

@Service
public class BitcoinRubleRepository {
    private Map<String, BitcoinRubleDto> data = new LinkedHashMap<>();

    public void add(BitcoinRubleDto dto) {
        data.put(dto.getLocalDateTime().toString(), dto);
    }

    public List<BitcoinRubleDto> findAll() {
        return new ArrayList<>(data.values());
    }

    public BigDecimal averageCalc() {
        if (data.isEmpty()) {
            throw new RuntimeException("No rates now");
        }
        BigDecimal sum = data.values().stream()
                .map(BitcoinRubleDto::getBitcoinRubleAmount)
                .reduce(BigDecimal::add).orElseThrow();
        return sum.divide(BigDecimal.valueOf(data.size()), 2, RoundingMode.CEILING);
    }
}
