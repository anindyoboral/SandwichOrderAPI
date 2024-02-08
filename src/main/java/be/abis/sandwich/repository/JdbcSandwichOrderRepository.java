package be.abis.sandwich.repository;

import be.abis.sandwich.model.Course;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSandwichOrderRepository implements SandwichOrderRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CourseRepository courseRepository;


    @Override
    public void printSandwichOrder(SandwichOrder sod) {
        jdbcTemplate.queryForObject("select * from  sandwichorders where id=?",new SandwichOrderMapper(),sod.getId());
    }


    private final class SandwichOrderMapper implements RowMapper<SandwichOrder> {
        public SandwichOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
            SandwichOrder sandwichOrder = new SandwichOrder();
            sandwichOrder.setId(rs.getInt("ID"));
            sandwichOrder.setOrderDate(rs.getDate("LOCALDATE").toLocalDate());
            sandwichOrder.setCourse( courseRepository.findCourse(rs.getInt("COURSE")));
            return sandwichOrder;
        }
    }
}

