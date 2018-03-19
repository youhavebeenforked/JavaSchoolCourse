package ru.sberbank.springjpa.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "CHAT_MESSAGE")
@Getter
@Setter
@ToString
public class Message implements Serializable{
    @Id
    private String uuid;

    @Column(name = "MESSAGE_TEXT")
    private String message;

    @Column(name = "MESSAGE_DATE_TIME")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private ChatGroup chatGroup;

}
