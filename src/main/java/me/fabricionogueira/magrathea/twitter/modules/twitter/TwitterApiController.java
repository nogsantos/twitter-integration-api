package me.fabricionogueira.magrathea.twitter.modules.twitter;

import io.swagger.annotations.*;
import me.fabricionogueira.magrathea.twitter.modules.twitter.dto.TwitterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import twitter4j.TwitterException;

@RestController
@RequestMapping("/twitter/api")
@Api(description = "Api TwitterDocument controller")
public class TwitterApiController {

    private TwitterApiServiceImp service;

    @Autowired
    public TwitterApiController(TwitterApiServiceImp service) {
        this.service = service;
    }

    @ApiOperation("Get a list of Twitters by HashTag")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Request no found")
    })
    @GetMapping("/search/{hashTag}")
    public Flux<TwitterDTO> search(
            @ApiParam(value = "Search on twitter by HashTag text")
            @PathVariable String hashTag
    ) {

        ModelMapper mapper = new ModelMapper();

        return Flux.fromStream(() -> {
            try {
                return service.getByHashTag(hashTag).map(
                        tweets -> mapper.map(tweets, TwitterDTO.class)
                );
            } catch (TwitterException e) {
                e.printStackTrace();
                return null;
            }
        });

    }
}
