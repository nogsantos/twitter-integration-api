package me.fabricionogueira.magrathea.twitter.modules.twitter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data not found")
public class TwitterNotFoundLocalException extends TwitterLocalException {
    public TwitterNotFoundLocalException(String message) {
        super(message);
    }
}
