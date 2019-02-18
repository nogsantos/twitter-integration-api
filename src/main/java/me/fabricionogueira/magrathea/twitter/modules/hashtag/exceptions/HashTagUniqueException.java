package me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions;

import org.springframework.http.HttpStatus;

public class HashTagUniqueException extends HashTagException {

    public HashTagUniqueException(HttpStatus status, String message) {
        super(status, message);
    }
}
