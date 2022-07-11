package com.bsuir.crypto_currency_watcher.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CryptocurrencyDTO {
        private long id;
        private String symbol;
        private String name;
        private String nameid;
        private int rank;
        private float price_usd;
        private float percent_change_24h;
        private float percent_change_1h;
        private float percent_change_7d;
        private float market_cap_usd;
        private float volume24;
        private float volume24_native;
        private float csupply;
        private float price_btc;
        private float tsupply;
        private float msupply;
}
