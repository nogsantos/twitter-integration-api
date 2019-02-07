package me.fabricionogueira.magrathea.twitter.modules.twitter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/search")
    public ResponseEntity search() throws TwitterException {
        return ResponseEntity.ok(service.searchtweets());
    }
}
