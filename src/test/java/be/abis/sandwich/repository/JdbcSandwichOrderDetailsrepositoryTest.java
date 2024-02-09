package be.abis.sandwich.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JdbcSandwichOrderDetailsrepositoryTest {

    @Autowired
    JdbcSandwichOrderDetailsrepository jdbcSodr;

    @Test
    void addSandwichOrderDetail() {
        //TODO
    }

    @Test
    void findSandwichorderDetailsBySandwichOrderId() {
        assertTrue(jdbcSodr.findSandwichorderDetailsBySandwichOrderId(0).size() > 0);
    }
}