package ru.sberbank.hibernate.solved;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sberbank.hibernate.entities.City;
import ru.sberbank.hibernate.entities.Region;

import java.util.ArrayList;
import java.util.List;

public class s01_BasicsAndRelations {
    static s01_BasicsAndRelations hs = new s01_BasicsAndRelations();


    public static void main(String[] args) {
        Session session = hs.getSessionFactory().openSession();
        session.beginTransaction();

        Region region = session.find(Region.class, 1L);
        System.out.println(region);
        region = new Region();
        region.setRegionName("Свердловская область");
        region.setCities(hs.getCities(region));
        System.out.println(region);
        session.save(region);
      //  region.getCities().forEach(session::save);
        session.getTransaction().commit();
        System.out.println(region);

        session.close();

        session = hs.getSessionFactory().openSession();
        session.beginTransaction();
        region = session.find(Region.class, 1L);
        System.out.println(region);
        session.getTransaction().commit();
        System.out.println(region);
        session.close();
    }

    private List<City> getCities(Region region) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Екатеринбург", region));
        cities.add(new City("Нижний Тагил", region));
        cities.add(new City("Качканар", region));
        return cities;
    }

    private SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration();
        return cfg.configure().buildSessionFactory();
    }
}
