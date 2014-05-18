package ru.kpfu.it.leclib.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.it.leclib.model.Comment;
import ru.kpfu.it.leclib.service.CommentRepository;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Ayrat on 06.05.2014.
 */
@Controller
@RequestMapping("/lecture/{id}/comment/{commId}/edit")
public class EditCommentController {

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getForm(@PathVariable Long id, @PathVariable Long commId, Model model){
        if(commentRepository.exists(commId)){
            Comment comment = commentRepository.findOne(commId);
            model.addAttribute("comment", comment);
            return "comment/edit";
        }
        return "redirect:/lecture/"+id;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String update(@PathVariable Long id, @PathVariable Long commId,@Valid Comment comment, BindingResult result, Model model){
        if(!result.hasErrors()){
            Comment dbComment = commentRepository.findOne(commId);
            dbComment.setText(comment.getText());
            dbComment.setUpdatedAt(new Date());
            commentRepository.save(dbComment);
            return "redirect:/lecture/"+id;
        }
        comment.setLecture(commentRepository.findOne(commId).getLecture());
        model.addAttribute("comment", comment);
        return "comment/edit";
    }
}
