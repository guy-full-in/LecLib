package ru.kpfu.it.leclib.controller.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.it.leclib.service.LectureRepository;

/**
 * Created by Ayrat on 06.05.2014.
 */
@Controller
public class DeleteLectureController {

    @Autowired
    LectureRepository lectureRepository;

    @RequestMapping(value = "lecture/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable Long id, Model model){
        if(lectureRepository.exists(id)){
            lectureRepository.delete(id);
        }
        return "redirect:/";
    }

}
