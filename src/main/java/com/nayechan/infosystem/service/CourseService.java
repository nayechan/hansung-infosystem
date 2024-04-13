package com.nayechan.infosystem.service;

import com.nayechan.infosystem.dao.CourseDao;
import com.nayechan.infosystem.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    public Course getCourseByCode(String code) {
        return courseDao.getCourseByCode(code);
    }

    public List<Course> getCoursesByYearAndSemester(int year, int semester) {


        return courseDao.getCoursesByYearAndSemester(year, semester);
    }

    public Map<String, Integer> getTotalCreditsByYearAndSemester() {
        List<Course> allCourses = courseDao.getAllCourses();

        Map<String, Integer> creditsByYearAndSemester = new TreeMap<String, Integer>();

        for (Course course : allCourses) {
            String key = course.getYear() + "-" + course.getSemester();
            int credits = creditsByYearAndSemester.getOrDefault(key, 0);
            credits += course.getCredit();
            creditsByYearAndSemester.put(key, credits);
        }

        return creditsByYearAndSemester;
    }
}
