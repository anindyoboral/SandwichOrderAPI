package be.abis.sandwich.repository;


import be.abis.sandwich.model.Person;

import java.io.IOException;
import java.util.List;

public interface PersonRepository {

    List<Person> getAllPersons();
    Person findPerson(int id);
    void addPerson(Person p) throws IOException;
    void updatePerson(Person p);
    void deletePerson(int id);
}
