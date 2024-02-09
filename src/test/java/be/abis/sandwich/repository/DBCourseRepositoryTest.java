package be.abis.sandwich.repository;

import be.abis.sandwich.model.Course;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DBCourseRepositoryTest {

    @Autowired
    CourseRepository cr;

    @Test
    @Order(1)
    void findAllCourses() {
        assertTrue(cr.findAllCourses().size() > 0);
    }

    @Test
    @Order(2)
    void findCourseById() {
        assertEquals("Java advanced", cr.findCourse(0).getTitle());
    }

    @Test
    @Order(3)
    void findCourseByName() {
        assertEquals(1, cr.findCourse("Java").getId());
    }

    @Test
    @Order(4)
    void addCourse() {
        String testCourseTitle = "Test course";
        Course c = cr.findCourse(0);
        c.setTitle(testCourseTitle);
        cr.addCourse(c);
        assertEquals(testCourseTitle, cr.findCourse(testCourseTitle).getTitle());
    }

    @Test
    @Order(5)
    void updateCourse() {
        String oldCourseTitle = "Test course";
        String newCourseTitle = "New test course";
        Course c = cr.findCourse(oldCourseTitle);
        c.setTitle(newCourseTitle);
        cr.updateCourse(c);
        assertEquals(newCourseTitle, cr.findCourse(newCourseTitle).getTitle());
    }

    @Test
    @Order(6)
    void deleteCourse() {
        String testCourseTitle = "New test course";
        Course c = cr.findCourse(testCourseTitle);
        cr.deleteCourse(c.getId());

    }
}