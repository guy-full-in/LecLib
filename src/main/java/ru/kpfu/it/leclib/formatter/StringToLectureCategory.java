package ru.kpfu.it.leclib.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import ru.kpfu.it.leclib.model.LectureCategory;
import ru.kpfu.it.leclib.service.LectureCategoryRepository;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Ayrat on 04.05.2014.
 */
public class StringToLectureCategory implements Formatter<LectureCategory> {

    @Autowired
    LectureCategoryRepository lectureCategoryRepository;


    @Override
    public LectureCategory parse(String s, Locale locale) throws ParseException {
        return lectureCategoryRepository.findOne(Long.parseLong(s));
    }

    @Override
    public String print(LectureCategory lectureCategory, Locale locale) {
        return lectureCategory.getTitle();
    }
}
