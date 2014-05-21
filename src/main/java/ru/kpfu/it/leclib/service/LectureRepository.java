package ru.kpfu.it.leclib.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.it.leclib.model.Lecture;

import java.util.List;

/**
 * Created by Ayrat on 01.05.2014.
 */
public interface LectureRepository extends CrudRepository<Lecture, Long> {
    List<Lecture> findByTitleLikeIgnoreCase(String title);

    List<Lecture> findByCategoryId(Long id);

    List<Lecture> findByUniversityId(Long id);
}
