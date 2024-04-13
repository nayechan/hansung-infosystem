package com.nayechan.infosystem.dao;

import com.nayechan.infosystem.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CourseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses ORDER BY year ASC, semester ASC, name ASC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class));
    }

    public Course getCourseByCode(String code) {
        String sql = "SELECT * FROM courses WHERE code = ? ORDER BY year ASC, semester ASC, name ASC";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Course.class), code);
    }

    public List<Course> getCoursesByYearAndSemester(int year, int semester) {
        String sql = "SELECT * FROM courses WHERE year = ? AND semester = ? ORDER BY year ASC, semester ASC, name ASC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class), year, semester);
    }
}
