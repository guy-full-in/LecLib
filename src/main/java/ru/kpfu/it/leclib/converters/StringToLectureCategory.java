package ru.kpfu.it.leclib.converters;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.it.leclib.model.LectureCategory;
import ru.kpfu.it.leclib.service.LectureCategoryRepository;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Ayrat on 04.05.2014.
 */
public class StringToLectureCategory implements Converter<String, LectureCategory>{

    @Autowired
    LectureCategoryRepository lectureCategoryRepository;


    public LectureCategory convert(String s) {
        return lectureCategoryRepository.findByTitle(s);
    }
}
