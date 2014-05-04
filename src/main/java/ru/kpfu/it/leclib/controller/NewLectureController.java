package ru.kpfu.it.leclib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.LectureCategory;
import ru.kpfu.it.leclib.model.University;
import ru.kpfu.it.leclib.service.LectureCategoryRepository;
import ru.kpfu.it.leclib.service.LectureRepository;
import ru.kpfu.it.leclib.service.UniversityRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(method = RequestMethod.GET)
    public String getForm(Model model){
        model.addAttribute("lecture", new Lecture());

        Iterable<LectureCategory> categories = lectureCategoryRepository.findAll();
        Map<String, LectureCategory> categoryMap = new HashMap<>();
        for(LectureCategory category : categories){
            categoryMap.put(category.getTitle(), category);
        }
        model.addAttribute("categories", categoryMap);

        Iterable<University> universities = universityRepository.findAll();
        Map<String, University> universityMap = new HashMap<>();
        for(University university : universities){
            universityMap.put(university.getShortTitle(),university);
        }
        model.addAttribute("universities", universityMap);

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
