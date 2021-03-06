package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.extern.slf4j.Slf4j;
import me.fabricionogueira.magrathea.twitter.modules.twitter.exceptions.TwitterLocalException;
import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class TwitterServiceImp implements TwitterService {

    final private TwitterRepository repository;

    @Autowired
    public TwitterServiceImp(TwitterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<TwitterDocument> create(List<TwitterDocument> tweets) {
        return repository.saveAll(tweets);
    }

    @Override
    public Flux<TwitterDocument> findAll() {
        return repository.findAllByOrderByCreatedDateDesc();
    }

    @Override
    public Flux<TwitterDocument> findByHashTag(String hashTag) {
        log.debug("HashtagEntityJSONImpl{text='{}'}", hashTag);
        return repository
                .findByHashtagEntitiesIsIn(Collections.singletonList("HashtagEntityJSONImpl{text='" + hashTag + "'}"))
                .switchIfEmpty(Subscriber::onComplete)
                .onErrorStop();
    }
}
