package ru.gb.hw5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.hw5.entitys.ProductOld;
import ru.gb.hw5.repository.ProductsRepository;

@Component
public class ProductService {
    ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public ProductOld getProductById(int id) {
        return productsRepository.getProductsById(id);
    }

    public void addProductToRepository(ProductOld product) {
        productsRepository.addProducts(product);
    }

    public int getSizeProductsList() {
        return productsRepository.getSizeProductList();
    }

}