package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class TwitterApiServiceImp implements TwitterApiService {

    final private TwitterService service;

    @Autowired
    public TwitterApiServiceImp(TwitterService service) {
        this.service = service;
    }

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

        } catch (TwitterException e) {
            throw new TwitterException("EXCEPT " + e.getMessage());
        }
    }

    @Override
    public void getByHashAndSave(String hashTag) throws TwitterException {
        try {
            Twitter twitter = TwitterFactory.getSingleton();
            Query query = new Query("#" + hashTag);
            query.setCount(10);
            query.setLang("pt");
            QueryResult result = twitter.search(query);
            try {
                ModelMapper mapper = new ModelMapper();
                List<TwitterDocument> list = new ArrayList<>();

                result.getTweets().forEach(tweets -> list.add(mapper.map(tweets, TwitterDocument.class)));

                Stream<TwitterDocument> twitterStream = service.create(list).toStream();
                log.debug("STREAM {}", twitterStream.count());

            } catch (TwitterException e) {
                log.debug("ERROR-ON-CREATE-DOCUMENT {}", e.getMessage());
            }
        } catch (TwitterException e) {
            throw new TwitterException("EXCEPT " + e.getMessage());
        }
    }
}
