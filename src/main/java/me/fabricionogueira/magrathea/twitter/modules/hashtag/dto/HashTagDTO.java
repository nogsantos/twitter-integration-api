package me.fabricionogueira.magrathea.twitter.modules.hashtag.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HashTagDTO {
    private String id;
    private String text;
    private Date createdDate;
    private Date updatedDate;
    private Long version;
    private boolean enable;
}
