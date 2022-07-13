package com.bsuir.crypto_currency_watcher.controller;

import com.bsuir.crypto_currency_watcher.model.Cryptocurrency;
import com.bsuir.crypto_currency_watcher.service.CryptocurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptocurrencies")
@RequiredArgsConstructor
@CrossOrigin
public class CryptocurrencyController {

    private final CryptocurrencyService cryptocurrencyService;

    @GetMapping
    public ResponseEntity<List<Cryptocurrency>> getCryptocurrencies() {
        return ResponseEntity.ok().body(cryptocurrencyService.getCryptocurrencies());
    }

    @GetMapping("/price/{symbol}")
    public ResponseEntity<Float> getPrice(@PathVariable String symbol) {
        return ResponseEntity.ok().body(cryptocurrencyService.getPrice(symbol));
    }
}
