package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "twitterService")
@Slf4j
public class TwitterService {

    @Value("${oauth.consumerKey}")
    private String oauthConsumerKey;

    @Value("${oauth.consumerSecret}")
    private String oauthConsumerSecret;

    @Value("${oauth.accessToken}")
    private String oauthAccessToken;

    @Value("${oauth.accessTokenSecret}")
    private String oauthAccessTokenSecret;


    private Twitter getTwitterinstance() {

        log.info("[Twitter auth] ConsumerKey: {} ConsumerSecret: {} AccessToken: {} TokenSecret: {}",
                oauthConsumerKey,
                oauthConsumerSecret,
                oauthAccessToken,
                oauthAccessTokenSecret
        );

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(oauthConsumerKey)
                .setOAuthConsumerSecret(oauthConsumerSecret)
                .setOAuthAccessToken(oauthAccessToken)
                .setOAuthAccessTokenSecret(oauthAccessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getSingleton();

//        return TwitterFactory.getSingleton();
    }

    public List<String> searchtweets() throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Query query = new Query("source:twitter4j baeldung");
        QueryResult result = twitter.search(query);
        List<Status> statuses = result.getTweets();
        return statuses.stream().map(Status::getText).collect(Collectors.toList());
    }

}
