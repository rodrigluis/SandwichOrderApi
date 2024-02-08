package be.abis.sandwich;

import be.abis.sandwich.model.Person;
import be.abis.sandwich.repository.PersonRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonRepositoryTests {
    @Autowired
    PersonRepository personRepository;

    @Test
    void contextLoads() {
    }
    @Test
    @Order(1)
    void testFindPersonByName() {
        Person person = personRepository.findPersonByName("Dirk","Lamote");
        assertNotNull(person);
    }

}
