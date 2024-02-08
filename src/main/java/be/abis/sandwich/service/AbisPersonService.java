package be.abis.sandwich.service;

import be.abis.sandwich.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AbisPersonService implements PersonService


{
    @Override
    public List<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person findPerson(int id) {
        return null;
    }

    @Override
    public void addPerson(Person p) throws IOException {

    }

    @Override
    public void updatePerson(Person p) {

    }

    @Override
    public void deletePerson(int id) {

    }
}
