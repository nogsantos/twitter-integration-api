package me.fabricionogueira.magrathea.twitter.modules.twitter.exceptions;

import org.springframework.http.HttpStatus;

public class TwitterNotFoundLocalException extends TwitterLocalException {
    public TwitterNotFoundLocalException(HttpStatus status, String message) {
        super(status, message);
    }
}
