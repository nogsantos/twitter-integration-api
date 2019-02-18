package me.fabricionogueira.magrathea.twitter.modules.twitter;

import io.swagger.annotations.*;
import me.fabricionogueira.magrathea.twitter.modules.twitter.dto.TwitterDTO;
import me.fabricionogueira.magrathea.twitter.modules.twitter.exceptions.TwitterLocalException;
import me.fabricionogueira.magrathea.twitter.modules.twitter.exceptions.TwitterNotFoundLocalException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/twitter-local")
@Api(description = "Twitter local base controller")
public class TwitterController {

    final private TwitterServiceImp service;
    final private ModelMapper mapper;

    @Autowired
    public TwitterController(TwitterServiceImp service) {
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @ApiOperation("Get a list of persisted tweets on database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Request no found")
    })
    @GetMapping("/")
    public Flux<TwitterDTO> findAll() {
        return Flux.fromStream(() -> service.findAll().toStream()
                .map(hashTagDocument -> mapper.map(hashTagDocument, TwitterDTO.class))
        );
    }

    @ApiOperation("Get a list of persisted tweets on database by hashTag")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Request no found")
    })
    @GetMapping("/search/{hashTag}")
    public Flux<TwitterDTO> findByHashTag(
            @ApiParam(value = "HashTag to search")
            @PathVariable String hashTag) {

        return service
                .findByHashTag(hashTag)
                .map(twitterDocument -> mapper.map(twitterDocument, TwitterDTO.class));
    }
}
