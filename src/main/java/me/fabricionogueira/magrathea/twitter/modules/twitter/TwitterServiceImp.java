package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import twitter4j.Status;
import twitter4j.TwitterException;

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
    public Flux<TwitterDocument> create(List<TwitterDocument> tweets) throws TwitterException {
        return repository.saveAll(tweets);
    }
}
