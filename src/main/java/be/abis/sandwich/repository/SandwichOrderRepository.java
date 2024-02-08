package be.abis.sandwich.repository;

import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;

public interface SandwichOrderRepository {
    void printSandwichOrder(SandwichOrder sod);
}
