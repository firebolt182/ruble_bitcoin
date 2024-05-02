package org.javaacademy.rubl_bitcoin.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.javaacademy.rubl_bitcoin.dto.BitcoinRubleDto;
import org.javaacademy.rubl_bitcoin.repository.BitcoinRubleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BitcoinRubleService {
    private final BitcoinRubleRepository bitcoinRubleRepository;
    private final CoinDeskIntegrationService coinDeskIntegrationService;
    private final FreeCurrencyIntegrationService freeCurrencyIntegrationService;

    public BitcoinRubleDto getBitcoinRubleAmount() {
        BigDecimal bitcoinDollarAmount = coinDeskIntegrationService.getBitcoinDollarAmount();
        BigDecimal rubleAmount = freeCurrencyIntegrationService.getRubAmount();
        BigDecimal resultAmount = bitcoinDollarAmount.multiply(rubleAmount);
        BitcoinRubleDto dto = new BitcoinRubleDto(resultAmount, LocalDateTime.now());
        bitcoinRubleRepository.add(dto);
        return dto;
    }

    public List<BitcoinRubleDto> findAll() {
        return bitcoinRubleRepository.findAll();
    }

    public BigDecimal averageCalc() {
        return bitcoinRubleRepository.averageCalc();
    }
}
