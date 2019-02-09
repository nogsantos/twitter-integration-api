package me.fabricionogueira.magrathea.twitter.modules.twitter.dto;

import lombok.Data;

@Data
public class TwitterDTO {
    private Long id;
    private String text;
    private Long retweetCount;
    private String lang;
    private String[] hashtagEntities;
    private UserDTO user;
}
