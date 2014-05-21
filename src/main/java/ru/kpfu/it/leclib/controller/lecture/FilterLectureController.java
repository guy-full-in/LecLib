package ru.kpfu.it.leclib.controller.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.LectureRepository;
import ru.kpfu.it.leclib.service.UserRepository;

import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/lecture")
public class FilterLectureController {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Lecture> getByParam(@RequestParam(value = "byCategory", required = false) String category, @RequestParam(value = "byUniversity", required = false) String university) {

        List<Lecture> filterLectures;
        if (category != null && !category.equals("")) {
            filterLectures = lectureRepository.findByCategoryTitle(category);
        } else if (university != null && !university.equals("")) {
            filterLectures = lectureRepository.findByUniversityShortTitle(university);
        } else {
            return Collections.EMPTY_LIST;
        }

        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Lecture> availableLectures = user.getAvailableLectures();
        availableLectures.addAll(user.getLectures());
        filterLectures.retainAll(availableLectures);

        return filterLectures;
    }

}
