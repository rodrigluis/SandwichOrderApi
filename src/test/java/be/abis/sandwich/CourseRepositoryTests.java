package be.abis.sandwich;

import be.abis.sandwich.model.Course;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.repository.CourseRepository;
import be.abis.sandwich.repository.SandwichRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CourseRepositoryTests {
    @Autowired
    CourseRepository courseRepository;

    @Test
    void contextLoads() {
    }
    @Test
    @Order(1)
    void testFindCourseByTitle() {
        Course course = courseRepository.findCourseByTitle("Spring REST API");
        assertNotNull(course);
    }

}
