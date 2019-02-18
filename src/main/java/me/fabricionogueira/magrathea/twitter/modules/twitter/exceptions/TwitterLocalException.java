package me.fabricionogueira.magrathea.twitter.modules.twitter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TwitterLocalException extends ResponseStatusException {
    public TwitterLocalException(HttpStatus status, String message) {
        super(status, message, null);
    }
}
