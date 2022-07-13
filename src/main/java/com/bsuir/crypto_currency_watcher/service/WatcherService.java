package com.bsuir.crypto_currency_watcher.service;

import com.bsuir.crypto_currency_watcher.dto.WatcherDTO;
import com.bsuir.crypto_currency_watcher.exception.NonExistentCryptocurrencySymbolException;
import com.bsuir.crypto_currency_watcher.exception.WatcherAlreadyExistsException;
import com.bsuir.crypto_currency_watcher.model.Cryptocurrency;
import com.bsuir.crypto_currency_watcher.model.Watcher;
import com.bsuir.crypto_currency_watcher.repository.WatcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WatcherService {

    private final CryptocurrencyService cryptocurrencyService;
    private final WatcherRepository watcherRepository;

    public Watcher notify(WatcherDTO watcherDTO){
        if(!watcherRepository.existsByUsername(watcherDTO.getUsername())){
            if(cryptocurrencyService.cryptocurrencyExistsBySymbol(watcherDTO.getSymbol())) {
                Watcher watcher = createWatcher(watcherDTO.getUsername(), cryptocurrencyService.getCryptocurrencyBySymbol(watcherDTO.getSymbol()));
                return watcherRepository.save(watcher);
            } else
                throw new NonExistentCryptocurrencySymbolException("Cryptocurrencies with the symbol " + watcherDTO.getSymbol() + " do not exists!");
        } else
            throw new WatcherAlreadyExistsException("User with username " + watcherDTO.getUsername() + " already exists!");
    }

    private Watcher createWatcher(String username, Cryptocurrency cryptocurrency){
        Set<Cryptocurrency> cryptocurrencies = new HashSet<>();
        cryptocurrencies.add(cryptocurrency);
        return Watcher.builder()
                .username(username)
                .priceAtRegistration(cryptocurrency.getPriceUsd())
                .cryptocurrencies(cryptocurrencies)
                .build();
    }

    public List<Watcher> getAllWatchers(){
        return watcherRepository.findAll();
    }

}
