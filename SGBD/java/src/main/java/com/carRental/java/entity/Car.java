package com.carRental.java.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Car {
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String brand;
    private String model;
    private Integer yearOfFabrication;
    private String category;
    private Integer pricePerDay;
    private Collection<com.carRental.java.entity.OrderDetails> orderDetailsById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brand", nullable = false, length = 25)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model", nullable = false, length = 25)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "year_of_fabrication", nullable = false)
    public Integer getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setYearOfFabrication(Integer yearOfFabrication) {
        this.yearOfFabrication = yearOfFabrication;
    }

    @Basic
    @Column(name = "category", nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "price_per_day")
    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Integer pricePerDay) {
        this.pricePerDay = pricePerDay;
    }


    @OneToMany(mappedBy = "carByCarId")
    public Collection<OrderDetails> getOrderDetailsById() {
        return orderDetailsById;
    }

    public void setOrderDetailsById(Collection<OrderDetails> orderDetailsById) {
        this.orderDetailsById = orderDetailsById;
    }
}
