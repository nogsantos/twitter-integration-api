package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.stream.Stream;

@Service
@Slf4j
public class TwitterApiServiceImp implements TwitterApiService {

    private TwitterServiceImp service;

    @Override
    public Stream<Status> getByHashTag(String hashTag) throws TwitterException {
        try {
            log.debug("Getting twitters by HashTag {}", hashTag);
            Twitter twitter = TwitterFactory.getSingleton();
            Query query = new Query("#" + hashTag);
            query.setCount(100);
            query.setLang("pt");
            QueryResult result = twitter.search(query);

            return result.getTweets().stream();

        }catch (TwitterException e){
            throw new TwitterException("EXCEPT "+e.getMessage());
        }
//        ModelMapper mapper = new ModelMapper();
//                Flux.fromStream(
//                () ->
//                        .stream()
////                        .map(tweet -> service.save(tweet))
//                        .map(tweets -> {
//                            try {
//                                final TwitterDocument map = mapper.map(tweets, TwitterDocument.class);
//                                System.out.println("Try " + map.getId());
//                                service.save(map);
//                            } catch (NullPointerException e) {
//                                System.out.println("Cat " + e.getMessage());
//                            }
//                            return mapper.map(tweets, TwitterDTO.class);
//                        }));
    }

}
