package ru.gb.hw5.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.gb.hw5.entitys.Product;
import ru.gb.hw5.entitys.ProductOld;

@Component
public class HibernateConfig {
    @Bean
    public SessionFactory setSessionFactory(){
        SessionFactory factoryBean = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
//                .addAnnotatedClass(Reader.class)
                .buildSessionFactory();
        return factoryBean;
    }
}
