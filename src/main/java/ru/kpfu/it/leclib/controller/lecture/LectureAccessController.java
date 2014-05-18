package ru.kpfu.it.leclib.controller.lecture;

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
public class LectureAccessController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LectureRepository lectureRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getUsersList(@PathVariable Long id, Model model){
        if(lectureRepository.exists(id)){
            Lecture lecture = lectureRepository.findOne(id);
            List<User> users = Converter.toList(userRepository.findAll());
            users.remove(lecture.getAuthor());
            model.addAttribute("users", users);
            model.addAttribute("lecture", lecture);
            return "lecture/access";
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editAccess(@PathVariable Long id, Lecture lecture, Model  model){
        Lecture dbLecture = lectureRepository.findOne(id);
        dbLecture.setReaders(lecture.getReaders());
        lectureRepository.save(dbLecture);
        return "redirect:/lecture/"+id;
    }
}
