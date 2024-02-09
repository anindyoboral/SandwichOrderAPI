package be.abis.sandwich.repository;

import be.abis.sandwich.model.Person;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;


    @Test
    @Order(1)
    public void personCalledJA(){
        String firstName = personRepository.findPerson(1).getFirstName();
        assertEquals("JA",firstName);
    }

    @Test
    @Order(2)
    public void addNewPerson() throws IOException {

        Person p = new Person(2,"Sandy","Schillebeeckx");
        personRepository.addPerson(p);
    }

    @Test
    @Order(3)
    public void updatePerson() throws IOException {

        Person p = personRepository.findPerson(2);
        p.setFirstName("Nicolas");
        personRepository.updatePerson(p);
    }
    @Test
    @Order(4)
    public void deleteAddedPerson(){
        personRepository.deletePerson(2);
    }


}
