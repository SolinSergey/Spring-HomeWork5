package ru.gb.hw5.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.hw5.entities.Product;

@Component
public class ProductDao {

    TransanctionManager transanctionManager;
    @Autowired
    public void setTransanctionManager(TransanctionManager transanctionManager){
        this.transanctionManager=transanctionManager;
    }
    public Product findById(Long id){
        System.out.println("Вызван ProductInDB findById(Long id){");
        System.out.println("id="+id);
        return null;
    }

}
