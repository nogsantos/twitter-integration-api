package me.fabricionogueira.magrathea.twitter.modules.twitter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String location;
    private String biggerProfileImageURLHttps;
}
