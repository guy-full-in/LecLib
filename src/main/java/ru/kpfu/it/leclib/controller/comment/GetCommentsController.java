package ru.kpfu.it.leclib.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.leclib.model.Comment;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.service.CommentRepository;
import ru.kpfu.it.leclib.service.LectureRepository;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ayrat on 18.05.2014.
 */
@Controller
public class GetCommentsController {

    @Autowired
    LectureRepository lectureRepository;

    @RequestMapping(value = "/lecture/{id}/comments", method = RequestMethod.GET)
    public @ResponseBody List<Comment> getComments(@PathVariable Long id, Model model){
        if (lectureRepository.exists(id)){
            return lectureRepository.findOne(id).getComments();
        }
        return Collections.emptyList();
    }
}
