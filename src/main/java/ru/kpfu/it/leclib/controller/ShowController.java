package ru.kpfu.it.leclib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ayrat on 01.05.2014.
 */
@Controller
public class ShowController {

    @RequestMapping(value = {"/show**", "/"}, method = RequestMethod.GET)
    public String show(Model model){
        model.addAttribute("title", "Страница просмотра");
        model.addAttribute("message", "Здесь будем смотреть на все лекции, два раздела: мои лекции и чужие");
        return "show";
    }
}
