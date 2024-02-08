package be.abis.sandwich.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SandwichOrder {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    private double totalprice;

    private LocalDate orderDate;
    private Course course;


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
