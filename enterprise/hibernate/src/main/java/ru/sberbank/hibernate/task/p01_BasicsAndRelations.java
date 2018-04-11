package ru.sberbank.hibernate.task;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sberbank.hibernate.task.entities.Region;

public class p01_BasicsAndRelations {


    public static void main(String[] args) {
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            Region reg = session.find(Region.class, 3L);
            System.out.println(reg);
            reg.setRegionName("Reg not 1");

            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            Region reg = session.find(Region.class, 3L);
            System.out.println(reg);
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
