package com.bsuir.crypto_currency_watcher.service;

import com.bsuir.crypto_currency_watcher.exception.NonExistentCryptocurrencySymbolException;
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

    public Float getCryptocurrencyPrice(String symbol){
        if(cryptocurrencyExistsBySymbol(symbol))
            return getCryptocurrencyBySymbol(symbol).getPriceUsd();
        else
            throw new NonExistentCryptocurrencySymbolException("Cryptocurrencies with the symbol " + symbol + " do not exists!");
    }

    public Cryptocurrency getCryptocurrencyBySymbol(String symbol){
        return cryptocurrencyRepository.findBySymbol(symbol);
    }

    public boolean cryptocurrencyExistsBySymbol(String symbol){
        return cryptocurrencyRepository.existsBySymbol(symbol);
    }
}
