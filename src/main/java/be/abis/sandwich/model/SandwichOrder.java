package be.abis.sandwich.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SandwichOrder {

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
