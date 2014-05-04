package ru.kpfu.it.leclib.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import ru.kpfu.it.leclib.model.University;
import ru.kpfu.it.leclib.service.UniversityRepository;

import java.text.ParseException;
import java.util.Locale;


/**
 * Created by Ayrat on 04.05.2014.
 */
public class StringToUniversity implements Formatter<University> {

    @Autowired
    UniversityRepository universityRepository;

    @Override
    public University parse(String s, Locale locale) throws ParseException {
        return universityRepository.findOne(Long.parseLong(s));
    }

    @Override
    public String print(University university, Locale locale) {
        return university.getShortTitle();
    }
}
