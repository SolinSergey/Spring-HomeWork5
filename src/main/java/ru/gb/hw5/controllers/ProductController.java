package ru.gb.hw5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw5.DAO.ProductDao;
import ru.gb.hw5.entitys.Product;
import ru.gb.hw5.entitys.ProductInDB;
import ru.gb.hw5.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    private ProductDao productDao;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setProductDao(ProductDao productDao){
        this.productDao=productDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        Product[] products = new Product[productService.getSizeProductsList()];
        for (int i = 0; i < productService.getSizeProductsList(); i++) {
            products[i] = productService.getProductById(i);
        }
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping(path = "/byid")
    public String productById(Model model, @RequestParam int id) {
        Product product = productService.getProductById(0);
        ProductInDB product1=productDao.findById(0L);
        model.addAttribute("result", product);
        return "byid";
    }

    @GetMapping("/showForm")
    public String showSimpleForm(Model model) {
        Product product = new Product();
        product.setId(-1);
        product.setTitle("");
        product.setCost(0);
        model.addAttribute("product", product);
        return "productform";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute Product product, Model model) {
        productService.addProductToRepository(product);
        model.addAttribute("product", product);
        return "formresult";
    }

}


