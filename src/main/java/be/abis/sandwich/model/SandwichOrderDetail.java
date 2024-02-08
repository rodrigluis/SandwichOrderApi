package be.abis.sandwich.model;

import be.abis.sandwich.enumeration.BreadType;
import jakarta.persistence.*;

@Entity
@Table(name = "SANDWICH_ORDER_DETAILS")
public class SandwichOrderDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "SANDWICHID")
    private int sandwichId;
    @Column(name = "AMOUNT")
    private int amount=1;
    @Enumerated(EnumType.STRING)
    @Column(name = "BREADTYPE")
    private BreadType breadType;
    @Column(name = "VEGETABLES")
    private boolean vegetables;
    @Column(name = "COMMENTS")
    private String comments;
    @ManyToOne
    @JoinColumn(name="PERSONID")
    private Person person;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORDERID")
    private SandwichOrder sandwichOrder;

    @Override
    public String toString() {
        return "SandwichOrderDetail{" +
                "id=" + id +
                ", sandwichId=" + sandwichId +
                ", amount=" + amount +
                ", breadType=" + breadType +
                ", vegetables=" + vegetables +
                ", comments='" + comments + '\'' +
                ", person=" + person +
                ", sandwichOrder=" + sandwichOrder +
                '}';
    }

    public SandwichOrderDetail(){}

    public SandwichOrderDetail(Sandwich sandwich, int amount, BreadType breadType, boolean vegetables, String comments, Person person) {
        this.sandwichId = sandwich.getId();
        this.amount = amount;
        this.breadType = breadType;
        this.vegetables = vegetables;
        this.comments = comments;
        this.person = person;
    }

    public int getSandwichId() {
        return sandwichId;
    }

    public void setSandwichId(int sandwichId) {
        this.sandwichId = sandwichId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public boolean isVegetables() {
        return vegetables;
    }

    public void setVegetables(boolean vegetables) {
        this.vegetables = vegetables;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public SandwichOrder getSandwichOrder() {
        return sandwichOrder;
    }

    public void setSandwichOrder(SandwichOrder sandwichOrder) {
        this.sandwichOrder = sandwichOrder;
    }
}
