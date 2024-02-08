package be.abis.sandwich.repository;

import be.abis.sandwich.model.SandwichOrder;

public interface SandwichOrderRepository {
    void printSandwichOrder(SandwichOrder sod);

    void setTotalForOrder(SandwichOrder sod, float total);
}
