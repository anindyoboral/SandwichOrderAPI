package be.abis.sandwich.service;

import be.abis.sandwich.model.Sandwich;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AbisSandwichOrderServiceTest {

    @Autowired
    AbisSandwichOrderService abisSandwichOrderService;

    @Test
    void findAllSandwichesTest(){
        List<Sandwich> allSandwiches = abisSandwichOrderService.findAllSandwiches();
        System.out.println(allSandwiches.toString());
    }





}
