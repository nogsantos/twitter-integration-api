package me.fabricionogueira.magrathea.twitter.modules.twitter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import twitter4j.Status;

@Service
public class TwitterServiceImp implements TwitterService {

    private TwitterRepository repository;

    @Autowired
    public TwitterServiceImp(TwitterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<TwitterDocument> save(TwitterDocument twitterDocument) {
        return repository.save(twitterDocument);
    }

    @Override
    public Mono<TwitterDocument> save(Status tweet) {
        ModelMapper mapper = new ModelMapper();
        return repository.save(mapper.map(tweet, TwitterDocument.class));
    }
}
