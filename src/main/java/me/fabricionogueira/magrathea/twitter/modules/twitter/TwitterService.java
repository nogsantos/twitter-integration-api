package me.fabricionogueira.magrathea.twitter.modules.twitter;

import reactor.core.publisher.Flux;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

public interface TwitterService {

    Flux<TwitterDocument> create(List<TwitterDocument> tweets) throws TwitterException;

}
