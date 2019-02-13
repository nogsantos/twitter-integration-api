package me.fabricionogueira.magrathea.twitter.modules.user;

import lombok.Data;
import me.fabricionogueira.magrathea.twitter.modules.twitter.TwitterDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "user")
public class UserDocument {
    @Id
    private String id;
    private String name;
    private String screenName;
    @Indexed
    private String email;
    private String location;
    private String biggerProfileImageURLHttps;
}
