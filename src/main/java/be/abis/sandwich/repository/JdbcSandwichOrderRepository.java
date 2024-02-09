package be.abis.sandwich.repository;

import be.abis.sandwich.model.SandwichOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JdbcSandwichOrderRepository implements SandwichOrderRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CourseRepository courseRepository;


    @Override
    public void printSandwichOrder(SandwichOrder sod) {
        jdbcTemplate.queryForObject("select * from  sandwichorders where id=?",new SandwichOrderMapper(),sod.getId());
    }

    @Override
    public void setTotalForOrder(SandwichOrder sod, float total) {
        jdbcTemplate.update("UPDATE TU0003D.SANDWICHORDERS SET TOTALPRICE = ? WHERE ID = ?",total,sod.getId());
    }


    private final class SandwichOrderMapper implements RowMapper<SandwichOrder> {
        public SandwichOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
            SandwichOrder sandwichOrder = new SandwichOrder();
            sandwichOrder.setId(rs.getInt("ID"));
            sandwichOrder.setOrderDate(rs.getDate("LOCALDATE").toLocalDate());
            sandwichOrder.setCourse( courseRepository.findCourse(rs.getInt("COURSE")));
            sandwichOrder.setTotalprice(rs.getDouble("TOTALPRICE"));
            return sandwichOrder;
        }
    }
}

