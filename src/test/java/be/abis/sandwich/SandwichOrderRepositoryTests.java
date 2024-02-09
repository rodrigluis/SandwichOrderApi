package be.abis.sandwich;

import be.abis.sandwich.enumeration.BreadType;
import be.abis.sandwich.model.*;
import be.abis.sandwich.repository.CourseRepository;
import be.abis.sandwich.repository.PersonRepository;
import be.abis.sandwich.repository.SandwichOrderRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SandwichOrderRepositoryTests {
    @Autowired
    SandwichOrderRepository sandwichOrderRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    CourseRepository courseRepository;

    @Test
    void contextLoads() {
    }
    @Test
    @Order(1)
    void testCreateSandwichOrder() {
        SandwichOrder sandwichOrder = new SandwichOrder();
        sandwichOrder.setOrderDate(LocalDate.now());
        Course course = courseRepository.findCourseByTitle("Spring REST API");
        sandwichOrder.setCourse(course);

        SandwichOrderDetail sandwichOrderDetail = new SandwichOrderDetail();
        sandwichOrderDetail.setBreadType(BreadType.BROWN);
        sandwichOrderDetail.setComments("I like it");
        Sandwich sandwich = new Sandwich();
        sandwich.setId(1);
        sandwichOrderDetail.setSandwich(sandwich);
        Person person = personRepository.findPersonByName("Dirk","Lamote");
        sandwichOrderDetail.setPerson(person);

        sandwichOrder.getSandwichOrderDetails().add(sandwichOrderDetail);
        sandwichOrderRepository.createSandwichOrder(sandwichOrder);


    }
    @Test
    @Order(2)
    void testUpdateSandwichOrder() {
    }
    @Test
    @Order(3)
    void testDeleteSandwichOrder() {
    }
}
