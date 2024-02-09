package be.abis.sandwich.repository;

import be.abis.sandwich.dao.entities.PersonEntity;
import be.abis.sandwich.dao.repository.JpaPersonRepository;
import be.abis.sandwich.model.Person;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class DBPersonRepository implements PersonRepository {
    @Resource
    JpaPersonRepository personRepository;

    @Override
    public Person findPersonByName(String firstName, String lastName) {
        PersonEntity personEntity = personRepository.findPersonByFirstNameAndLastName(firstName, lastName);
        return toModel(personEntity);
    }

    private Person toModel (PersonEntity personEntity) {
        Person person = new Person();
        person.setId(personEntity.getId());
        person.setFirstName(personEntity.getFirstName());
        person.setLastName(personEntity.getLastName());
        return person;
    }

}
