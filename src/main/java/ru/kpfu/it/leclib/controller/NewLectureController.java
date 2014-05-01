package ru.kpfu.it.leclib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.service.LectureRepository;

import javax.validation.Valid;

/**
 * Created by Ayrat on 01.05.2014.
 */
@Controller
@RequestMapping("lecture/new")
public class NewLectureController {

    @Autowired
    LectureRepository lectureRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getForm(Model model){
        model.addAttribute("lecture", new Lecture());
        return "lecture/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Lecture lecture, BindingResult result, Model model){
        if(!result.hasErrors()){
            lectureRepository.save(lecture);
            return "redirect: /show";
        }
        model.addAttribute("lecture", lecture);
        return "lecture/new";
    }
}
