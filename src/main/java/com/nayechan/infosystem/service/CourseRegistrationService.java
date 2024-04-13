package com.nayechan.infosystem.service;

import com.nayechan.infosystem.dao.CourseRegistrationDao;
import com.nayechan.infosystem.model.CourseRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseRegistrationService {

    private final CourseRegistrationDao courseRegistrationDao;

    @Autowired
    public CourseRegistrationService(CourseRegistrationDao courseRegistrationDao) {
        this.courseRegistrationDao = courseRegistrationDao;
    }

    public void enrollCourseRegistration(CourseRegistration courseRegistration, String username) {
        courseRegistrationDao.enrollCourseRegistration(courseRegistration, username);
    }

    public List<CourseRegistration> getCourseRegistrations(String username) {
        List<CourseRegistration> courseRegistrations = courseRegistrationDao.getCourseRegistrations(username);
        courseRegistrations.sort((a, b)->{
            if(a.getYear() != b.getYear())
            {
                return Integer.compare(a.getYear(), b.getYear());
            }

            else if(a.getSemester() != b.getSemester())
            {
                return Integer.compare(a.getSemester(), b.getSemester());
            }

            else
            {
                return a.getName().compareTo(b.getName());
            }
        });
        return courseRegistrations;
    }
}
