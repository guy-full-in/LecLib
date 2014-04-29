package ru.kpfu.it.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.it.security.model.User;
import ru.kpfu.it.security.model.UserRole;
import ru.kpfu.it.security.utils.MD5;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ayrat on 29.04.2014.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Transactional
    public User saveAsUser(User user) {
        user.setRole(Arrays.asList(userRoleRepository.findByAuthority("ROLE_USER")));
        String hash = MD5.get(user.getPassword());
        user.setPassword(hash);
        return userRepository.save(user);
    }

    @Transactional
    public User saveAsAdmin(User user) {
        user.setRole(Arrays.asList(userRoleRepository.findByAuthority("ROLE_ADMIN")));
        String hash = MD5.get(user.getPassword());
        user.setPassword(hash);
        return userRepository.save(user);
    }
}
