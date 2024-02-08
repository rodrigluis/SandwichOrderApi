package be.abis.sandwich.repository;

import be.abis.sandwich.model.Course;
import be.abis.sandwich.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPersonRepository extends CrudRepository<Person, Integer> {
    Person findPersonByFirstNameAndLastName(String firstName, String lastName);
}
