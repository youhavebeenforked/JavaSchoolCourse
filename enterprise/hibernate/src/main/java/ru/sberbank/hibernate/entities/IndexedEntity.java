package ru.sberbank.hibernate.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "INDEXED_ENTITY", indexes = {@Index(name = "INDX_ENTITY_DATE", columnList = "EVENT_TIME"),
        @Index(name = "INDX_ENTITY_ADMIN", columnList = "ADMIN_NAME, ADMIN_LOGIN")})
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
