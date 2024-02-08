package be.abis.sandwich.service;

import be.abis.sandwich.model.Person;
import be.abis.sandwich.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

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

        personRepository.addPerson(p);

    }

    @Override
    public void updatePerson(Person p) {

        personRepository.updatePerson(p);
    }

    @Override
    public void deletePerson(int id) {

        personRepository.deletePerson(id);
    }
}
