package me.fabricionogueira.magrathea.twitter.modules.twitter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwitterDto {
    private Long id;
    private String text;
    private Long retweetCount;
    private String lang;
    private List<String> hashtagEntities;
    private UserDto user;
}
