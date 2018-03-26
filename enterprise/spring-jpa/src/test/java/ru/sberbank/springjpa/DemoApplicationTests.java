package ru.sberbank.springjpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.springjpa.entities.ChatGroup;
import ru.sberbank.springjpa.service.ChatService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {
    @Autowired
    ChatService chatService;
    @PersistenceContext
    EntityManager manager;

    public void before() {
        ChatGroup grp = new ChatGroup();
        grp.setChatName("Like a Rolling Stones");
        ChatGroup grp2 = new ChatGroup();
        grp2.setChatName("Как пропатчить KDE2 под FreeBSD");
//        manager.getTransaction().begin();
        manager.persist(grp);
        manager.persist(grp2);
//        manager.getTransaction().commit();
    }

    @Test
    @Transactional
    public void contextLoads() {
        before();
        ChatGroup chtGrp = chatService.findChatGroup("Sto");
        log.info("ChatGroup {}", chtGrp);
        chtGrp = chatService.findChatGroup("KDE");
        log.info("ChatGroup {}", chtGrp);
    }

}
