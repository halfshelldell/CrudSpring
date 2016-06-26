package com.ironyard.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by illladell on 6/23/16.
 */

@Entity
@Table(name = "sneakers")
public class Sneaker {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String brand;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    int year;

    @Column(nullable = false)
    float price;

    @Column(nullable = false)
    int size;

    @ManyToOne
    User user;

    @Transient
    boolean isUser;

    public Sneaker() {
    }

    public Sneaker(String brand, String name, int year, float price, int size, User user) {
        this.brand = brand;
        this.name = name;
        this.year = year;
        this.price = price;
        this.size = size;
        this.user = user;
    }

    public Sneaker(int id, String brand, String name, int year, float price, int size, User user) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.year = year;
        this.price = price;
        this.size = size;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }
}
