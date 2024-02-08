package be.abis.sandwich.service;

import be.abis.sandwich.model.Course;

public interface CourseService {
    Course findCourseByTitle(String title);
}
