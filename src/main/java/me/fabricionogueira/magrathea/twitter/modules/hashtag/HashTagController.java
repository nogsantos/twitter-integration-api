package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import io.swagger.annotations.*;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.dto.HashTagDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hashtag")
@Api(description = "HashTag rest controller")
public class HashTagController {

    final private HashTagService service;
    final private ModelMapper mapper;

    @Autowired
    public HashTagController(HashTagService service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @ApiOperation("Get all HashTags enabled and disabled")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/")
    public Flux<HashTagDTO> findAll() {
        return Flux.fromStream(() -> service.findAll().toStream()
                .map(hashTagDocument -> mapper.map(hashTagDocument, HashTagDTO.class))
        );
    }

    @ApiOperation("Get a HashTag by string id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/search/id/{id}")
    public Mono<HashTagDTO> findById(
            @ApiParam(value = "Search a HashTag by id")
            @PathVariable String id) {

        return service
                .findById(id)
                .map(hashTagDocument -> mapper.map(hashTagDocument, HashTagDTO.class));
    }

    @ApiOperation("Get a HashTag by string text")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/search/text/{text}")
    public Mono<HashTagDTO> findByText(
            @ApiParam(value = "Search a HashTag by text")
            @PathVariable String text) {

        return service
                .findByText(text)
                .map(hashTagDocument -> mapper.map(hashTagDocument, HashTagDTO.class));
    }

    @ApiOperation("Create a new HashTag")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully saved"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Resource not found")
    })
    @PostMapping("/")
    public Mono<HashTagDTO> create(@RequestBody final HashTagDocument hashTag) {
        return service.create(hashTag).map(hashTagDocumentMono -> mapper.map(hashTagDocumentMono, HashTagDTO.class));
    }

    @ApiOperation("Delete a HashTag")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully saved"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Resource not found")
    })
    @DeleteMapping("/")
    public Mono<Boolean> delete(@RequestBody final HashTagDocument hashTag) {
        return service.delete(hashTag);
    }
}
