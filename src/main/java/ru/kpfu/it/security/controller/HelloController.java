package ru.kpfu.it.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Ayrat on 22.04.2014.
 */

@Controller
public class HelloController {

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Spring Security Hello World");
        model.addAttribute("message", "This is welcome page!");
        return "hello";
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("title", "Spring Security Hello World");
        model.addAttribute("message", "This is protected page!");
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout) {
        if (error != null){
            model.addAttribute("error", "Invalid username and password");
        }

        if (logout != null){
            model.addAttribute("msg", "You've been logged out successfully.");
        }

        return "login";
    }
}
