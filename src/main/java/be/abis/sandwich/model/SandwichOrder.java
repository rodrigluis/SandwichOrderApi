package be.abis.sandwich.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class SandwichOrder {
    private int id;
    private LocalDate orderDate;

    private Course course;

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    private BigDecimal totalCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Collection<SandwichOrderDetail> sandwichOrderDetails = new ArrayList<>();

    public SandwichOrder(){

    }

    public SandwichOrder(LocalDate orderDate, Course course) {
        this.orderDate = orderDate;
        this.course = course;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Collection<SandwichOrderDetail> getSandwichOrderDetails() {
        return sandwichOrderDetails;
    }

    public void setSandwichOrderDetails(Collection<SandwichOrderDetail> sandwichOrderDetails) {
        this.sandwichOrderDetails = sandwichOrderDetails;
    }

    @Override
    public String toString() {
        return "SandwichOrder{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", course=" + course +
                ", totalCost=" + totalCost +
                ", sandwichOrderDetails=" + sandwichOrderDetails +
                '}';
    }


}
