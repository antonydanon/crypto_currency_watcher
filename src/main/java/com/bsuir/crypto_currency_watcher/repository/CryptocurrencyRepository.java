package com.bsuir.crypto_currency_watcher.repository;

import com.bsuir.crypto_currency_watcher.model.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Long> {
    Cryptocurrency findBySymbol(String symbol);

    @Modifying
    @Query("update Cryptocurrency c set c.priceUsd = ?1 where c.id = ?2")
    void updatePrice(float price_usd, long id);

    boolean existsBySymbol(String symbol);
}
