/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdv.hdv.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class LineItem {
    @Id
    @GeneratedValue
    @Column(name = "id")
    int id;
    @OneToOne
    @JoinColumn(name="product")
    private Product product;
    
    @Column(name="count")
    int count;
}
