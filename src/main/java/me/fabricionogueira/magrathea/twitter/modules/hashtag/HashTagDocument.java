package me.fabricionogueira.magrathea.twitter.modules.hashtag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import static java.lang.Boolean.TRUE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "hashtag")
public class HashTagDocument {
    @Id
    private String id;
    @TextIndexed
    @UniqueElements
    private String text;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;
    @Version
    private Long version;

    private boolean enable = TRUE;
}
