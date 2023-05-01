package com.hdv.hdv.Entity;

import javax.persistence.*;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue
    private int id;

    private int id_user;

    private String name_product;

    private int count;

    public Cart(){

    }

    public Cart(int id_user, String product){
        this.id_user = id_user;
        this.name_product = product;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }


    public String getProduct() {
        return name_product;
    }

    public void setProduct(String product) {
        this.name_product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
