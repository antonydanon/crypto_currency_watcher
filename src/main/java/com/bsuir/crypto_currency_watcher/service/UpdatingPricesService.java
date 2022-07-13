package com.bsuir.crypto_currency_watcher.service;

import com.bsuir.crypto_currency_watcher.dto.CryptocurrencyDTO;
import com.bsuir.crypto_currency_watcher.model.Cryptocurrency;
import com.bsuir.crypto_currency_watcher.model.Watcher;
import com.bsuir.crypto_currency_watcher.repository.CryptocurrencyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class UpdatingPricesService {

    private final WatcherService watcherService;
    private final CryptocurrencyService cryptocurrencyService;
    private final CryptocurrencyRepository cryptocurrencyRepository;

    private static final String API_URL = "https://api.coinlore.net/api/ticker/?id=";
    private static final long[] ID_OF_CRYPTOCURRENCY = {90, 80, 48543};
    private static final byte COUNT_OF_AVAILABLE_CRYPTOCURRENCIES = 3;
    private static final int ONE_MINUTE_IN_MILLISECONDS = 60000;
    private static final float ONE_PERCENT = 1.0f;
    private static final int ONE_HUNDRED_PERCENT = 100;

    @Scheduled(fixedDelay = ONE_MINUTE_IN_MILLISECONDS)
    @Transactional
    public void updatePrices(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CryptocurrencyDTO[]> response;

        for (byte i = 0; i < COUNT_OF_AVAILABLE_CRYPTOCURRENCIES; i ++){
            response = restTemplate.getForEntity(API_URL + ID_OF_CRYPTOCURRENCY[i], CryptocurrencyDTO[].class);
            cryptocurrencyRepository.updatePrice(Objects.requireNonNull(response.getBody())[0].getPrice_usd(), ID_OF_CRYPTOCURRENCY[i]);
        }

        checkPricesChange();
    }

    private void checkPricesChange(){
        float changePercent;
        List<Watcher> watchers = watcherService.getAllWatchers();
        List<Cryptocurrency> cryptocurrencies = cryptocurrencyService.getCryptocurrencies();
        for (Watcher watcher : watchers) {
            for (Cryptocurrency cryptocurrency : cryptocurrencies) {
                if (watcher.getCryptocurrencies().contains(cryptocurrency)) {
                    changePercent = calculatePercentageChange(cryptocurrency.getPriceUsd(), watcher.getPriceAtRegistration());
                    if (Math.abs(changePercent) > ONE_PERCENT) {
                        log.warn("Symbol: " + cryptocurrency.getSymbol() + "; Username: " + watcher.getUsername() + "; Change percent: " + changePercent + "%.");
                    }
                }
            }
        }
    }

    private float calculatePercentageChange(float newPriceValue, float oldPriceValue){
        return (newPriceValue - oldPriceValue) / oldPriceValue * ONE_HUNDRED_PERCENT;
    }
}
