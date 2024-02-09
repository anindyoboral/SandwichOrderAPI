package be.abis.sandwich.controller;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;
import be.abis.sandwich.service.SandwichOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sandwich-orders")
public class SandwichOrderController {

    @Autowired
    SandwichOrderService sos;

    @PostMapping("/sandwich-order")
    public void postOrder(@RequestBody SandwichOrderDetail sod) {
        sos.addSandwichOrderDetail(sod);
    }

    @GetMapping("/sandwich")
    public Sandwich getSandwichByName(@RequestParam (name="sandwich-name") String sandwichName) {
        return sos.findSandwichByName(sandwichName);
    }

    @GetMapping("/sandwich-order/{id}")
    public float calculateSandwichOrderPriceById(@PathVariable int id) {
        SandwichOrder so = new SandwichOrder();
        so.setId(id);
        return sos.calculateSandwichOrderPrice(so);
    }



}
