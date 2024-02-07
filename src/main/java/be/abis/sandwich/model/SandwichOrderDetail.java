package be.abis.sandwich.model;

import be.abis.sandwich.enumeration.BreadType;

public class SandwichOrderDetail {

    private Sandwich sandwich;
    private int amount=1;
    private BreadType breadType;
    private boolean vegetables;
    private String comment;
    private Person person;
    private SandwichOrder sandwichOrder;

    public SandwichOrderDetail(){}

    public SandwichOrderDetail(Sandwich sandwich, int amount, BreadType breadType, boolean vegetables, String comment, Person person) {
        this.sandwich = sandwich;
        this.amount = amount;
        this.breadType = breadType;
        this.vegetables = vegetables;
        this.comment = comment;
        this.person = person;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
