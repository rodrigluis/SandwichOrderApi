package be.abis.sandwich.service;

import be.abis.sandwich.model.Person;

public interface PersonService {
    Person findPersonByName(String firstName, String lastName);
}
