package be.abis.sandwich.dao.repository;

import be.abis.sandwich.dao.entities.CourseEntity;
import be.abis.sandwich.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends CrudRepository<CourseEntity, Integer> {
    CourseEntity findCourseByTitle(String title);

}
