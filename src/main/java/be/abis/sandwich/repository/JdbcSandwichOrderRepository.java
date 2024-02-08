package be.abis.sandwich.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcSandwichOrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
}

