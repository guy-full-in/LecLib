package ru.kpfu.it.leclib.controller.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.LectureRepository;
import ru.kpfu.it.leclib.service.UserRepository;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ayrat on 21.05.2014.
 */
@Controller
@RequestMapping("/category/{categoryId}")
public class CategoryController {


    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getByParam(@PathVariable Long categoryId, Model model) {

        List<Lecture> lectures;
        if (categoryId != null) {
            lectures = lectureRepository.findByCategoryId(categoryId);
            model.addAttribute("category", lectures.get(0).getCategory().getTitle());
        } else {
            lectures = Collections.EMPTY_LIST;
        }

        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Lecture> availableLectures = user.getAvailableLectures();
        availableLectures.addAll(user.getLectures());
        lectures.retainAll(availableLectures);

        model.addAttribute("lectures", lectures);

        return "lecture/category";
    }

}
