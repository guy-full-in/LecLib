package ru.kpfu.it.security.service;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.it.security.model.User;

/**
 * Created by Ayrat on 28.04.2014.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
