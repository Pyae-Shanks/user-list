package com.userlist.userlist.service;

import com.userlist.userlist.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User saveUser (User user);

    User getUserById(Long id);
    User editUser (User user);

    void deleteUser (Long id);
}
