package ru.sberbank.hibernate.task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class p03_JPA_HQL {
    private EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) throws Exception {
        new p03_JPA_HQL().start();
    }

    private void start() throws Exception {
        setUp();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query q = entityManager.createQuery("from City c where c.cityName like :cname");
        q.setParameter("cname", "%o%");
        q.setMaxResults(3);
        System.out.println(q.getResultList());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    protected void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.sberbank.hibernate.example");
    }
}
