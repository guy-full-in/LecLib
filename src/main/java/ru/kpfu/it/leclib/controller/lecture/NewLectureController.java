package ru.kpfu.it.leclib.controller.lecture;

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
import ru.kpfu.it.leclib.utils.Converter;

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
        model.addAttribute("categories", categories);

        Iterable<University> universities = universityRepository.findAll();
        model.addAttribute("universities", universities);

        return "lecture/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Lecture lecture, BindingResult result, Model model){
        if(!result.hasErrors()){
            User author = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            lecture.setAuthor(author);
            lecture.setCreatedAt(new Date());
            lecture.setUpdatedAt(lecture.getCreatedAt());
            List<User> readers = Converter.toList(userRepository.findAll());
            readers.remove(author);
            lecture.setReaders(readers);
            lecture = lectureRepository.save(lecture);
            return "redirect:/lecture/" + lecture.getId();
        }
        model.addAttribute("lecture", lecture);
        Iterable<LectureCategory> categories = lectureCategoryRepository.findAll();
        model.addAttribute("categories", categories);
        Iterable<University> universities = universityRepository.findAll();
        model.addAttribute("universities", universities);
        return "lecture/new";
    }
}
