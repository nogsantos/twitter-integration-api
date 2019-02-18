package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import lombok.extern.slf4j.Slf4j;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagException;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagNotFoundException;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagRequiredFieldsException;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagUniqueException;
import me.fabricionogueira.magrathea.twitter.modules.twitter.TwitterApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import twitter4j.TwitterException;

import static java.lang.Boolean.TRUE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Slf4j
public class HashTagServiceImp implements HashTagService {

    final private HashTagRepository repository;
    final private TwitterApiService twitterApiService;

    @Autowired
    public HashTagServiceImp(HashTagRepository repository, TwitterApiService twitterApiService) {
        this.repository = repository;
        this.twitterApiService = twitterApiService;
    }

    @Override
    public Flux<HashTagDocument> findAll() {
        return repository.findAllByOrderByCreatedDateDesc();
    }

    @Override
    public Mono<HashTagDocument> findById(String id) throws HashTagException {
        if (id == null || id.isEmpty()) {
            throw new HashTagRequiredFieldsException(BAD_REQUEST, "O Id para busca é obrigatório");
        }
        return repository.findById(id);
    }

    @Override
    public Mono<HashTagDocument> findByText(String text) throws HashTagException {
        if (text == null || text.isEmpty()) {
            throw new HashTagRequiredFieldsException(BAD_REQUEST, "O texto para busca é obrigatório");
        }
        return repository.findByText(text);
    }

    @Override
    public Mono<HashTagDocument> create(final HashTagDocument hashTag) throws HashTagException {
        if (hashTag == null || hashTag.getText().isEmpty()) {
            throw new HashTagRequiredFieldsException(BAD_REQUEST, "O campo Texto é obrigatório");
        }

        return repository
                .insert(hashTag)
                .doOnSuccess(hashTagDocument -> saveTweetsByHashTag(hashTag, hashTagDocument))
                .onErrorResume(e -> Mono.error(new HashTagUniqueException(BAD_REQUEST, "A HashTag " + hashTag.getText() + " já está cadastrada no sistema")));
    }


    @Override
    public Mono<Boolean> delete(HashTagDocument hashTag) throws HashTagException {
        return findById(hashTag.getId())
                .doOnSuccess(hashTagDocument -> repository.delete(hashTagDocument).subscribe())
                .switchIfEmpty(Mono.error(new HashTagNotFoundException(NOT_FOUND, "HashTag " + hashTag + " não localizada")))
                .flatMap(s -> Mono.just(TRUE));
    }

    private void saveTweetsByHashTag(HashTagDocument hashTag, HashTagDocument hashTagDocument) {
        try {
            twitterApiService.saveTweetByHashTag(hashTag.getText()).subscribe();
        } catch (TwitterException e) {
            log.debug("ERROR: {}", e.getMessage());
        }
    }

}
