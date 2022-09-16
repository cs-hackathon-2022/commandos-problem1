package com.cs.commandos.service;

import com.cs.commandos.model.User;
import com.cs.commandos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User deleteUser(long id) {
        User user = userRepository.getOne(id);
        userRepository.deleteById(id);
        return user;
    }
}
