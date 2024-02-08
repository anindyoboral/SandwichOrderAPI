package be.abis.sandwich.repository;

import be.abis.sandwich.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DBCourseRepository implements CourseRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Course> findAllCourses() {
        return jdbcTemplate.query("SELECT * FROM TU0003D.ABISCOURSES",new CourseMapper());
    }

    @Override
    public Course findCourse(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM TU0003D.ABISCOURSES WHERE ID=?",new CourseMapper(),id);
    }

    @Override
    public Course findCourse(String title) {
        return jdbcTemplate.queryForObject("SELECT * FROM TU0003D.ABISCOURSES WHERE TITLE=?",new CourseMapper(),title);
    }

    @Override
    public void addCourse(Course c) {
        jdbcTemplate.update("INSERT INTO TU0003D.ABISCOURSES (ID, TITLE) VALUES ((SELECT MAX(ID)+1 FROM TU0003D.ABISCOURSES),?)",c.getTitle());
    }

    @Override
    public void updateCourse(Course c) {
        jdbcTemplate.update("UPDATE TU0003D.ABISCOURSES t SET t.TITLE = ? WHERE t.ID = ?",c.getTitle(),c.getId());
    }

    @Override
    public void deleteCourse(int id) {
        jdbcTemplate.update("DELETE FROM TU0003D.ABISCOURSES WHERE ID = ?",id);
    }


    private static final class CourseMapper implements RowMapper<Course> {
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course course = new Course();
            course.setTitle(rs.getString("TITLE"));
            course.setId(rs.getInt("ID"));
            return course;
        }
    }

}
