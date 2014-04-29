package ru.kpfu.it.security.service;

import ru.kpfu.it.security.model.User;

/**
 * Created by Ayrat on 29.04.2014.
 */
public interface UserService {
    User saveAsUser(User user);
    User saveAsAdmin(User user);
}
