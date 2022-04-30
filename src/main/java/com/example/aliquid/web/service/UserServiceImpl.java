package com.example.aliquid.web.service;

import com.example.aliquid.web.models.User;
import com.example.aliquid.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void newUser(User user) {
        userRepository.newUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    @Override
    public void edit(User user) {
        userRepository.edit(user);
    }

    @Override
    public User show(int id) {
        return userRepository.show(id);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.allUsers();
    }
}
