package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.Data;
import me.fabricionogueira.magrathea.twitter.modules.user.UserDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "tweets")
public class TwitterDocument {
    @Id
    private Long id;
    private Date createdAt;
    private String text;
    private Long retweetCount;
    private String lang;
    private String[] hashtagEntities;
    private UserDocument user;

}
