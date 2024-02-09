package be.abis.sandwich.service;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;

import java.util.List;

public interface SandwichOrderService {


    List<Sandwich> findAllSandwiches();
    void addSandwichOrderDetail(SandwichOrderDetail sod);
    void printSandwichOrder(SandwichOrder so);
    float calculateSandwichOrderPrice(SandwichOrder so);
    Sandwich findSandwichByName(String name);
}
