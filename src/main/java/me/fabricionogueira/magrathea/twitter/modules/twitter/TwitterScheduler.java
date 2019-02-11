package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.extern.slf4j.Slf4j;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.HashTagDocument;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.HashTagService;
import me.fabricionogueira.magrathea.twitter.modules.twitter.dto.TwitterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import twitter4j.TwitterException;

import java.time.LocalDate;
import java.util.List;

@Component
@EnableScheduling
@Slf4j
public class TwitterScheduler {

    private static final String TIME_ZONE = "America/Sao_Paulo";
    private static final String SCHEDULER = "SCHEDULER";

    private HashTagService hashTagService;
    private TwitterService twitterService;

    @Autowired
    public TwitterScheduler(HashTagService hashTagService, TwitterService twitterService) {
        this.hashTagService = hashTagService;
        this.twitterService = twitterService;
    }

        @Scheduled(cron = "0 0 12 * * *", zone = TIME_ZONE)
//    @Scheduled(fixedRate = 4000)
    public void getTwitterMessagesByHashTagTask() {
        List<String> hashTags = getAllAvailiableHashTags();
        hashTags.forEach(s -> {
            try {
                Flux<TwitterDTO> twitterDTOFlux = twitterService.searchTweetsByHashTag(s);
                log.debug(twitterDTOFlux.toString());
            } catch (TwitterException e) {
                e.printStackTrace();
            }
        });

        log.info("Fixed Rate Task :: Execution Time {}", LocalDate.now().toString());

    }

    private List<String> getAllAvailiableHashTags() {
        return hashTagService.findAll().map(HashTagDocument::getText).collectList().block();
    }
}
