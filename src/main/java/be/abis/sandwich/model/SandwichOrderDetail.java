package be.abis.sandwich.model;

import be.abis.sandwich.enumeration.BreadType;


public class SandwichOrderDetail {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    private Sandwich sandwich;
    private int amount=1;
    private BreadType breadType;
    private boolean vegetables;
    private String comments;
    private Person person;


    public SandwichOrderDetail(){}

    public SandwichOrderDetail(Sandwich sandwich, int amount, BreadType breadType, boolean vegetables, String comments, Person person) {
        this.sandwich = sandwich;
        this.amount = amount;
        this.breadType = breadType;
        this.vegetables = vegetables;
        this.comments = comments;
        this.person = person;
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

    @Override
    public String toString() {
        return "SandwichOrderDetail{" +
                "id=" + id +
                ", sandwich=" + sandwich +
                ", amount=" + amount +
                ", breadType=" + breadType +
                ", vegetables=" + vegetables +
                ", comments='" + comments + '\'' +
                ", person=" + person +
                '}';
    }

}
