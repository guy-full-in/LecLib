package ru.kpfu.it.leclib.service;

import ru.kpfu.it.leclib.model.User;

/**
 * Created by Ayrat on 29.04.2014.
 */
public interface UserService {
    User saveAsUser(User user);
    User saveAsAdmin(User user);
    boolean exists(String username);
}
