package com.carRental.java.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Review {
    private int id;
    private String description;
    private String stars;
    private Collection<OrderDetails> orderDetailsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "stars", nullable = true)
    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != review.id) return false;
        if (description != null ? !description.equals(review.description) : review.description != null) return false;
        if (stars != null ? !stars.equals(review.stars) : review.stars != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (stars != null ? stars.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "reviewByReviewId")
    public Collection<OrderDetails> getOrderDetailsById() {
        return orderDetailsById;
    }

    public void setOrderDetailsById(Collection<OrderDetails> orderDetailsById) {
        this.orderDetailsById = orderDetailsById;
    }
}
