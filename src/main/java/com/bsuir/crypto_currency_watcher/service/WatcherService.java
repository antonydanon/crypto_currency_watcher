package com.bsuir.crypto_currency_watcher.service;

import com.bsuir.crypto_currency_watcher.dto.WatcherDTO;
import com.bsuir.crypto_currency_watcher.exception.NonExistentCryptocurrencySymbolException;
import com.bsuir.crypto_currency_watcher.exception.WatcherAlreadyExistsException;
import com.bsuir.crypto_currency_watcher.model.Cryptocurrency;
import com.bsuir.crypto_currency_watcher.model.Watcher;
import com.bsuir.crypto_currency_watcher.repository.WatcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
                Watcher watcher = createWatcher(watcherDTO, cryptocurrencyService.getCryptocurrencyBySymbol(watcherDTO.getSymbol()));
                return watcherRepository.save(watcher);
            } else
                throw new NonExistentCryptocurrencySymbolException(watcherDTO.getSymbol());
        } else
            throw new WatcherAlreadyExistsException(watcherDTO.getUsername());
    }

    private Watcher createWatcher(WatcherDTO watcherDTO, Cryptocurrency cryptocurrency){
        return Watcher.builder()
                .username(watcherDTO.getUsername())
                .priceAtRegistration(cryptocurrency.getPriceUsd())
                .cryptocurrencies(Set.of(cryptocurrency))
                .build();
    }

    public List<Watcher> getAllWatchers(){
        return watcherRepository.findAll();
    }

}
