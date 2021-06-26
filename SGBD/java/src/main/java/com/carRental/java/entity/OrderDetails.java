package com.carRental.java.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "order_details", schema = "car_rentals", catalog = "")
public class OrderDetails {
    private int orderId;
    private Date startDate;
    private Date endDate;
    private String pickLocation;
    private String dropLocation;
    private Car carByCarId;
    private User userByUserId;
    private Review reviewByReviewId;

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "start_date", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "pick_location", nullable = false, length = 25)
    public String getPickLocation() {
        return pickLocation;
    }

    public void setPickLocation(String pickLocation) {
        this.pickLocation = pickLocation;
    }

    @Basic
    @Column(name = "drop_location", nullable = false, length = 25)
    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetails that = (OrderDetails) o;

        if (orderId != that.orderId) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (pickLocation != null ? !pickLocation.equals(that.pickLocation) : that.pickLocation != null) return false;
        if (dropLocation != null ? !dropLocation.equals(that.dropLocation) : that.dropLocation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (pickLocation != null ? pickLocation.hashCode() : 0);
        result = 31 * result + (dropLocation != null ? dropLocation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    public Car getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(Car carByCarId) {
        this.carByCarId = carByCarId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "review_id", referencedColumnName = "id", nullable = false)
    public Review getReviewByReviewId() {
        return reviewByReviewId;
    }

    public void setReviewByReviewId(Review reviewByReviewId) {
        this.reviewByReviewId = reviewByReviewId;
    }
}
