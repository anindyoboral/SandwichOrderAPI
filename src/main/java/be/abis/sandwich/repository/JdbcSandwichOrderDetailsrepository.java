package be.abis.sandwich.repository;

import be.abis.sandwich.enumeration.BreadType;
import be.abis.sandwich.model.Person;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcSandwichOrderDetailsrepository implements  SandwichOrderDetailRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PersonRepository personRepository;



    @Override
    public void addSandwichOrderDetail(SandwichOrderDetail sod) {

        jdbcTemplate.update("insert into  sandwichorderdetails(amount,breadtype,vegetables,person,sandwichorder,comment,sandwichname)\n" +
                "values(?,?,?,?,?,?)" , sod.getAmount(),sod.getBreadType(),sod.isVegetables(),sod.getPerson().getPersonId(),sod.getSandwichOrder().getId(),sod.getComment(),sod.getSandwich().getName());

    }

    @Override
    public List<SandwichOrderDetail> findSandwichorderDetailsById(int id) {
        return jdbcTemplate.query("select * from  sandwichorderdetails where id=?",new JdbcSandwichOrderDetailsrepository.SandwichOrderDetailsMapper(),id);
    }



    private final class SandwichOrderDetailsMapper implements RowMapper<SandwichOrderDetail> {
        public SandwichOrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
            SandwichOrderDetail sandwichOrderDetail = new SandwichOrderDetail();

            sandwichOrderDetail.setAmount(rs.getInt("AMOUNT"));

            sandwichOrderDetail.setComment(rs.getString("COMMENT"));

            Sandwich sandwich = new Sandwich();
            sandwich.setName(rs.getString("SANDWICHNAME"));
            sandwichOrderDetail.setSandwich(sandwich);

            String veggies = rs.getString("VEGETABLES");
            if (veggies.equals("Y"))
                sandwichOrderDetail.setVegetables(true);
            else
                sandwichOrderDetail.setVegetables(false);

            String breadType = rs.getString("BREADTYPE");
             if (breadType.equals(BreadType.BROWN)){
                 sandwichOrderDetail.setBreadType(BreadType.BROWN);
             }else
                 sandwichOrderDetail.setBreadType(BreadType.WHITE);

             sandwichOrderDetail.setPerson(personRepository.findPerson(rs.getInt("PERSON")));

             return  sandwichOrderDetail;

        }
    }


}