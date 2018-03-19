package ru.sberbank.springjpa;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;

}
