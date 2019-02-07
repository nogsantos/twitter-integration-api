package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hashtag")
@Api(description = "Twitter hashtag controller")
public class HashTagController {

    @ApiOperation("Get all hashtags ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully sent"),
            @ApiResponse(code = 400, message = "Processing request error"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/")
    public ResponseEntity getAll() throws HashTagException {
        return ResponseEntity.ok("Alive");
    }


}
