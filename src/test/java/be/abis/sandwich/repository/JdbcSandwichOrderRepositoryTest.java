package be.abis.sandwich.repository;

import be.abis.sandwich.model.SandwichOrder;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
@SpringBootTest
class JdbcSandwichOrderRepositoryTest {

    @Autowired
    JdbcSandwichOrderRepository jdbcSor;
    SandwichOrder so = new SandwichOrder();

    @PostConstruct
    void init() {
        so.setId(0);
    }


    @Test
    @Order(1)
    void setTotalForOrderToTestValue666() {
        jdbcSor.setTotalForOrder(so,Float.parseFloat("666.666"));
    }

    @Test
    @Order(2)
    void printSandwichOrder() {
        jdbcSor.printSandwichOrder(so);
        //TODO validate total is 666.666
        //TODO delete generated file (ongoing dev by anindyo)
    }

    @Test
    @Order(3)
    void setTotalForOrderToZero() {
        jdbcSor.setTotalForOrder(so,Float.parseFloat("0"));
    }
}