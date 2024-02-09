package be.abis.sandwich.service;

import be.abis.sandwich.model.Person;
import be.abis.sandwich.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AbisPersonService implements PersonService


{

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    @Override
    public Person findPerson(int id) {
        return personRepository.findPerson(id);
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
