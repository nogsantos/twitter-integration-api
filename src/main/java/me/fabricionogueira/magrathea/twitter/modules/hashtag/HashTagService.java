package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HashTagService {

    Mono<HashTagDocument> create(HashTagDocument hashTag) throws HashTagException;

    Mono<Boolean> delete(String id) throws HashTagException;

    Flux<HashTagDocument> findAll() throws HashTagException;

    Flux<HashTagDocument> findAllEnabled() throws HashTagException;

    Flux<HashTagDocument> findAllDisabled() throws HashTagException;

    Mono<HashTagDocument> findById(String id) throws HashTagException;

    Mono<HashTagDocument> findByText(String text) throws HashTagException;

}
