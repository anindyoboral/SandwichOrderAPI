package be.abis.sandwich.service;

import be.abis.sandwich.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourses();
    Course findCourse(int id) ;
    Course findCourse(String title);
    void addCourse(Course c);
    void updateCourse(Course c);
    void deleteCourse(int id);

}
