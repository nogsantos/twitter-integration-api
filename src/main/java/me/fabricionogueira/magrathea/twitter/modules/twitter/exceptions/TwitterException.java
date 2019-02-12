package me.fabricionogueira.magrathea.twitter.modules.twitter.exceptions;

public class TwitterException extends twitter4j.TwitterException {
    public TwitterException(String message) {
        super(message);
    }
}
