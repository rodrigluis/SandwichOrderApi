package be.abis.sandwich.repository;

import be.abis.sandwich.model.Course;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class DBCourseRepository implements CourseRepository {
    @Resource
    JpaCourseRepository courseRepository;

    @Override
    public Course findCourseByTitle(String title) {
        Course course = courseRepository.findCourseByTitle(title);
        return course;
    }
}
