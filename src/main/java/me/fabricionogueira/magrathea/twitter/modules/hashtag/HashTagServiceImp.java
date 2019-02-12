package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagException;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagNotFoundException;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagRequiredFieldsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
public class HashTagServiceImp implements HashTagService {

    private HashTagRepository repository;

    @Autowired
    public HashTagServiceImp(HashTagRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<HashTagDocument> findAll() throws HashTagException {
        return repository
                .findAll()
                .switchIfEmpty(Mono.error(new HashTagNotFoundException("No items founded")));
    }

    @Override
    public Flux<HashTagDocument> findAllEnabled() throws HashTagException {
        return repository
                .findAllEnabled()
                .switchIfEmpty(Mono.error(new HashTagNotFoundException("No items enabled founded")));
    }

    @Override
    public Flux<HashTagDocument> findAllDisabled() throws HashTagException {
        return repository
                .findAllDisabled()
                .switchIfEmpty(Mono.error(new HashTagNotFoundException("Not disabled founded")));
    }

    @Override
    public Mono<HashTagDocument> findById(String id) throws HashTagException {
        return repository
                .findById(id)
                .switchIfEmpty(Mono.error(new HashTagNotFoundException("Noting found with id: " + id)));
    }

    @Override
    public Mono<HashTagDocument> findByText(String text) throws HashTagException {
        return repository
                .findByText(text)
                .switchIfEmpty(Mono.error(new HashTagNotFoundException("Noting found with text: " + text)));
    }

    @Override
    public Mono<HashTagDocument> create(final HashTagDocument hashTag) throws HashTagException {
        if (hashTag == null || hashTag.getText().isEmpty()) {
            throw new HashTagRequiredFieldsException("Text field is required");
        }
        return repository.insert(hashTag);
    }

    @Override
    public Mono<Boolean> delete(String id) throws HashTagException {
        return findById(id).doOnSuccess(hashTag -> {
            hashTag.setEnable(FALSE);
            repository.save(hashTag).subscribe();
        }).flatMap(s -> Mono.just(TRUE));
    }


}
