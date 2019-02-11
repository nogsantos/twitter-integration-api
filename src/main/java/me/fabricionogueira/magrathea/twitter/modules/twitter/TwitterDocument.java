package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class TwitterDocument {
    @Id
    private Long id;
    private Date createdAt;
    private String text;
    private Long retweetCount;
    private String lang;
    private String[] hashtagEntities;
//    @DBRef
//    private UserDocument user;
}
