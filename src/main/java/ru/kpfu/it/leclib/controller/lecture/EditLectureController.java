package ru.kpfu.it.leclib.controller.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.LectureCategory;
import ru.kpfu.it.leclib.model.University;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.LectureCategoryRepository;
import ru.kpfu.it.leclib.service.LectureRepository;
import ru.kpfu.it.leclib.service.UniversityRepository;
import ru.kpfu.it.leclib.service.UserRepository;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Ayrat on 06.05.2014.
 */
@Controller
public class EditLectureController {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    LectureCategoryRepository lectureCategoryRepository;

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/lecture/{id}/edit", method = RequestMethod.GET)
    public String getForm(@PathVariable Long id, Model model){
        if(lectureRepository.exists(id)) {
            Lecture lecture = lectureRepository.findOne(id);
            model.addAttribute("lecture", lecture);

            Iterable<LectureCategory> categories = lectureCategoryRepository.findAll();
            model.addAttribute("categories", categories);

            Iterable<University> universities = universityRepository.findAll();
            model.addAttribute("universities", universities);

            return "lecture/edit";
        }
        return "redirect:/";
    }


    @RequestMapping(value = "lecture/{id}/edit", method = RequestMethod.POST)
    public String update(@Valid Lecture lecture, BindingResult result, @PathVariable Long id, Model model){
        if(!result.hasErrors()){
            Lecture dbLecture = lectureRepository.findOne(id);
            dbLecture.setTitle(lecture.getTitle());
            dbLecture.setText(lecture.getText());
            dbLecture.setCategory(lecture.getCategory());
            dbLecture.setUniversity(lecture.getUniversity());
            dbLecture.setUpdatedAt(new Date());

            lectureRepository.save(dbLecture);
            return "redirect:/lecture/" + id;
        }
        model.addAttribute("lecture", lecture);
        Iterable<LectureCategory> categories = lectureCategoryRepository.findAll();
        model.addAttribute("categories", categories);
        Iterable<University> universities = universityRepository.findAll();
        model.addAttribute("universities", universities);
        return "lecture/edit";
    }
}