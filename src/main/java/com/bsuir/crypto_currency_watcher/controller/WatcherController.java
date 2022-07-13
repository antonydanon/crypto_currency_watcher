package com.bsuir.crypto_currency_watcher.controller;

import com.bsuir.crypto_currency_watcher.dto.WatcherDTO;
import com.bsuir.crypto_currency_watcher.model.Watcher;
import com.bsuir.crypto_currency_watcher.service.WatcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/watchers")
@RequiredArgsConstructor
@CrossOrigin
public class WatcherController {

    private final WatcherService watcherService;

    @PostMapping("/notify")
    public ResponseEntity<Watcher> notify(@RequestBody WatcherDTO watcherDTO) {
        System.out.println(watcherDTO);
        return ResponseEntity.ok().body(watcherService.notify(watcherDTO));
    }
}
