package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.extern.slf4j.Slf4j;
import me.fabricionogueira.magrathea.twitter.modules.twitter.dto.TwitterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import twitter4j.*;

@Service
@Slf4j
public class TwitterService {

    private Twitter getTwitterInstance() {
        return TwitterFactory.getSingleton();
    }

    public Flux<TwitterDTO> searchTweetsBy(String hashTag) throws TwitterException {
        log.debug("Getting twitters by HashTag {}", hashTag);
        Twitter twitter = getTwitterInstance();
        Query query = new Query("#" + hashTag);
        query.setCount(100);
        query.setLang("pt-BR");
        QueryResult result = twitter.search(query);

        ModelMapper mapper = new ModelMapper();
        return Flux.fromStream(() -> result.getTweets().stream().map(twittes -> mapper.map(twittes, TwitterDTO.class)));
    }

}
