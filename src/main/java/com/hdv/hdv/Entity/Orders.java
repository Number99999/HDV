package com.hdv.hdv.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Orders {
    @Id
    @GeneratedValue
    private int id;
    private int id_user;
    private int pay;
    private Date date;

    private String status;

    public Orders()
    {}

    public Orders(int id_user, int pay, Date date, String status){
        this.id_user = id_user;
        this.pay = pay;
        this.date = date;
        this.status = status;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
