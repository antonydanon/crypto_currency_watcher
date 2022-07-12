package com.bsuir.crypto_currency_watcher.service;

import com.bsuir.crypto_currency_watcher.model.Cryptocurrency;
import com.bsuir.crypto_currency_watcher.repository.CryptocurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptocurrencyService {

    private final CryptocurrencyRepository cryptocurrencyRepository;

    public List<Cryptocurrency> getCryptocurrencies() {
        return cryptocurrencyRepository.findAll();
    }

    public Float getPrice(String symbol){
        return cryptocurrencyRepository.findBySymbol(symbol).getPriceUsd();
    }

    public Cryptocurrency getCryptocurrencyBySymbol(String symbol){
        return cryptocurrencyRepository.findBySymbol(symbol);
    }
}
