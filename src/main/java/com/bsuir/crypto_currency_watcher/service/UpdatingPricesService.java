package com.bsuir.crypto_currency_watcher.service;

import com.bsuir.crypto_currency_watcher.dto.CryptocurrencyDTO;
import com.bsuir.crypto_currency_watcher.model.Cryptocurrency;
import com.bsuir.crypto_currency_watcher.model.Watcher;
import com.bsuir.crypto_currency_watcher.repository.CryptocurrencyRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class UpdatingPricesService {

    private final WatcherService watcherService;
    private final CryptocurrencyService cryptocurrencyService;
    private final CryptocurrencyRepository cryptocurrencyRepository;

    static final Logger log = LoggerFactory.getLogger(UpdatingPricesService.class);

    private static final String URL = "https://api.coinlore.net/api/ticker/?id=";
    private static final long[] ID_ARRAY_OF_CRYPTOCURRENCY = {90, 80, 48543};

    @Scheduled(fixedDelayString = "60000")
    @Transactional
    public void updatePrices(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CryptocurrencyDTO[]> response;

        for (int i = 0; i < 3; i ++){
            response = restTemplate.getForEntity(URL + ID_ARRAY_OF_CRYPTOCURRENCY[i], CryptocurrencyDTO[].class);
            //log.warn("New  " + Float.toString(response.getBody()[0].getPrice_usd()));
            cryptocurrencyRepository.updatePrice(response.getBody()[0].getPrice_usd(), ID_ARRAY_OF_CRYPTOCURRENCY[i]);
        }

        checkPricesChange();
    }

    private void checkPricesChange(){
        float changePercent = 0.0f;
        List<Watcher> watchers = watcherService.getAllWatchers();
        List<Cryptocurrency> cryptocurrencies = cryptocurrencyService.getCryptocurrencies();
        for (Watcher watcher : watchers) {
            for (Cryptocurrency cryptocurrency : cryptocurrencies) {
                if (watcher.getCryptocurrencies().contains(cryptocurrency)) {
                    changePercent = (cryptocurrency.getPriceUsd() - watcher.getPriceAtRegistration()) / cryptocurrency.getPriceUsd() * 100;
                    if (Math.abs(changePercent) > 1.0) {
                        log.warn("Symbol: " + cryptocurrency.getSymbol() + " Username: " + watcher.getUsername() + " Change percent: " + changePercent + "%");
                    }
                }
            }
        }
    }
}
