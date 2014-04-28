package ru.kpfu.it.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.it.security.model.User;
import ru.kpfu.it.security.service.UserRepository;

import javax.validation.Valid;

/**
 * Created by Ayrat on 23.04.2014.
 */
@Controller
@RequestMapping("/registr")
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getForm(Model model){
        model.addAttribute("user",new User());
        return "registr";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registr(@Valid User user,
                               BindingResult result,
                               Model model){
        if(!user.getPassword().equals(user.getConfirmPassword())){
            result.addError(new ObjectError("confirmPassword", "Password not confirm"));
            model.addAttribute("user", user);
            return "registr";
        }
        if (!result.hasErrors()) {
            return "redirect:/";
        } else {
            model.addAttribute("user", user);
            return "registr";
        }
    }
}
