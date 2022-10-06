package ru.gb.hw5.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw5.DAO.ProductDao;
import ru.gb.hw5.config.HibernateConfig;
import ru.gb.hw5.entities.Product;
import ru.gb.hw5.entities.ProductOld;
import ru.gb.hw5.service.ProductService;

@Controller
@RequestMapping("/prod")
public class ProductController {
    private ProductService productService;
    private ProductDao productDao;

    private Session session=null;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setSession(HibernateConfig hibernateConfig){
        this.session=hibernateConfig.getSessionFactory();
        System.out.println(session);
    }
    @Autowired
    public void setProductDao(ProductDao productDao){
        this.productDao=productDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        ProductOld[] products = new ProductOld[productService.getSizeProductsList()];
        for (int i = 0; i < productService.getSizeProductsList(); i++) {
            products[i] = productService.getProductById(i);
        }
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping(path = "/byid")
    public String productById(Model model, @RequestParam int id) {
        productDao.findById(id);
        return "byid";
    }

    @GetMapping("/showForm")
    public String showSimpleForm(Model model) {
        ProductOld product = new ProductOld();
        product.setId(-1);
        product.setTitle("");
        product.setCost(0);
        model.addAttribute("product", product);
        return "productform";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute ProductOld product, Model model) {
        productService.addProductToRepository(product);
        model.addAttribute("product", product);
        return "formresult";
    }

}


