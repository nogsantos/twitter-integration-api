package me.fabricionogueira.magrathea.twitter.modules.twitter;

import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "twitterService")
public class TwitterService {

    private Twitter getTwitterinstance() {
        return TwitterFactory.getSingleton();
    }

    public List<String> searchTweetsBy(String hashTag) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Query query = new Query("#" + hashTag);
        QueryResult result = twitter.search(query);
        List<Status> statuses = result.getTweets();
        return statuses.stream().map(Status::getText).collect(Collectors.toList());
    }

}
