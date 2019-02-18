package me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class HashTagException extends ResponseStatusException {

    public HashTagException(HttpStatus status, String message) {
        super(status, message, null);
    }


}
