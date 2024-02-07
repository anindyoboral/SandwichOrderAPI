package be.abis.sandwich.repository;

import be.abis.sandwich.model.SandwichOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcSandwichOrderDetailsrepository implements  SandwichOrderDetailRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void addSandwichOrderDetail(SandwichOrderDetail sod) {

        jdbcTemplate.update("insert into  sandwichorderdetails(amount,breadtype,vegetables,person,sandwhichorder,comment)\n" +
                "values(?,?,?,?,?,?)" , sod.getAmount(),sod.getBreadType(),sod.isVegetables(),sod.getPerson(),sod.getSandwichOrder(),sod.getComment());

    }
}
