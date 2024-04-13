package com.nayechan.infosystem.dao;
import com.nayechan.infosystem.model.CourseRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
public class CourseRegistrationDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void enrollCourseRegistration(CourseRegistration courseRegistration, String username) {
        String sql = "INSERT INTO course_registration (username, year, semester, name, category, professor, credit) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                username,
                courseRegistration.getYear(),
                courseRegistration.getSemester(),
                courseRegistration.getName(),
                courseRegistration.getCategory(),
                courseRegistration.getProfessor(),
                courseRegistration.getCredit()
        );
    }

    public List<CourseRegistration> getCourseRegistrations(String username) {
        String sql = "SELECT * FROM course_registration WHERE username = ? ORDER BY year ASC, semester ASC, name ASC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CourseRegistration.class), username);
    }
}
