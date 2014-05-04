package ru.kpfu.it.leclib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.LectureCategory;
import ru.kpfu.it.leclib.model.University;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.LectureCategoryRepository;
import ru.kpfu.it.leclib.service.LectureRepository;
import ru.kpfu.it.leclib.service.UniversityRepository;
import ru.kpfu.it.leclib.service.UserRepository;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by Ayrat on 01.05.2014.
 */
@Controller
@RequestMapping("lecture/new")
public class NewLectureController {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    LectureCategoryRepository lectureCategoryRepository;

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getForm(Model model){
        model.addAttribute("lecture", new Lecture());

        Iterable<LectureCategory> categories = lectureCategoryRepository.findAll();
        List<LectureCategory> categoryList = new ArrayList<>();
        for(LectureCategory category : categories){
            categoryList.add(category);
        }
        model.addAttribute("categories", categoryList);

        Iterable<University> universities = universityRepository.findAll();
        List<University> universityList = new ArrayList<>();
        for(University university : universities){
            universityList.add(university);
        }
        model.addAttribute("universities", universityList);

        return "lecture/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Lecture lecture, BindingResult result, Model model){
        if(!result.hasErrors()){
            User author = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            lecture.setAuthor(author);
            lecture.setCreatedAt(new Date());
            lecture.setUpdatedAt(lecture.getCreatedAt());
            lectureRepository.save(lecture);
            return "redirect:/show";
        }
        model.addAttribute("lecture", lecture);
        return "lecture/new";
    }
}
