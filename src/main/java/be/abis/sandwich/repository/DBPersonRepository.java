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
public class DBPersonRepository implements PersonRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query("select * from abispersons", new PersonMapper());
    }

    @Override
    public Person findPerson(int id) {
        return jdbcTemplate.queryForObject("select * from abispersons where personId=?", new PersonMapper(), id);
    }


    @Override
    public void addPerson(Person p) throws IOException {

        jdbcTemplate.update("insert into abispersons(personId,firstname,lastname) values(?,?,?)", p.getPersonId(), p.getFirstName(), p.getLastName());

    }

    @Override
    public void updatePerson(Person p) {
        jdbcTemplate.update("UPDATE TU0003D.ABISPERSONS SET FIRSTNAME = ? , LASTNAME = ? WHERE PERSONID = ?", p.getFirstName(), p.getLastName(), p.getPersonId());
    }

    @Override
    public void deletePerson(int id) {
        jdbcTemplate.update("DELETE FROM TU0003D.ABISPERSONS WHERE PERSONID = ?", id);
    }

    private static final class PersonMapper implements RowMapper<Person> {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setPersonId(rs.getInt("personId"));
            person.setFirstName(rs.getString("firstname"));
            person.setLastName(rs.getString("lastname"));
            return person;
        }
    }
}
