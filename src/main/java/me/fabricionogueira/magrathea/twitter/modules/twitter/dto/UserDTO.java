package me.fabricionogueira.magrathea.twitter.modules.twitter.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String screenName;
    private String email;
    private String location;
    private String biggerProfileImageURLHttps;
}
