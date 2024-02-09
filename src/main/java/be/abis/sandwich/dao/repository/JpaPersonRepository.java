package be.abis.sandwich.dao.repository;

import be.abis.sandwich.dao.entities.PersonEntity;
import be.abis.sandwich.model.Course;
import be.abis.sandwich.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPersonRepository extends CrudRepository<PersonEntity, Integer> {
    PersonEntity findPersonByFirstNameAndLastName(String firstName, String lastName);

}
