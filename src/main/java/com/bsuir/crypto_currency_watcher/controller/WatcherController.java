package com.bsuir.crypto_currency_watcher.controller;

import com.bsuir.crypto_currency_watcher.model.Watcher;
import com.bsuir.crypto_currency_watcher.service.WatcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/watchers")
@RequiredArgsConstructor
public class WatcherController {

    private final WatcherService watcherService;

    @PostMapping("/notify")
    public ResponseEntity<Watcher> notify(@RequestParam String username, @RequestParam String symbol) {
        return ResponseEntity.ok().body(watcherService.notify(username, symbol));
    }
}
