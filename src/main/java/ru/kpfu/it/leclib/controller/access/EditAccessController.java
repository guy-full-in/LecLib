package ru.kpfu.it.leclib.controller.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.LectureRepository;
import ru.kpfu.it.leclib.service.UserRepository;
import ru.kpfu.it.leclib.utils.Converter;

import java.util.List;

/**
 * Created by Ayrat on 07.05.2014.
 */
@Controller
@RequestMapping("lecture/{id}/access")
public class EditAccessController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LectureRepository lectureRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getUsersList(@PathVariable Long id, Model model){
        if(lectureRepository.exists(id)){
            model.addAttribute("users", Converter.toList(userRepository.findAll()));
            model.addAttribute("lecture", lectureRepository.findOne(id));
            return "lecture/access";
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editAccess(Lecture lecture, Model  model){
        Lecture oldLecture = lectureRepository.findOne(lecture.getId());
        lecture.setTitle(oldLecture.getTitle());
        lecture.setText(oldLecture.getText());
        lecture.setCreatedAt(oldLecture.getCreatedAt());
        lecture.setUpdatedAt(oldLecture.getUpdatedAt());
        lecture.setAuthor(oldLecture.getAuthor());
        lecture.setReviews(oldLecture.getReviews());
        lecture.setCategory(oldLecture.getCategory());
        lecture.setUniversity(oldLecture.getUniversity());
        lecture.setComments(oldLecture.getComments());
        lectureRepository.save(lecture);
        return "redirect:/lecture/"+lecture.getId();
    }
}
