package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface HashTagRepository extends ReactiveMongoRepository<HashTagDocument, String> {

    Mono<HashTagDocument> findByText(String text);

    @Query("{enable: true}")
    Flux<HashTagDocument> findAllEnabled();

    @Query("{enable: false}")
    Flux<HashTagDocument> findAllDisabled();
}
