package be.abis.sandwich.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
@Table(name = "SANDWICH_ORDERS")
public class SandwichOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "ORDERDATE")
    private LocalDate orderDate;

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

    @ManyToOne
    @JoinColumn(name = "COURSEID")
    private Course course;

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Column(name = "TOTALCOST")
    private BigDecimal totalCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<SandwichOrderDetail> getSandwichOrderDetails() {
        return sandwichOrderDetails;
    }

    public void setSandwichOrderDetails(Collection<SandwichOrderDetail> sandwichOrderDetails) {
        this.sandwichOrderDetails = sandwichOrderDetails;
    }

    @OneToMany(mappedBy = "sandwichOrder", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
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

}
