package me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions;

import org.springframework.http.HttpStatus;

public class HashTagNotFoundException extends HashTagException {

    public HashTagNotFoundException(HttpStatus status, String message) {
        super(status, message);
    }
}
