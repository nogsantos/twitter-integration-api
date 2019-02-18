package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.extern.slf4j.Slf4j;
import me.fabricionogueira.magrathea.twitter.modules.hashtag.HashTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

import java.time.LocalDate;

@Component
@EnableScheduling
@Slf4j
public class TwitterScheduler {

    private static final String TIME_ZONE = "America/Sao_Paulo";

    private HashTagRepository hashTagRepository;
    private TwitterApiService twitterApiService;

    @Autowired
    public TwitterScheduler(HashTagRepository hashTagRepository, TwitterApiService twitterApiService) {
        this.hashTagRepository = hashTagRepository;
        this.twitterApiService = twitterApiService;
    }

//        @Scheduled(fixedRate = 10000)
    @Scheduled(cron = "0 0 12 * * *", zone = TIME_ZONE)
    public void getTwitterMessagesByHashTagTask() {
        hashTagRepository.findAll().doOnEach(hashTagDocument -> {
            try {
                log.debug("SCHEDULER-BY-HASHTAG: {}", hashTagDocument.get().getText());
                twitterApiService
                        .saveTweetByHashTag(hashTagDocument.get().getText())
                        .toStream();
            } catch (TwitterException e) {
                log.debug("SCHEDULER-ERROR: {}", e.getMessage());
            }
        }).toStream();
        log.info("Fixed Rate Task :: Execution Time {}", LocalDate.now().toString());
    }
}
