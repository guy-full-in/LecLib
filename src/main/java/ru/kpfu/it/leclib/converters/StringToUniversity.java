package ru.kpfu.it.leclib.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.kpfu.it.leclib.model.University;
import ru.kpfu.it.leclib.service.UniversityRepository;


/**
 * Created by Ayrat on 04.05.2014.
 */
public class StringToUniversity implements Converter<String, University> {

    @Autowired
    UniversityRepository universityRepository;

    @Override
    public University convert(String s) {
        return universityRepository.findByShortTitle(s);
    }
}
