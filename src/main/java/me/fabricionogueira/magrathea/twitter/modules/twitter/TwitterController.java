package me.fabricionogueira.magrathea.twitter.modules.twitter;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

@RestController
@RequestMapping("/twitter")
@Api(description = "Twitter controller")
public class TwitterController {

    private TwitterService service;

    @Autowired
    public TwitterController(TwitterService service) {
        this.service = service;
    }

    @ApiOperation("Get twitter ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Request no found")
    })
    @GetMapping("/search")
    public ResponseEntity search(
            @RequestParam(required = true)
            @ApiParam(value = "Serch by hash tags") String hashTag
    ) throws TwitterException {

        return ResponseEntity.ok(service.searchTweetsBy(hashTag));
    }
}
