package me.fabricionogueira.magrathea.twitter.modules.twitter;

import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.List;

@Service(value = "twitterService")
public class TwitterService {

    private Twitter getTwitterinstance() {
        return TwitterFactory.getSingleton();
    }

    public List<Status> searchTweetsBy(String hashTag) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Query query = new Query("#" + hashTag);
        QueryResult result = twitter.search(query);
        return result.getTweets();
    }

}
