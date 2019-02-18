package me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions;

import org.springframework.http.HttpStatus;

public class HashTagRequiredFieldsException extends HashTagException {

    public HashTagRequiredFieldsException(HttpStatus status, String message) {
        super(status, message);
    }
}
