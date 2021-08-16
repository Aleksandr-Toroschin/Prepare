package ru.toroschin.hw5;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class Config {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }
        return entityManagerFactory;
    }
}
