package me.fabricionogueira.magrathea.twitter.modules.twitter;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface TwitterRepository extends ReactiveMongoRepository<TwitterDocument, String> {

    Flux<TwitterDocument> findAllByOrderByCreatedDateDesc();

    Flux<TwitterDocument> findByHashtagEntitiesIsIn(List<String> hashTag);
}
