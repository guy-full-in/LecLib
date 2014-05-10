package ru.kpfu.it.leclib.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.it.leclib.service.CommentRepository;

/**
 * Created by Ayrat on 07.05.2014.
 */
@Controller
public class DeleteCommentController {

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(value = "lecture/{lecId}/comment/{commId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable Long lecId, @PathVariable Long commId, Model model){
        commentRepository.delete(commId);
        return "redirect:/lecture/"+lecId;
    }

}
