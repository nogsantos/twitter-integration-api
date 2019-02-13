package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class TwitterApiServiceImp implements TwitterApiService {

    @Value("${application.twitter.config.limit.counter}")
    private Integer configLimit;

    @Value("${application.twitter.config.default.lang}")
    private String configLang;

    final private TwitterService service;

    @Autowired
    public TwitterApiServiceImp(TwitterService service) {
        this.service = service;
    }

    @Override
    public Stream<Status> getByHashTag(String hashTag) throws TwitterException {
        try {
            log.debug("Getting twitters by #{}", hashTag);

            QueryResult result = getQueryResult(getInstance(), getQuery(hashTag));
            return result.getTweets().stream();

        } catch (TwitterException e) {
            throw new TwitterException(e.getMessage());
        }
    }

    @Override
    public void getByHashTagAndSave(String hashTag) throws TwitterException {
        try {
            ModelMapper mapper = new ModelMapper();
            List<TwitterDocument> list = new ArrayList<>();

            getQueryResult(getInstance(), getQuery(hashTag))
                    .getTweets()
                    .forEach(tweets -> list.add(mapper.map(tweets, TwitterDocument.class)));

            Stream<TwitterDocument> twitterStream = service.create(list).toStream();
            log.debug("STREAM {}", twitterStream.count());

        } catch (TwitterException e) {
            throw new TwitterException(e.getMessage());
        }
    }

    private QueryResult getQueryResult(Twitter instance, Query query) throws TwitterException {
        return instance.search(query);
    }

    private Query getQuery(String hashTag) {
        Query query = new Query("#" + hashTag);
        query.setCount(configLimit);
        query.setLang(configLang);
        return query;
    }

    private Twitter getInstance() {
        return TwitterFactory.getSingleton();
    }
}
