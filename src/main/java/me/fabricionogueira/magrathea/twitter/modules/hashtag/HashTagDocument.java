package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import static java.lang.Boolean.TRUE;

@Data
@Document(collection = "hashtag")
public class HashTagDocument {
    @Id
    private String id;
    @Indexed(unique = true)
    private String text;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;
    @Version
    private Long version;

    private boolean enable = TRUE;
}
