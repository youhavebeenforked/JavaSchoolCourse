package ru.sberbank.springjpa.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.SortedSet;

@Entity
@Table(name = "CHAT_GROUP")
@Getter
@Setter
@ToString
public class ChatGroup {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHAT_NAME")
    private String chatName;

    @OneToMany(mappedBy = "chatGroup")
    @OrderBy("timestamp")
    private SortedSet<Message> messages;
}
