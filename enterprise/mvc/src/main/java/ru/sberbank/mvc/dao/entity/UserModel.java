package ru.sberbank.mvc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "uuid")

@Entity
@Table(name = "USER_DATA")
public class UserModel implements Serializable {
    @Id
    private String uuid;
    @Column(name = "USERNAME")
    private String name;
    @Column(name = "PICTURE")
    private String pictureId;
    @Column(name = "PROFILE_TEXT")
    @Lob
    private String profileText;


}
