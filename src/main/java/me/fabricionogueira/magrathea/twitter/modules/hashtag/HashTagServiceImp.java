package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import me.fabricionogueira.magrathea.twitter.modules.hashtag.dto.HashTagDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HashTagServiceImp implements HashTagService {

    private HashTagRepository repository;
    private ModelMapper mapper;

    @Autowired
    public HashTagServiceImp(HashTagRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    @Override
    public Flux<HashTagDTO> findAll() {
        return Flux.fromStream(() -> repository.findAll().toStream()
                .map(hashTagDocument -> mapper.map(hashTagDocument, HashTagDTO.class))
        );
    }

    @Override
    public Mono<HashTagDTO> findById(String id) {
        return repository.findById(id).map(hashTagDocument -> mapper.map(hashTagDocument, HashTagDTO.class));
    }

    @Override
    public Mono<HashTagDTO> save(final HashTagDocument hashTag) {
        return repository.save(hashTag).map(hashTagDocumentMono -> mapper.map(hashTagDocumentMono, HashTagDTO.class));
    }

    @Override
    public Disposable remove(HashTagDocument hashTag) {
        return null;
    }
}
