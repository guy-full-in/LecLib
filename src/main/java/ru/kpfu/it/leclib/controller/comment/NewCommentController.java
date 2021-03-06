package ru.kpfu.it.leclib.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.leclib.controller.lecture.ShowLectureController;
import ru.kpfu.it.leclib.model.Comment;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.CommentRepository;
import ru.kpfu.it.leclib.service.LectureRepository;
import ru.kpfu.it.leclib.service.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Ayrat on 06.05.2014.
 */
@Controller
@RequestMapping("lecture/{id}/comments/new")
public class NewCommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LectureRepository lectureRepository;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String create(@PathVariable Long id, @Valid Comment comment, BindingResult result){
        if(!result.hasErrors()){
            User author = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            comment.setAuthor(author);
            comment.setLecture(lectureRepository.findOne(id));
            comment.setCreatedAt(new Date());
            comment.setUpdatedAt(comment.getCreatedAt());
            commentRepository.save(comment);
            return "ok";
        }
        return "Error: not valid comment";
    }

}
