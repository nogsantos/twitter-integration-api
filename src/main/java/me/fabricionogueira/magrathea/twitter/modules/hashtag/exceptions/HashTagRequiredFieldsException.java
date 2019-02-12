package me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You have an error on your request")
public class HashTagRequiredFieldsException extends HashTagException {
    public HashTagRequiredFieldsException(String message) {
        super(message);
    }
}
