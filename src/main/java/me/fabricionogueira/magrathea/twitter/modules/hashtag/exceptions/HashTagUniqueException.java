package me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Unique value")
public class HashTagUniqueException extends HashTagException {
    public HashTagUniqueException(String message) {
        super(message);
    }
}
