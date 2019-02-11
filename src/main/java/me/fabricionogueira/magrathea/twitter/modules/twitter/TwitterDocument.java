package me.fabricionogueira.magrathea.twitter.modules.twitter;

import lombok.Getter;
import lombok.Setter;
import me.fabricionogueira.magrathea.twitter.modules.user.UserDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document
public class TwitterDocument<T extends UserDocument> {
    @Id
    private String id;
    private String message;
    private Date createdAt;
    @DBRef
    private UserDocument user;

    @PersistenceConstructor
    public TwitterDocument(String message, Date createdAt, T user) {
        this.message = message;
        this.createdAt = createdAt;
        this.user = user;
    }

}
