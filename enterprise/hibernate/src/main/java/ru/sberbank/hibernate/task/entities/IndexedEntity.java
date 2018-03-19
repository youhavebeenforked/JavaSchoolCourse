package ru.sberbank.hibernate.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
//todo: добавить индексы на  EVENT_TIME Сдвоенный индекс на ADMIN_NAME и ADMIN_LOGIN
@Setter
@Getter
public class IndexedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "EVENT_TIME")
    private LocalDateTime timestamp;

    @Column(name = "ADMIN_NAME")
    private String adminName;

    @Column(name = "ADMIN_LOGIN")
    private String adminLogin;

}
