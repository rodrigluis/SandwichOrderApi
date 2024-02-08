package be.abis.sandwich.service;

import be.abis.sandwich.model.Course;
import be.abis.sandwich.repository.CourseRepository;
import be.abis.sandwich.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbisCourseService implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course findCourseByTitle(String title) {
        return courseRepository.findCourseByTitle(title);
    }
}
