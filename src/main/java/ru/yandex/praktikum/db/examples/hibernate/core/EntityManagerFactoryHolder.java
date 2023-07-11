package ru.yandex.praktikum.db.examples.hibernate.core;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryHolder {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("postgres-db-test");

    public EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }

}