package ru.sberbank.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.springjpa.dao.ChatGroupRepository;
import ru.sberbank.springjpa.entities.ChatGroup;

@Service
public class ChatService {
    private final ChatGroupRepository chatGroupRepository;

    @Autowired
    public ChatService(ChatGroupRepository chatGroupRepository) {
        this.chatGroupRepository = chatGroupRepository;
    }

    public ChatGroup findChatGroup(String chatNameLike) {
        return chatGroupRepository.findByChatNameContainsOrderByChatNameAsc(chatNameLike);
    }
}
