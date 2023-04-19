package com.hdv.hdv.Entity;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue
    int id;
    @Column
    String name;
    @Column
    String img;
    @Column
    String description;
    @Column
    String size;
    @Column
    float price;
    @Column
    String category;
    @Column
    String brand;
    @Column
    int quantity;

    public Product() {
    }

    public Product(String name, String img, String description, String size, float price, String category, String brand, int quantity) {
        this.name = name;
        this.img = img;
        this.description = description;
        this.size = size;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.quantity = quantity;
    }

    public ArrayList<String> getImg(){
        ArrayList<String> image = new ArrayList<>();
        String im[] = this.img.split(";");
        for(String i: im)
            image.add(i);
        return image;
    }

    public void setImg(ArrayList<String> img1)
    {
        String s = img1.get(0);
        for(int i=1; i<img1.size(); i++) s+=";" + img1.get(i);
        this.img = s;
    }

    public ArrayList<Integer> getSize(){
        ArrayList<Integer> sizeList = new ArrayList<>();
        String si[] = this.size.split(";");
        for(String i: si)
            sizeList.add(Integer.parseInt(i));
        return sizeList;
    }

    public void setSize(ArrayList<Integer> list){
        String s = String.valueOf(list.get(0));
        for(int i=1; i<list.size(); i++) s+=";" + list.get(i);
        this.size = s;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
