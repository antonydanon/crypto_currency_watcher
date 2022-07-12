package com.bsuir.crypto_currency_watcher.controller;

import com.bsuir.crypto_currency_watcher.service.WatcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watchers")
@RequiredArgsConstructor
public class WatcherController {

    private final WatcherService watcherService;
}
