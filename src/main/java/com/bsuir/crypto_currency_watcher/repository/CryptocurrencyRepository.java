package com.bsuir.crypto_currency_watcher.repository;

import com.bsuir.crypto_currency_watcher.model.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Long> {

}
