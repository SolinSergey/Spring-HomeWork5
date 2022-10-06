package ru.gb.hw5.DAO;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.hw5.config.HibernateConfig;
import ru.gb.hw5.entities.Product;

@Component
public class ProductDao {

    private Session session;
    @Autowired
    public void setTransanctionManager(HibernateConfig hibernateConfig){
        this.session= hibernateConfig.getSessionFactory();
        System.out.println(session);
    }
    public Product findById(int id){
        Product product=null;
        session.beginTransaction();
        product=session.get(Product.class,id);
        session.getTransaction().commit();
        System.out.println(product);
        System.out.println("Вызван ProductInDB findById(Long id){");
        System.out.println("id="+id);
        return null;
    }

}
