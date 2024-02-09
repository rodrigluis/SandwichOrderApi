package be.abis.sandwich.repository;

import be.abis.sandwich.dao.entities.CourseEntity;
import be.abis.sandwich.dao.repository.JpaCourseRepository;
import be.abis.sandwich.model.Course;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class DBCourseRepository implements CourseRepository {
    @Resource
    JpaCourseRepository courseRepository;

    @Override
    public Course findCourseByTitle(String title) {
        CourseEntity courseEntity = courseRepository.findCourseByTitle(title);
        return toModel(courseEntity);
    }

    private Course toModel(CourseEntity courseEntity) {
        Course course = new Course();
        course.setId(courseEntity.getId());
        course.setTitle(courseEntity.getTitle());
        return course;
    }
}
