package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HashTagTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldTestEndpointAll() {
        webTestClient.get().uri("/hashtag/")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void shouldTestEndpointGetByHashTag() {
        webTestClient.get().uri("/hashtag/search/some")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

}