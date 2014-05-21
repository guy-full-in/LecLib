package ru.kpfu.it.leclib.controller.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.LectureRepository;
import ru.kpfu.it.leclib.service.UserRepository;

import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/university/{univerId}")
public class UniversityController {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getByParam(@PathVariable Long univerId, Model model) {

        List<Lecture> lectures;
        if (univerId != null) {
            lectures = lectureRepository.findByUniversityId(univerId);
            model.addAttribute("university", lectures.get(0).getUniversity().getFullTitle());
        } else {
            lectures = Collections.EMPTY_LIST;
        }

        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Lecture> availableLectures = user.getAvailableLectures();
        availableLectures.addAll(user.getLectures());
        lectures.retainAll(availableLectures);

        model.addAttribute("lectures", lectures);
        return "lecture/university";
    }

}
