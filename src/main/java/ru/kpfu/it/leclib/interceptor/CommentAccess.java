package ru.kpfu.it.leclib.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ru.kpfu.it.leclib.model.Comment;
import ru.kpfu.it.leclib.model.Lecture;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.CommentRepository;
import ru.kpfu.it.leclib.service.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Ayrat on 18.05.2014.
 */
public class CommentAccess extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Long commId = Long.parseLong(pathVariables.get("commId"));
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Comment comment = commentRepository.findOne(commId);
        if (comment.getAuthor().equals(user)) {
            return super.preHandle(request, response, handler);
        }
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
        return false;
    }
}
