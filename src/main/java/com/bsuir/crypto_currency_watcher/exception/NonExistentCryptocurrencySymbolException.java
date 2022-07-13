package com.bsuir.crypto_currency_watcher.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class NonExistentCryptocurrencySymbolException extends ExceptionWithHttpStatus{
    public NonExistentCryptocurrencySymbolException(String message) {
        super(BAD_REQUEST, message);
    }
}
