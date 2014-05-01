package ru.kpfu.it.leclib.service;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.it.leclib.model.Lecture;

/**
 * Created by Ayrat on 01.05.2014.
 */
public interface LectureRepository extends CrudRepository<Lecture, Long> {
}
