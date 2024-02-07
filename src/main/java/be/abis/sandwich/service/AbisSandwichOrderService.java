package be.abis.sandwich.service;

import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;
import org.springframework.stereotype.Service;

@Service
public class AbisSandwichOrderService implements SandwichOrderService{
    @Override
    public void addSandwichOrderDetail(SandwichOrderDetail sod) {

    }

    @Override
    public void printSandwichOrder(SandwichOrder so) {

    }

    @Override
    public double calculateSandwichOrderPrice(SandwichOrder so) {
        return 0;
    }
}
