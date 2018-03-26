package ru.sberbank.springjpa.dao;

import org.springframework.data.repository.Repository;
import ru.sberbank.springjpa.entities.ChatGroup;

public interface ChatGroupRepository extends Repository<ChatGroup, Long> {

    ChatGroup findByChatNameContainsOrderByChatNameAsc(String chatNameLike);

}
