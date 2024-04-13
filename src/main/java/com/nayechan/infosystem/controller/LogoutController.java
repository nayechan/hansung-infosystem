package com.nayechan.infosystem.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        // Invalidate the current user's authentication
        SecurityContextHolder.clearContext();

        // Perform any additional logout actions here
        return "redirect:/"; // Redirect to the main page after logout
    }
}
