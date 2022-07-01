package org.example.data.store.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such item")
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {

        super(message);
    }
}
