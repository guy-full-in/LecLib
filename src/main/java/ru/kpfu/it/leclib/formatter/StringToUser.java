package ru.kpfu.it.leclib.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import ru.kpfu.it.leclib.model.User;
import ru.kpfu.it.leclib.service.UserRepository;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Ayrat on 07.05.2014.
 */
public class StringToUser implements Formatter<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public User parse(String s, Locale locale) throws ParseException {
        return userRepository.findOne(Long.parseLong(s));
    }

    @Override
    public String print(User user, Locale locale) {
        return user.getUsername();
    }
}
