package ru.sberbank.hibernate.task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class p03_JPA_HQL {
    private EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) throws Exception {
        new p03_JPA_HQL().start();
    }

    private void start() throws Exception {
        setUp();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        //1. Выбрать записи с использованием HQl
        //2. Выбрать с использованием JOIN FETCH



        entityManager.getTransaction().commit();
        entityManager.close();
    }

    protected void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.sberbank.hibernate.example");
    }
}
