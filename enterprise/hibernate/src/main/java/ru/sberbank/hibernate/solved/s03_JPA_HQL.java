package ru.sberbank.hibernate.solved;

import ru.sberbank.hibernate.entities.City;
import ru.sberbank.hibernate.entities.Region;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class s03_JPA_HQL {
    private EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) throws Exception {
        new s03_JPA_HQL().start();
        System.out.println("the end?");
    }

    private void start() throws Exception {
        setUp();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        preInit(entityManager);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

        Query q = entityManager.createQuery("from City c where c.cityName like :cityName");
        q.setParameter("cityName", "%Tir%");
        List<City> lst = q.getResultList();
        System.out.println(lst);

        lst.get(0).setCityName(lst.get(0).getCityName() + " !!");

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private void preInit(EntityManager entityManager) {
        Region region = new Region();
        region.setRegionName("Middle-earth");
        List<City> cities = new ArrayList<>();
        cities.add(new City("Rivendell", region));
        cities.add(new City("Minas Tirith", region));
        cities.add(new City("Esgaroth", region));
        cities.add(new City("Hobbiton", region));
        region.setCities(cities);
        entityManager.persist(region);
    }

    protected void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.sberbank.hibernate.example");
    }
}
