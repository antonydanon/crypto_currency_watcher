package com.bsuir.crypto_currency_watcher.service;

import com.bsuir.crypto_currency_watcher.repository.CryptocurrencyRepository;
import com.bsuir.crypto_currency_watcher.repository.WatcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WatcherService {

    private final WatcherRepository watcherRepository;

}
