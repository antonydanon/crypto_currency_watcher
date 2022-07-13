package com.bsuir.crypto_currency_watcher.controller;

import com.bsuir.crypto_currency_watcher.service.CryptocurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cryptocurrencies")
@RequiredArgsConstructor
@CrossOrigin
public class CryptocurrencyController {

    private final CryptocurrencyService cryptocurrencyService;

    @GetMapping
    public ResponseEntity<?> getCryptocurrencies() {
        return ResponseEntity.ok().body(cryptocurrencyService.getCryptocurrencies());
    }

    @GetMapping("/price")
    public ResponseEntity<?> getCryptocurrencyPrice(@RequestParam String symbol) {
        return ResponseEntity.ok().body(cryptocurrencyService.getCryptocurrencyPrice(symbol));
    }
}
