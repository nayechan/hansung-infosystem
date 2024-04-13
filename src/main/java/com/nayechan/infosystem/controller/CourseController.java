package com.nayechan.infosystem.controller;

import com.nayechan.infosystem.model.Course;
import com.nayechan.infosystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String getTotalCreditsByYearAndSemester(Model model) {
        Map<String, Integer> creditsByYearAndSemester = courseService.getTotalCreditsByYearAndSemester();
        model.addAttribute("creditsByYearAndSemester", creditsByYearAndSemester);
        return "courses"; // returns the name of the view (courses.jsp)
    }

    @GetMapping("/courseDetails")
    public String getDetailedInformation(@RequestParam(name = "year") int year, @RequestParam(name = "semester") int semester, Model model)
    {
        List<Course> courses = courseService.getCoursesByYearAndSemester(year, semester);
        model.addAttribute("courses", courses);
        return "courseDetails";
    }
}
