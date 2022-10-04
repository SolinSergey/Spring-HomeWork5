package ru.gb.hw5.repository;

import org.springframework.stereotype.Component;
import ru.gb.hw5.entitys.ProductOld;

import java.util.ArrayList;

@Component
public class ProductsRepository {
    private ArrayList<ProductOld> products;

    public ProductsRepository() {
        products = new ArrayList<>();
        products.add(new ProductOld(0, "Хлеб", 35));
        products.add(new ProductOld(1, "Колбаса", 400));
        products.add(new ProductOld(2, "Водка", 350));
    }

    public ProductOld getProductsById(int id) {
        return products.get(id);
    }

    public void addProducts(ProductOld product) {
        product.setId(getSizeProductList());
        products.add(product);
    }

    public int getSizeProductList() {
        return products.size();
    }
}