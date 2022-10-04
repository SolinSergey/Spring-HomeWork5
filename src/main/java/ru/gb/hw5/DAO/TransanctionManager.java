package ru.gb.hw5.DAO;

import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class TransanctionManager {
    private EntityManagerFactory factory;
    private EntityManager em;

    public TransanctionManager() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        this.em = factory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
