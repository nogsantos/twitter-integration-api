package me.fabricionogueira.magrathea.twitter.modules.twitter;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterRepository extends ReactiveMongoRepository<TwitterDocument, String> {
}
