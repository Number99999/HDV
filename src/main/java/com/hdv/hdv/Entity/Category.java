package com.hdv.hdv.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table

public class Category {
    @Id
    @GeneratedValue
    private int id;

    private String name_product;
    @Column(name = "image")
    private String img;
    private String name;


    public Category() {

    }

    public Category(String img, String name) {
        this.name = name;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }
}
