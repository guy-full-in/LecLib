package ru.kpfu.it.leclib.service;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.it.leclib.model.University;

/**
 * Created by Ayrat on 04.05.2014.
 */
public interface UniversityRepository extends CrudRepository<University, Long> {
    University findByShortTitle(String shortTitle);
}
