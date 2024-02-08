package be.abis.sandwich.repository;


import be.abis.sandwich.model.Person;

public interface PersonRepository {
    Person findPersonByName(String firstName, String LastName);

}
