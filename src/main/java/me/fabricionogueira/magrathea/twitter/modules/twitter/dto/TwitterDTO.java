package me.fabricionogueira.magrathea.twitter.modules.twitter.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TwitterDTO {
    private Long id;
    private Date createdAt;
    private String text;
    private Long retweetCount;
    private String lang;
    private String[] hashtagEntities;
    private UserDTO user;
}
