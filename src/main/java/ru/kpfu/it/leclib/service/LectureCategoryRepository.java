package ru.kpfu.it.leclib.service;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.it.leclib.model.LectureCategory;

/**
 * Created by Ayrat on 04.05.2014.
 */
public interface LectureCategoryRepository extends CrudRepository<LectureCategory, Long>{
    LectureCategory findByTitle(String title);
}
