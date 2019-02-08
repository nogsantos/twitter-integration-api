package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HashTagServiceImp implements HashTagService {

    private HashTagRepository repository;

    @Autowired
    public HashTagServiceImp(HashTagRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<HashTagDocument> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<HashTagDocument> findByText(String text) {
        return repository.findById(text);
    }

    @Override
    public Mono<HashTagDocument> save(HashTagDocument hashTag) {
        return repository.save(hashTag);
    }

    @Override
    public Disposable remove(HashTagDocument hashTag) {
        return null;
    }
}
