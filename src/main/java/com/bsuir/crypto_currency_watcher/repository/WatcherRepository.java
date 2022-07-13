package com.bsuir.crypto_currency_watcher.repository;

import com.bsuir.crypto_currency_watcher.model.Cryptocurrency;
import com.bsuir.crypto_currency_watcher.model.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface WatcherRepository extends JpaRepository<Watcher, Long> {
    boolean existsByUsername(String username);
}
