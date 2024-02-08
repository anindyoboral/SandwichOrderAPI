package be.abis.sandwich.repository;

import be.abis.sandwich.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class AllRepositoriesTest {

    @Autowired
    CourseRepository cr;
    @Autowired
    PersonRepository pr;
    @Autowired
    SandwichOrderRepository sor;
    @Autowired
    SandwichOrderDetailRepository sodr;

    @Test
    void testInit() {
        Course c = new Course();
        c.setTitle("Java advanced");
        cr.addCourse(c);
        c.setTitle("Java");
        cr.addCourse(c);
    }

}