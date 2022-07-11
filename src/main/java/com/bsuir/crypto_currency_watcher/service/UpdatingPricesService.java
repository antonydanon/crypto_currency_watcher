package com.bsuir.crypto_currency_watcher.service;

import com.bsuir.crypto_currency_watcher.dto.CryptocurrencyDTO;
import com.bsuir.crypto_currency_watcher.repository.CryptocurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UpdatingPricesService {

    private final CryptocurrencyRepository cryptocurrencyRepository;

    private static final String URL = "https://api.coinlore.net/api/ticker/?id=";
    private static final long[] ID_ARRAY_OF_CRYPTOCURRENCY = {90, 80, 48543};

    @Scheduled(fixedDelayString = "60000")
    @Transactional
    public void updatePrices(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CryptocurrencyDTO[]> response;

        for (int i = 0; i < 3; i ++){
            response = restTemplate.getForEntity(URL + ID_ARRAY_OF_CRYPTOCURRENCY[i], CryptocurrencyDTO[].class);
            System.out.println(response.getBody()[0].getPrice_usd());
            cryptocurrencyRepository.updatePrice(response.getBody()[0].getPrice_usd(), ID_ARRAY_OF_CRYPTOCURRENCY[i]);
        }
    }
}
