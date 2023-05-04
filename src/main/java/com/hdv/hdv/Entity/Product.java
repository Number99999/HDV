package com.hdv.hdv.Entity;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
//    @GeneratedValue
    int id;
    String product_id;
    String product_category;
    String product_name;
    String availability = "Còn hàng";
    String price;
    String image;

    public Product() {
    }

    public Product(String product_id, String product_category, String product_name, String price, String image) {
        this.product_id = product_id;
        this.product_category = product_category;
        this.product_name = product_name;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString(){
        return "" + product_category + product_name + product_id + price + image;
    }
}
