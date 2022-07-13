package com.bsuir.crypto_currency_watcher.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class WatcherAlreadyExistsException extends ExceptionWithHttpStatus{
    public WatcherAlreadyExistsException(String username) {
        super(BAD_REQUEST, "User with username " + username + " already exists!");
    }
}
