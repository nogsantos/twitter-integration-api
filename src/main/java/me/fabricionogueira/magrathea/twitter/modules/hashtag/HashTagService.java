package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HashTagService {

    Flux<HashTagDocument> findAll();

    Mono<HashTagDocument> findByText(String text);

    Mono<HashTagDocument> save(HashTagDocument hashTag);

    Disposable remove(HashTagDocument hashTag);
}
