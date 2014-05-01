package ru.kpfu.it.leclib.service;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.it.leclib.model.UserRole;

/**
 * Created by Ayrat on 29.04.2014.
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    UserRole findByAuthority(String authority);
}
