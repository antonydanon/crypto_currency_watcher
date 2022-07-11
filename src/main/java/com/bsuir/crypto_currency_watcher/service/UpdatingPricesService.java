package com.bsuir.crypto_currency_watcher.service;

import com.bsuir.crypto_currency_watcher.dto.CryptocurrencyDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UpdatingPricesService {

    private static final String URL = "https://api.coinlore.net/api/ticker/?id=";
    private static final String BITCOIN_ID = "90";
    private static final String ETHEREUM_ID = "80";
    private static final String SOLANA_ID = "48543";

    @Scheduled(fixedDelayString = "4000")
    public void updatePrices(){
        RestTemplate restTemplate = new RestTemplate();
        CryptocurrencyDTO[] cryptocurrency = restTemplate.getForObject(URL + BITCOIN_ID, CryptocurrencyDTO[].class);
        System.out.println("B " + cryptocurrency[0].getPrice_usd());
        cryptocurrency = restTemplate.getForObject(URL + ETHEREUM_ID, CryptocurrencyDTO[].class);
        System.out.println("E " + cryptocurrency[0].getPrice_usd());
        cryptocurrency = restTemplate.getForObject(URL + SOLANA_ID, CryptocurrencyDTO[].class);
        System.out.println("S " + cryptocurrency[0].getPrice_usd());
    }
}
