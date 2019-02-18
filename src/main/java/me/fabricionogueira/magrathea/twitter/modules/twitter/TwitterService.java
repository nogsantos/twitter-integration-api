package me.fabricionogueira.magrathea.twitter.modules.twitter;

import me.fabricionogueira.magrathea.twitter.modules.twitter.exceptions.TwitterLocalException;
import reactor.core.publisher.Flux;

import java.util.List;

public interface TwitterService {

    Flux<TwitterDocument> create(List<TwitterDocument> tweets);

    Flux<TwitterDocument> findAll();

    Flux<TwitterDocument> findByHashTag(String hashTag);

}
