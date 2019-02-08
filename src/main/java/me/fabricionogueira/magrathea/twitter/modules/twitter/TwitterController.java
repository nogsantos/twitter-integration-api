package me.fabricionogueira.magrathea.twitter.modules.twitter;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

@RestController
@RequestMapping("/twitter")
@Api(description = "Twitter controller")
public class TwitterController {

    private TwitterService service;

    @Autowired
    public TwitterController(TwitterService service) {
        this.service = service;
    }

    @ApiOperation("Get a list of Twitters by HashTag")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Request no found")
    })
    @GetMapping("/search/{hashTag}")
    public List<Status> search(
            @ApiParam(value = "Search on twitter by HashTag text")
            @PathVariable String hashTag
    ) throws TwitterException {
        return service.searchTweetsBy(hashTag);
    }
}
