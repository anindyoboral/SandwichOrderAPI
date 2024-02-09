package be.abis.sandwich.controller;

import be.abis.sandwich.model.SandwichOrderDetail;
import be.abis.sandwich.repository.SandwichOrderDetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class SandwichOrderControllerTest {

    @Autowired
    SandwichOrderController soc;

    @Autowired
    SandwichOrderDetailRepository sodr;

    @Test
    void postOrder() {
        SandwichOrderDetail sod = new SandwichOrderDetail();
        List<SandwichOrderDetail> sodl = sodr.findSandwichorderDetailsBySandwichOrderId(0);
        if (sodl.size() > 0) {
            soc.postOrder(sodl.get(0));
        }
    }

    @Test
    void getSandwichByName() {
        assertEquals("poisson",soc.getSandwichByName("poisson").getName());
    }

}