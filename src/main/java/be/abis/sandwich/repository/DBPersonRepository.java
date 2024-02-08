package be.abis.sandwich.repository;

import be.abis.sandwich.model.Person;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class DBPersonRepository implements PersonRepository {
    @Resource
    JpaPersonRepository personRepository;

    @Override
    public Person findPersonByName(String firstName, String lastName) {
        Person person = personRepository.findPersonByFirstNameAndLastName(firstName, lastName);
        return person;
    }
}
