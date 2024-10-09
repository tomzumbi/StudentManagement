package org.example.service;

import org.example.model.User;

import java.util.List;

public interface IUserService {

    void addUser(User user);
    List<User> getAllUsers();
    List<User> getUsers();
    void findBy(String username);
}
