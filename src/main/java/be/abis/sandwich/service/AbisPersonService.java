package be.abis.sandwich.service;

import be.abis.sandwich.model.Person;
import be.abis.sandwich.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbisPersonService implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person findPersonByName(String firstName, String lastName) {
        return personRepository.findPersonByName(firstName, lastName);
    }
}
