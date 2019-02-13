package me.fabricionogueira.magrathea.twitter.modules.twitter;

import reactor.core.publisher.Flux;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.stream.Stream;

public interface TwitterApiService {

    Stream<Status> getByHashTag(String hashTag) throws TwitterException;

    Flux<TwitterDocument> saveTweetByHashTag(String hashTag) throws TwitterException;

}
