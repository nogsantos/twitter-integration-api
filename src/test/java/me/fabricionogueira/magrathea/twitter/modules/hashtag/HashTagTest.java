package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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

    @Mock
    private HashTagRepository repository;

    @Test
    public void shouldResponseOkOnWhenGetAll() {
        webTestClient
                .get()
                .uri("/hashtag/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    public void shouldResponseOkWhenGetById() {
        webTestClient
                .get()
                .uri("/hashtag/search/id/somehashid")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    public void shouldResponseOkWhenGetByText() {
        webTestClient
                .get()
                .uri("/hashtag/search/text/sometexttosearch")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    public void shouldResponseBadRequestWhenPostAndTheRequestBodyEmpty() {
        webTestClient
                .post()
                .uri("/hashtag/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isBadRequest();
    }

    @Test
    public void shouldResponseBadRequestWhenDeleteAndTheRequestBodyEmpty() {
        webTestClient
                .delete()
                .uri("/hashtag/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isBadRequest();
    }


}