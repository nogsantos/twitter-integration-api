package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import io.swagger.annotations.*;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.dto.HashTagDTO;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hashtag")
@Api(description = "Hashtag controller")
public class HashTagController {

    private HashTagService service;

    @Autowired
    public HashTagController(HashTagService service) {
        this.service = service;
    }

    @ApiOperation("Get all HashTags")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/")
    public Flux<HashTagDTO> findAll() throws HashTagException {
        return service.findAll();
    }

    @ApiOperation("Get a HashTags")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/search/{text}")
    public Mono<Mono<HashTagDTO>> find(
            @ApiParam(value = "Search in api by HashTag text")
            @PathVariable String text
    ) throws HashTagException {
        return Mono.justOrEmpty(service.findById(text));
    }

    @ApiOperation("Save a HashTags")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully saved"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Resource not found")
    })
    @PostMapping("/save")
    public Mono<HashTagDTO> save(@RequestBody final HashTagDocument hashTag) throws HashTagException {
        return service.save(hashTag);
    }
}
