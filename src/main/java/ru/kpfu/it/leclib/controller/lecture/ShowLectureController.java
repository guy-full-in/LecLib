package ru.kpfu.it.leclib.controller.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.it.leclib.model.Comment;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.LectureRepository;
import ru.kpfu.it.leclib.service.UserRepository;

import java.util.List;

/**
 * Created by Ayrat on 04.05.2014.
 */
@Controller
public class ShowLectureController {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/lecture/{id}", method = RequestMethod.GET)
    public String showLecture(@PathVariable Long id, Model model){
        if(lectureRepository.exists(id)){
            Lecture lecture = lectureRepository.findOne(id);
            lecture.setReviews(lecture.getReviews()+1);
            lectureRepository.save(lecture);
            model.addAttribute("lecture", lecture);
            model.addAttribute("comments",  lecture.getComments());
            model.addAttribute("comment", new Comment());

            return "/lecture/show";
        }
        return "redirect:/";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showAll(Model model){
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Lecture> myLectures = user.getLectures();
        model.addAttribute("myLectures", myLectures);
        List<Lecture> otherLectures = user.getAvailableLectures();
        model.addAttribute("otherLectures", otherLectures);
        return "lecture/list";
    }
}
