package be.abis.sandwich.repository;

import be.abis.sandwich.model.Course;
import be.abis.sandwich.model.Sandwich;

public interface CourseRepository {
    Course findCourseByTitle(String title);

}
