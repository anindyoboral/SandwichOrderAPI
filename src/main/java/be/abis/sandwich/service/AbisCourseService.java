package be.abis.sandwich.service;

import be.abis.sandwich.model.Course;
import be.abis.sandwich.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbisCourseService implements CourseService{

    @Autowired
    CourseRepository cr;

    @Override
    public List<Course> findAllCourses() {
        return cr.findAllCourses();
    }

    @Override
    public Course findCourse(int id) {
        return cr.findCourse(id);
    }

    @Override
    public Course findCourse(String title) {
        return cr.findCourse(title);
    }

    @Override
    public void addCourse(Course c) {
        cr.addCourse(c);
    }

    @Override
    public void updateCourse(Course c) {
        cr.updateCourse(c);
    }

    @Override
    public void deleteCourse(int id) {
        cr.deleteCourse(id);
    }
}
