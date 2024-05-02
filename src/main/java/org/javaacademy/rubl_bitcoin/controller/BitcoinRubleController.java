package org.javaacademy.rubl_bitcoin.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.rubl_bitcoin.service.BitcoinRubleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
@RequiredArgsConstructor
public class BitcoinRubleController {
    private final BitcoinRubleService bitcoinRubleService;

    @PostMapping("/now")
    public ResponseEntity<?> BitcoinRubAmountNow() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(bitcoinRubleService.getBitcoinRubleAmount());
    }

    @GetMapping("/history")
    public ResponseEntity<?> getHistory() {
        return ResponseEntity.status(HttpStatus.FOUND).body(bitcoinRubleService.findAll());
    }

    @GetMapping("/average")
    public ResponseEntity<?> getAverage() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bitcoinRubleService.averageCalc());
    }
}
