package be.abis.sandwich.service;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AbisSandwichOrderServiceTest {

    @Autowired
    AbisSandwichOrderService abisSandwichOrderService;

    @Test
    void findAllSandwichesTest(){
        List<Sandwich> allSandwiches = abisSandwichOrderService.findAllSandwiches();
        System.out.println(allSandwiches.toString());
    }

    @Test
    void calculateSandwichOrderPrice() {
        SandwichOrder so = new SandwichOrder();
        so.setId(0);
        abisSandwichOrderService.calculateSandwichOrderPrice(so);
    }

    @Test
    void printSandwichOrderTest(){
        SandwichOrder so = new SandwichOrder();
        so.setId(0);

        abisSandwichOrderService.printSandwichOrder(so);

    }

    @Test
    void findSandwichByName() {
        assertEquals("poisson", abisSandwichOrderService.findSandwichByName("poisson").getName());
    }





}
