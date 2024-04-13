// CourseRegistrationController.java

package com.nayechan.infosystem.controller;

import com.nayechan.infosystem.model.CourseRegistration;
import com.nayechan.infosystem.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class CourseRegistrationController {

    private final CourseRegistrationService courseRegistrationService;

    @Autowired
    public CourseRegistrationController(CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService = courseRegistrationService;
    }

    @GetMapping("/registrationStatus")
    public String showRegistrationStatus(Model model, Principal principal) {
        String username = principal.getName();
        List<CourseRegistration> registrations = courseRegistrationService.getCourseRegistrations(username);
        model.addAttribute("registrations", registrations);
        return "registrationStatus";
    }
    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        // Create a new CourseRegistration object with default values
        if(!model.containsAttribute("courseRegistration"))
        {
            CourseRegistration defaultRegistration =
                    new CourseRegistration(2024, 2, "", "", "", 3);
            model.addAttribute("courseRegistration", defaultRegistration);
        }
        return "registration";
    }

    @PostMapping("/enroll")
    public String enrollCourseRegistration(@ModelAttribute @Valid CourseRegistration courseRegistration,
                                           BindingResult bindingResult,
                                           @RequestParam("category") String category,
                                           Principal principal,
                                           RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            // If there are validation errors, store the form data and binding result as flash attributes
            redirectAttributes.addFlashAttribute("courseRegistration", courseRegistration);
            redirectAttributes.addFlashAttribute("category", category);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.courseRegistration", bindingResult);

            // Redirect back to the registration page to display errors
            return "redirect:/registration";
        }

        // If no errors, proceed with enrollment
        String username = principal.getName();
        courseRegistrationService.enrollCourseRegistration(courseRegistration, username);
        return "redirect:/registrationStatus";
    }
}
