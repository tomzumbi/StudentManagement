package org.example.service;

import org.example.model.User;

public interface IUSerService {
    boolean register(User user);
    boolean checkUsername(String username);
    User findByUserName(String userName);
    boolean forgetPassword(User user);
}
