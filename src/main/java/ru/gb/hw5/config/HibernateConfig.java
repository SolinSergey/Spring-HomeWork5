package ru.gb.hw5.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.gb.hw5.entities.Product;

@Component
public class HibernateConfig {

    private SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    public Session getSessionFactory(){
      return factory.getCurrentSession();
    }
}
