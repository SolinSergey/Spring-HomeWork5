package ru.gb.hw5.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw5.DAO.ProductDao;
import ru.gb.hw5.entitys.Product;
import ru.gb.hw5.entitys.ProductOld;
import ru.gb.hw5.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    private ProductDao productDao;

    private SessionFactory sessionFactory;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
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
        //ProductOld product = productService.getProductById(0);
        //ProductInDB product1=productDao.findById(0L);
        //model.addAttribute("result", product);
        Product product;
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        product=session.get(Product.class,1);
        session.getTransaction().commit();
        System.out.println(product);
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


