package com.example.aliquid.web.repository;

import com.example.aliquid.web.models.User;

import java.util.List;

public interface UserRepository {
    void newUser(User user);

    void delete(int id);

    void edit(User user);

    User show(int id);

    List<User> allUsers();
}
