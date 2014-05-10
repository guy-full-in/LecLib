package ru.kpfu.it.leclib.service;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.it.leclib.model.User;

/**
 * Created by Ayrat on 28.04.2014.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}