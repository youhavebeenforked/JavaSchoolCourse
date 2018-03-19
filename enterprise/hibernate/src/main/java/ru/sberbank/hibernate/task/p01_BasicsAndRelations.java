package ru.sberbank.hibernate.task;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class p01_BasicsAndRelations {


    public static void main(String[] args) {
        // Задача 01: инициировать сессию, сохранить объекты, загрузить объекты.

        // Задача 02: переоткрыть сессию, загрузить объекты.

        // Сохранение изменений не новой сущности.
    }

    private SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration();
        return cfg.configure().buildSessionFactory();
    }
}
