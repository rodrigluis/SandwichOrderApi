package be.abis.sandwich.repository;

import be.abis.sandwich.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends CrudRepository<Course, Integer> {
    Course findCourseByTitle(String title);

}
