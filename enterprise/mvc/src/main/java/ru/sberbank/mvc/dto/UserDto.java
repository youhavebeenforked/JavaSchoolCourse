package ru.sberbank.mvc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@JsonRootName("usr")
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UserDto implements Serializable {
    private String uuid;
    private String name;
    @JsonProperty("pid")
    private String pictureId;

    private String profileText;
}
