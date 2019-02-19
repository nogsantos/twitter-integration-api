package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import me.fabricionogueira.magrathea.twitter.modules.hashtag.exceptions.HashTagRequiredFieldsException;
import me.fabricionogueira.magrathea.twitter.modules.twitter.TwitterApiServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HashTagServiceImpTest {

    @Mock
    private HashTagRepository repository;

    @Mock
    private TwitterApiServiceImp twitterApiService;

    @InjectMocks
    private HashTagServiceImp service;

    @Test(expected = HashTagRequiredFieldsException.class)
    public void shouldThrowsAnExceptionWhenTryToFindByIdAndTheIdIsNotValid() {
        service.findById(null);
    }

    @Test(expected = HashTagRequiredFieldsException.class)
    public void shouldThrowsAnExceptionWhenTryToFindTextIdAndTheTextIsNotValid() {
        service.findByText(null);
    }

    @Test(expected = HashTagRequiredFieldsException.class)
    public void shouldThrowsAnExceptionWhenTryToCreateAHashTagAndTheDocumentIsNull() {
        service.create(null);
    }

    @Test(expected = HashTagRequiredFieldsException.class)
    public void shouldThrowsAnExceptionWhenTryToCreateAHashTagAndTheDocumentIsNotNullButTextIsNull() {
        HashTagDocument hashTagDocument = new HashTagDocument();
        hashTagDocument.setText("");
        service.create(hashTagDocument);
    }

}