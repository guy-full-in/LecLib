package ru.kpfu.it.leclib.controller.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.LectureRepository;
import ru.kpfu.it.leclib.service.UserRepository;

import java.util.List;

/**
 * Created by Ayrat on 18.05.2014.
 */
@Controller
@RequestMapping("/lecture/search")
public class SearchLectureController {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String searchByTitle(@RequestParam String title, Model model) {
        List<Lecture> findLectures = lectureRepository.findByTitleLikeIgnoreCase("%"+title+"%");
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Lecture> availableLectures = user.getAvailableLectures();
        availableLectures.addAll(user.getLectures());
        findLectures.retainAll(availableLectures);
        model.addAttribute("lectures", findLectures);
        return "lecture/result";
    }
}
