package be.abis.sandwich.service;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AbisSandwichOrderServiceTest {

    @Autowired
    AbisSandwichOrderService abisSandwichOrderService;
    @Value("${filepath.jsonOrder}")
    private String filePathJsonOrder;

    SandwichOrder so = new SandwichOrder();
    @PostConstruct
    void init() {
        so.setId(0);
    }



    @Test
    void findAllSandwichesTest(){
        List<Sandwich> allSandwiches = abisSandwichOrderService.findAllSandwiches();
        System.out.println(allSandwiches.toString());
    }

    @Test
    void calculateSandwichOrderPrice() {
        abisSandwichOrderService.calculateSandwichOrderPrice(so);
    }

    @Test
    void findSandwichByName() {
        assertEquals("poisson", abisSandwichOrderService.findSandwichByName("poisson").getName());
    }

    @Test
    void printSandwichOrder() {
        abisSandwichOrderService.printSandwichOrder(so);
        File fileJsonOrder = new File(filePathJsonOrder);
        assertTrue(fileJsonOrder.canRead());
        //TODO assertTrue isJson content
        fileJsonOrder.delete();
    }





}
