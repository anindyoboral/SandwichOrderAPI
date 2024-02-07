package be.abis.sandwich.service;

import be.abis.sandwich.model.Person;

import java.io.IOException;
import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();
    Person findPerson(int id);
    void addPerson(Person p) throws IOException;
    void updatePerson(Person p);
    void deletePerson(int id);



}
