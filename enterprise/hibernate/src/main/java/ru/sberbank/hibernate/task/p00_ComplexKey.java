package ru.sberbank.hibernate.task;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

import ru.sberbank.hibernate.entities.BaseQuote;

public class p00_ComplexKey {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void write() {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void read() {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration();
        return cfg.configure().buildSessionFactory();
    }
}
