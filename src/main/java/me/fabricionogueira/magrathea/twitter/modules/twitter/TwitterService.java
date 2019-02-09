package me.fabricionogueira.magrathea.twitter.modules.twitter;

import me.fabricionogueira.magrathea.twitter.modules.twitter.dto.TwitterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import twitter4j.*;

@Service
public class TwitterService {

    private Twitter getTwitterinstance() {
        return TwitterFactory.getSingleton();
    }

    public Flux<TwitterDTO> searchTweetsBy(String hashTag) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Query query = new Query("#" + hashTag);
        QueryResult result = twitter.search(query);

        ModelMapper mapper = new ModelMapper();
        return Flux.fromStream(() -> result.getTweets().stream().map(twittes -> mapper.map(twittes, TwitterDTO.class)));
    }

}
