package be.abis.sandwich.repository;

import be.abis.sandwich.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class DBPersonRepository implements PersonRepository{


    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query("select * from abispersons", new PersonMapper());
    }

    @Override
    public Person findPerson(int id) {
        return jdbcTemplate.queryForObject("select * from abispersons where id=?",new PersonMapper(),id);
    }


    @Override
    public void addPerson(Person p) throws IOException {

        jdbcTemplate.update("insert into abispersons(id,firstname,lastname) values(?,?,?)",p.getPersonId(),p.getFirstName(),p.getLastName());

    }

    @Override
    public void updatePerson(Person p) {
        jdbcTemplate.update("update abispersons set id=?,firstname=?,lastname=? where id=?",p.getPersonId(),p.getFirstName(),p.getLastName());
    }
    @Override
    public void deletePerson(int id) {

        jdbcTemplate.update("delete from abispersons where id=?",id);

    }

    private static final class PersonMapper implements RowMapper<Person> {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setPersonId(rs.getInt("id"));
            person.setFirstName(rs.getString("firstname"));
            person.setLastName(rs.getString("lastname"));
            return person;
        }
    }
}
