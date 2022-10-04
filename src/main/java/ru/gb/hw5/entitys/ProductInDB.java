package ru.gb.hw5.entitys;

import javax.persistence.*;

@Entity
@Table(name="product")
public class ProductInDB {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private int price;

    public ProductInDB() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
