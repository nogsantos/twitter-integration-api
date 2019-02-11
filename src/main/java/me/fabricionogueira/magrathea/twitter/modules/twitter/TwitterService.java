package me.fabricionogueira.magrathea.twitter.modules.twitter;

import reactor.core.publisher.Mono;
import twitter4j.Status;

public interface TwitterService {

    Mono<TwitterDocument> save(TwitterDocument twitterDocument);

    Mono<TwitterDocument> save(Status tweet);

}
