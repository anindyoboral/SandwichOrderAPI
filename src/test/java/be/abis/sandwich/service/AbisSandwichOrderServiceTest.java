package be.abis.sandwich.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AbisSandwichOrderServiceTest {

    @Autowired
    SandwichOrderService sos;

    @Test
     void findAllSandwiches() {
        assertTrue(sos.findAllSandwiches().size() > 0);
    }

    //void addSandwichOrderDetail(SandwichOrderDetail sod);
    //void printSandwichOrder(SandwichOrder so);
    //float calculateSandwichOrderPrice(SandwichOrder so);
    //Sandwich findSandwichByName(String name);


}
