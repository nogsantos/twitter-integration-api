package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import me.fabricionogueira.magrathea.twitter.modules.hashtag.dto.HashTagDTO;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HashTagService {

    Flux<HashTagDTO> findAll();

    Mono<HashTagDTO> findById(String id);

    Mono<HashTagDTO> save(HashTagDocument hashTag);

    Disposable remove(HashTagDocument hashTag);
}
