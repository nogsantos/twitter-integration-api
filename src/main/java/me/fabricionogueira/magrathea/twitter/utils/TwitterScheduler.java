package me.fabricionogueira.magrathea.twitter.utils;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class TwitterScheduler {

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @Scheduled(cron = "0 0 12 * * *", zone = TIME_ZONE)
    public void getPRo() {
        System.out.println(LocalDateTime.now());
    }
}
