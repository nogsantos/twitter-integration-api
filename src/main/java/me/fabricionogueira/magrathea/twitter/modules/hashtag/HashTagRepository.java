package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashTagRepository extends ReactiveMongoRepository<HashTagDocument, String> {
}
