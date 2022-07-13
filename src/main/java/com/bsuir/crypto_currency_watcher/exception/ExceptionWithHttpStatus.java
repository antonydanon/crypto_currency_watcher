package com.bsuir.crypto_currency_watcher.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionWithHttpStatus extends RuntimeException {
    private HttpStatus status;
    private String message;
}
