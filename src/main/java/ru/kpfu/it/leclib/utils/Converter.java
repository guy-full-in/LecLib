package ru.kpfu.it.leclib.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayrat on 07.05.2014.
 */
public class Converter {
    public static <E> List<E> toList(Iterable<E> iterable) {
        if(iterable instanceof List) {
            return (List<E>) iterable;
        }
        ArrayList<E> list = new ArrayList<E>();
        if(iterable != null) {
            for(E e: iterable) {
                list.add(e);
            }
        }
        return list;
    }
}
