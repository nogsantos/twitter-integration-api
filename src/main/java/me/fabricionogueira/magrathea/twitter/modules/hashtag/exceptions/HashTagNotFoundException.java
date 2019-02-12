package me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data not found")
public class HashTagNotFoundException extends HashTagException {
    public HashTagNotFoundException(String message) {
        super(message);
    }
}
