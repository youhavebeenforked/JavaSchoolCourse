package ru.sberbank.hibernate.task;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class p02_ManyToMany_LazyAndEager {

    public static void main(String[] args) {
        p02_ManyToMany_LazyAndEager hs = new p02_ManyToMany_LazyAndEager();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        // Создать 2 книги, добавить к первой 3х авторов, а ко второй - одного старого и одного нового автора
        s.getTransaction().commit();
        s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        // получить все книги по id старого автора.
        // Попробовать варианты Lazy/Eager

        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

}
