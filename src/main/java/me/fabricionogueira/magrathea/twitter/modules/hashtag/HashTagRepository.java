package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface HashTagRepository extends ReactiveMongoRepository<HashTagDocument, String> {

    Flux<HashTagDocument> findAllByOrderByCreatedDateDesc();

    Mono<HashTagDocument> findByText(String text);

}
