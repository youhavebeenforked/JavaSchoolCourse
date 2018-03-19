package ru.sberbank.hibernate.solved;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ru.sberbank.hibernate.entities.BaseQuote;
import ru.sberbank.hibernate.entities.City;
import ru.sberbank.hibernate.entities.Region;

public class s00_ComplexKey {

    public static void main(String[] args) {
        write();
        read();
    }

    private static void write() {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();

            BaseQuote quote = new BaseQuote();
            quote.setKey(new BaseQuote.QuoteKey(LocalDateTime.now()));
            quote.setSymbol("USD/RUB");
            quote.setPrice(new BaseQuote.QuotePrice(100_00L,120_00L));
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
        return cfg.configure("hibernate.solved.cfg.xml").buildSessionFactory();
    }
}
