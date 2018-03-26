package ru.sberbank.hibernate.task;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sberbank.hibernate.task.entities.BaseQuote;

import java.time.LocalDateTime;

public class p00_ComplexKey {
    static BaseQuote.QuoteKey key = null;
    public static void main(String[] args) {
        write();
        read();
    }

    private static void write() {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            key = new BaseQuote.QuoteKey(LocalDateTime.now());
            BaseQuote quote = new BaseQuote();
            quote.setKey(key);
            quote.setSymbol("USD/EUR");
            quote.setPrice(new BaseQuote.QuotePrice(100_00L,120_00L));
            session.save(quote);

            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void read() {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();


            System.out.println(session.find(BaseQuote.class, key));
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
