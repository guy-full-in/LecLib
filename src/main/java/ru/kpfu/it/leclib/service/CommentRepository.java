package ru.kpfu.it.leclib.service;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.it.leclib.model.Comment;

/**
 * Created by Ayrat on 01.05.2014.
 */
public interface CommentRepository  extends CrudRepository <Comment, Long>{
}
