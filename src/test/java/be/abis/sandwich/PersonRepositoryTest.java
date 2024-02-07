package be.abis.sandwich;

import be.abis.sandwich.model.Person;
import be.abis.sandwich.repository.PersonRepository;
import org.junit.jupiter.api.MethodOrderer;
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
    public void personCalledJA(){
        String firstName = personRepository.findPerson(1).getFirstName();
        assertEquals("JA",firstName);
    }

    @Test
    public void addNewPerson() throws IOException {

        Person p = new Person(4,"Sandy","Schillebeeckx");
        personRepository.addPerson(p);
    }



}
